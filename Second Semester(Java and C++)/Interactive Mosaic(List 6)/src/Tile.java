import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/** 
 * This class is responsible for everything that has to do with tiles, which are rectangles and also threads.
 * When this thread starts running it changes color in 2 ways based on the probability imputed by user.
 * It can either change color randomly or based on the colors of its neighbours
 * This happens every [0.5delay, 1.5delay]. User can also click the tile to set it as not active.
 * Tiles which aren't active are completly white on the screen and do not count as neighbours.
 * Threads are synchronized properly thanks to the shared mutex.
 */
public class Tile extends Rectangle implements Runnable {
    //***** Variables *****
    /**
     * the tile changes color every [0.5delay, 1.5delay]
     */
    private final int delay;

    /**
     * values in range [0.0, 1.0], 
     * probability for random color change: p, 
     * probability for color change based on neighbours: 1 - p
     */
    private final double probability;

    /**
     * tile's x coordinate
     */
    private final int x;
    
    /**
     * tile's y coordinate
     */
    private final int y;

    /**
     * max possible value for x coordinate
     */
    private final int maxX;

    /**
     * max possible value for y coordinate
     */
    private final int maxY;

    /**
     * mutex object for appropriate synchronization, it is shared among all the tiles
     */
    private final Object mutex;

    /**
     * tells if the tile is active
     */
    private boolean active = true;


    //***** Methods *****
    /**
     * Creates a Tile object and sets mouse event for it to allow user to change whether it's active
     * 
     * @param sideWidth rectangle's side width
     * @param sideHeight rectangle's side height
     * @param delay tile changes color every [0.5delay, 1.5delay]
     * @param probability values [0, 1], 
     *                    probability for random color change: p, 
     *                    probability for color change based on neighbours: 1 - p
     * @param x tile's x coordinate
     * @param y tile's y coordinate
     * @param boardWidth width of the board with tiles
     * @param boardHeight height of the board with tiles
     * @param mutex mutex object for appropriate synchronization, it is shared among all the tiles
     */
    public Tile(double sideWidth, double sideHeight, int delay, double probability, int x, int y, int boardWidth, int boardHeight
    , Object mutex) {
        super(sideWidth, sideHeight);
        setFill(RNG.getRandomColor());

        this.delay = delay;
        this.probability = probability;
        this.x = x;
        this.y = y;
        this.maxX = boardWidth - 1;
        this.maxY = boardHeight - 1;
        this.mutex = mutex;

        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                e.consume();
                Tile.this.setActive();
            }
        });
    }

    /**
     * This method is responisble for everything the tile does after starting the thread.
     * It changes its colors in 2 ways after delay and disables this thread when it's not active
     */
    @Override
    public void run() {
        while (true) {
            try {
                synchronized (this) {
                    while (!active) {
                        wait();
                    }
                }

                Thread.sleep(RNG.getRandomNumber(delay), 0);
            }
            catch (Exception ex) {
                System.out.println("interrupted");
            }

            if (RNG.getRandomNumber() <= probability) {
                    setColor(RNG.getRandomColor());
            } 
            else {
                    Color newColor = getNewColor();
                    setColor(newColor);
            }
        }
    }

    /**
     * This method changes the color of this tile 
     * 
     * @param color new color to set for the tile
     */
    private void setColor(Color color) {
        synchronized (mutex) {
            System.out.println("Start: #" + x + "," + y);
            if (active) Platform.runLater(() -> setFill(color));
            System.out.println("End: #" + x + "," + y);
        }
    }

    /**
     * Returns the color of this tile
     * 
     * @return color of this tile
     */
    public Color getColor() {
        synchronized (mutex) {
            System.out.println("Start: #" + x + "," + y);
            System.out.println("End: #" + x + "," + y);
            return (Color) getFill();
        }
    }

    /**
     * This method calculates a new color based on the colors of this thread's active neighbours
     * 
     * @return new color
     */
    private Color getNewColor() {
        //Get neighbours
        Tile[] tiles = new Tile[4];
        tiles[0] = getTile(x, getNeighbourIndex(y, maxY, true), (Pane) getParent()); //up
        tiles[1] = getTile(getNeighbourIndex(x, maxX, true), y, (Pane) getParent()); //right
        tiles[2] = getTile(x, getNeighbourIndex(y, maxY, false), (Pane) getParent()); //down
        tiles[3] = getTile(getNeighbourIndex(x, maxX, false), y, (Pane) getParent()); //left

        //Get average color
        double red = 0;
        double green = 0;
        double blue = 0;
        int activeNeighbours = 0;
        Color currentColor;
        for (Tile tile : tiles) {
            if (tile.isActive()) {
                currentColor = tile.getColor();
                red += currentColor.getRed();
                blue+= currentColor.getBlue();
                green += currentColor.getGreen();
                activeNeighbours++;
            }
        }

        if (activeNeighbours != 0) {
            red /= activeNeighbours;
            blue /= activeNeighbours;
            green /= activeNeighbours;
        } 
        else {
            return getColor();
        }

        return new Color(red, green, blue, 1.0);
    }

    /**
     * This method returns a tile object based on its coordinates
     * 
     * @param x tile's x coordinate
     * @param y tile's y coordinate
     * @param pane the pane on which all the tiles are
     * 
     * @return tile with coordinates x,y
     */
    private Tile getTile(int x, int y, Pane pane) {
        return (Tile) pane.lookup("#" + x + "," + y);
    }
    
    /**
     * This method returs one coordinate of this tile's neighbour.
     *        It is necessary because the board the tiles are on is a torus
     * 
     * @param cord x/y coordinate
     * @param maxValue max allowed value for that coordinate
     * @param add true for top/right, false for down/left
     * 
     * @return this tile's neighbour's coordinate
     */
    private int getNeighbourIndex(int cord, int maxValue, boolean add) {
        if (add == true) cord++; else cord--;

        if (cord < 0) {
            cord = maxValue;
        }
        else if (cord > maxValue) {
            cord = 0;
        }

        return cord;
    }

    /**
     * This method returns true for active tiles, and false for inactive ones
     * 
     * @return true when this tile is active, false if it's not
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets this tile as active/not active. When it's not active it's completly white.
     * If it wasn't active before it will be able to work again(thanks to notify)
     */
    private synchronized void setActive() {
        active = !active;
        if (active == true) {
            setOpacity(1); 
            notify();
        }
        else setOpacity(0);
    }
}
