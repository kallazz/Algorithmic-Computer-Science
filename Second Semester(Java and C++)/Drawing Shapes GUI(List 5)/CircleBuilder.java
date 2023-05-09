import javafx.scene.control.Label;
import javafx.scene.layout.Pane;


public class CircleBuilder extends ShapeBuilder {
    private MyCircle circle = new MyCircle();
    private int clickCount;
    private double centerX;
    private double centerY;
    private double radius;

    public void onClick(double x, double y, Pane pane, Label label) {
        clickCount++;

        if (clickCount == 1) {
            centerX = x;
            centerY = y;

            TempPoint.create(x, y, pane);
        }
        else if (clickCount == 2) {
            radius = Math.sqrt((Math.pow(x - centerX, 2)) + (Math.pow(y - centerY, 2)));
            circle.setCenterX(centerX);
            circle.setCenterY(centerY);
            circle.setRadius(radius);

            finishBuilding(circle, pane, label);
        }

    }
}
