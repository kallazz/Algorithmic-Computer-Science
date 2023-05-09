import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class HexagonBuilder extends ShapeBuilder {
    private MyHexagon hexagon = new MyHexagon();
    private int clickCount = 0;
    private double[][] points = new double[6][2];

    public void onClick(double x, double y, Pane pane, Label label) {
        clickCount++;

        if (clickCount < 6) {
            points[clickCount - 1][0] = x;
            points[clickCount - 1][1] = y;
            TempPoint.create(x, y, pane);
        }
        else if (clickCount == 6) {
            points[clickCount - 1][0] = x;
            points[clickCount - 1][1] = y;

            for (int i = 0; i < points.length; i++) {
                hexagon.getPoints().addAll(points[i][0], points[i][1]);
            }

            finishBuilding(hexagon, pane, label);
        }
    }
}
