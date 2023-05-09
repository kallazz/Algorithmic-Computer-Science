import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public abstract class ShapeBuilder extends Shape {
    public abstract void onClick(double x, double y, Pane pane, Label label);
    protected void finishBuilding(Shape shape, Pane pane, Label label) {
        pane.getChildren().add(shape);
        label.setText("Choose what to draw");
        MyMouseEvents.enableMouseEvents(pane);
        TempPoint.remove(pane);
    }
}
