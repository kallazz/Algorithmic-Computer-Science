import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle implements Runnable {
    private final int delay;
    private final double probability; // 0.0 - 1.0
    private final int x, y;

    public Tile(double sideWidth, double sideHeight, int delay, double probability, int x, int y) {
        super(sideWidth, sideHeight);
        this.setFill(RNG.getRandomColor());

        this.delay = delay;
        this.probability = probability;
        this.x = x;
        this.y = y;

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
                this.setFill(RNG.getRandomColor());
            } 
            else {
                this.setNewColor();
            }

            try {Thread.sleep(RNG.getRandomNumber(delay), 0);}
            catch (Exception ex) {}
        }
    }

    public Color getColor() {
        return (Color) this.getFill();
    }

    private void setNewColor() {
        if (x - 1 < 0) {
            
        }

    }
}
