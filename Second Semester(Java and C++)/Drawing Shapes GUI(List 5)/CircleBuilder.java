import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class CircleBuilder implements ShapeBuilder {
    private Circle circle;
    private int clickCount;
    private double centerX;
    private double centerY;
    private double radius;

    public CircleBuilder() {
        circle = new Circle();
        clickCount = 0;
    }

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

            if (centerX + radius > pane.getWidth() || centerY + radius > pane.getHeight() || centerX - radius < 0 || centerY - radius < 0) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("The circle is too big!");
                alert.setContentText("The circle is too big to fit in the canvas");

                alert.showAndWait();
                clickCount--;
            } else {
                pane.getChildren().add(circle);
            }

            label.setText("Choose what to draw");
        }

    }

}
