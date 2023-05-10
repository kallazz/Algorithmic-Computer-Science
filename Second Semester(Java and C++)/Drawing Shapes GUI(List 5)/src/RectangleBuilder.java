import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class RectangleBuilder extends ShapeBuilder {
    private Rectangle rectangle = new MyRectangle();
    private int clickCount = 0;
    private double cords[] = new double[4]; //{cords[0], cords[1], cords[2], cords[3]};

    public void onClick(double x, double y, Pane pane, Label label) {
        clickCount++;

        if (clickCount == 1) {
            cords[0] = x;
            cords[1] = y;

            TempPoint.create(x, y, pane);
        }
        else if (clickCount == 2) {
            cords[2] = x;
            cords[3] = y;

            if (cords[0] < cords[2] && cords[1] < cords[3]) {
                rectangle.setX(cords[0]);
                rectangle.setY(cords[1]);
            }
            else if (cords[0] < cords[2] && cords[1] > cords[3]) {
                rectangle.setX(cords[0]);
                rectangle.setY(cords[3]);
            }
            else if (cords[0] > cords[2] && cords[1] < cords[3]) {
                rectangle.setX(cords[2]);
                rectangle.setY(cords[1]);
            }
            else if (cords[0] > cords[2] && cords[1] > cords[3]) {
                rectangle.setX(cords[2]);
                rectangle.setY(cords[3]);
            }
        
            rectangle.setWidth(Math.abs(cords[2] - cords[0]));
            rectangle.setHeight(Math.abs(cords[3] - cords[1]));
            
            finishBuilding(rectangle, pane, label);
        }
    }
}
