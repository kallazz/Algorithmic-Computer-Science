import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle implements Runnable {
    private final int delay;
    private final double probability; // 0.0 - 1.0
    private final int x, y, maxX, maxY;
    private final Object mutex;

    public Tile(double sideWidth, double sideHeight, int delay, double probability, int x, int y, int maxX, int maxY, Object mutex) {
        super(sideWidth, sideHeight);
        this.setFill(RNG.getRandomColor());

        this.delay = delay;
        this.probability = probability;
        this.x = x;
        this.y = y;
        this.maxX = maxX - 1;
        this.maxY = maxY - 1;
        this.mutex = mutex;

        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                System.out.println(getId());
            }
        });
    }

    @Override
    public void run() {
        while (true) {
            if (RNG.getRandomNumber() <= probability) {
                    setColor(RNG.getRandomColor());
            } 
            else {
                    Color newColor = getNewColor();
                    setColor(newColor);
            }
            
            try {Thread.sleep(RNG.getRandomNumber(delay), 0);}
            catch (Exception ex) {
                System.out.println("interrupted");
            }
        }
    }

    //Change color of the tile
    private void setColor(Color color) {
        synchronized (mutex) {
            System.out.println("Start: #" + x + "," + y);
            Platform.runLater(() -> setFill(color));
            System.out.println("End: #" + x + "," + y);
        }
    }

    //Return color of the tile
    private Color getColor() {
        synchronized (mutex) {
            System.out.println("Start: #" + x + "," + y);
            System.out.println("End: #" + x + "," + y);
            return (Color) getFill();
        }
    }

    //Returns a new color based on the colors of this thread's neighbours
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
        Color currentColor;
        for (Tile tile : tiles) {
            currentColor = tile.getColor();
            red += currentColor.getRed();
            blue+= currentColor.getBlue();
            green += currentColor.getGreen();
        }
        red /= 4;
        blue /= 4;
        green /=4;

        return new Color(red, green, blue, 1.0);
    }
    
    //Returns this tile's neighbour index(x or y), add = true when neighbour is on top/right
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

    //Return tile based on its index
    private Tile getTile(int x, int y, Pane pane) {
        return (Tile) pane.lookup("#" + x + "," + y);
    }
}
