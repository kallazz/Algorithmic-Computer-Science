import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Pair;

public class Controller {
    @FXML
    private Button circleButton;
    @FXML
    private Button rectangleButton;
    @FXML
    private Button hexagonButton;
    @FXML
    private Label instructionLabel;
    @FXML
    private Pane drawingArea;

    private ShapeBuilder shape = null;

    //Buttons control
    @FXML
    private void handleRectangleButtonClick(ActionEvent event) {
        TempPoint.remove(drawingArea);
        instructionLabel.setText("Select two opposing corners of the rectangle");
        shape = new RectangleBuilder();
    }

    @FXML
    private void handleCircleButtonClick(ActionEvent event) {
        TempPoint.remove(drawingArea);
        instructionLabel.setText("Select the center of the circle and then the radius");
        shape = new CircleBuilder();
    }

    @FXML
    private void handleHexagonButtonClick(ActionEvent event) {
        TempPoint.remove(drawingArea);
        instructionLabel.setText("Select six points to build a hexagon");
        shape = new HexagonBuilder();
    }

    @FXML
    private void handleDrawingAreaClick(MouseEvent event) {
        if (shape != null) shape.onClick(event.getX(), event.getY(), drawingArea, instructionLabel);
    }

    @FXML
    public void initialize() {
    }
}
