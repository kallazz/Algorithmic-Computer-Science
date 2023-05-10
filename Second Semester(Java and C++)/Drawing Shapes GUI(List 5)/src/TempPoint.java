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
        circle.setRadius(2f);
        pane.getChildren().add(circle);
        circle.setId("tempCircle");
    }

    static public void remove(Pane pane) {
        for (int i = 0; i < pane.getChildren().size(); i++) {
            Node node = pane.getChildren().get(i);
            if (node.getId() != null && node.getId().equals("tempCircle")) {
                pane.getChildren().remove(node);
                i--;
            }
        }
    }

    static public boolean isHit(Pane pane, double mouseX, double mouseY) {
        for (int i = 0; i < pane.getChildren().size(); i++) {
            Node node = pane.getChildren().get(i);
            if (node.getId() != null && node.getId().equals("tempCircle") && node.contains(mouseX, mouseY)) {
                return true;
            }
        }
        return false;
    }
}
