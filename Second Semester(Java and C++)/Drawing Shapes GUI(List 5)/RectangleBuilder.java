import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RectangleBuilder implements ShapeBuilder {
    private Rectangle rectangle;
    private int clickCount;
    private double x1;
    private double x2;
    private double y1;
    private double y2;

    public RectangleBuilder() {
        rectangle = new Rectangle();
        clickCount = 0;
    }

    public void onClick(double x, double y, Pane pane, Label label) {
        clickCount++;

        if (clickCount == 1) {
            x1 = x;
            y1 = y;

            TempPoint.create(x, y, pane);
        }
        else if (clickCount == 2) {
            x2 = x;
            y2 = y;

            if (x1 < x2 && y1 < y2) {
                rectangle.setX(x1);
                rectangle.setY(y1);
            }
            else if (x1 < x2 && y1 > y2) {
                rectangle.setX(x1);
                rectangle.setY(y2);
            }
            else if (x1 > x2 && y1 < y2) {
                rectangle.setX(x2);
                rectangle.setY(y1);
            }
            else if (x1 > x2 && y1 > y2) {
                rectangle.setX(x2);
                rectangle.setY(y2);
            }
        
            rectangle.setWidth(Math.abs(x2 - x1));
            rectangle.setHeight(Math.abs(y2 - y1));
            rectangle.setFill(Color.BLUE);
            rectangle.setStroke(Color.BLACK);
            
            pane.getChildren().add(rectangle);

            label.setText("Choose what to draw");
        }
    }
}
