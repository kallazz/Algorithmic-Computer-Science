import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class TempPoint {
    private TempPoint() throws InstantiationError {
        throw new InstantiationError("This is a static class!");
    }

    static public void create(double x, double y, Pane pane) {
        Circle circle = new Circle();
        circle.setCenterX(x);
        circle.setCenterY(y);
        circle.setRadius(1f);
        pane.getChildren().add(circle);
        circle.setId("circle");
    }

    static public void remove(Pane pane) {
        for (Node node : pane.getChildren()) {
            if (node.getId() != null && node.getId().equals("circle")) {
                pane.getChildren().remove(node);
                return;
            }
        }
    }
}
