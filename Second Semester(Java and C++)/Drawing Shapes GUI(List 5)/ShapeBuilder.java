import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public interface ShapeBuilder {
    public void onClick(double x, double y, Pane pane, Label label);
}
