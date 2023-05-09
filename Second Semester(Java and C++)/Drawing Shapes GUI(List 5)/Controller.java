import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Controller {
    @FXML
    private Button circleButton;
    @FXML
    private Button rectangleButton;
    @FXML
    private Button hexagonButton;
    @FXML
    private Button resetButton;
    @FXML
    private Button saveButton;
    @FXML
    private Button loadButton;
    @FXML
    private Label instructionLabel;
    @FXML
    private Pane drawingArea;
    @FXML
    private StackPane container;
    @FXML
    private ColorPicker colorPicker;

    private ShapeBuilder shape = null;
    public static Shape activeShape = null;
    public static boolean hit = false;

    //Buttons control
    @FXML
    private void handleRectangleButtonClick(ActionEvent event) {
        TempPoint.remove(drawingArea);
        instructionLabel.setText("Select two opposing corners of the rectangle");
        shape = new RectangleBuilder();
        MyMouseEvents.disableMouseEvents(drawingArea);
    }

    @FXML
    private void handleCircleButtonClick(ActionEvent event) {
        TempPoint.remove(drawingArea);
        instructionLabel.setText("Select the center of the circle and then the radius");
        shape = new CircleBuilder();
        MyMouseEvents.disableMouseEvents(drawingArea);
    }

    @FXML
    private void handleHexagonButtonClick(ActionEvent event) {
        TempPoint.remove(drawingArea);
        instructionLabel.setText("Select six points to build a hexagon");
        shape = new HexagonBuilder();
        MyMouseEvents.disableMouseEvents(drawingArea);
    }

    @FXML
    private void handleResetButtonClick(ActionEvent event) {
        shape = null;
        TempPoint.remove(drawingArea);
        instructionLabel.setText("Choose what to draw");
        MyMouseEvents.enableMouseEvents(drawingArea);
    }

    @FXML
    private void handleSaveButtonClick() {
        try {
            FileOutputStream f = new FileOutputStream(new File("savedObjects.ser"));
            ObjectOutputStream o = new ObjectOutputStream(f);
                
            for (Node node : drawingArea.getChildren()) {
                if (node instanceof MyCircle) {
                    ((MyCircle) node).saveProperties();
                    o.writeObject(node);
                }
                else if (node instanceof MyRectangle) {
                    ((MyRectangle) node).saveProperties();
                    o.writeObject(node);
                } 
                else if (node instanceof MyHexagon) {
                    ((MyHexagon) node).saveProperties();
                    o.writeObject(node);
                }
            }

            o.close();
            f.close();

            Alert a = new Alert(AlertType.INFORMATION);
            a.setContentText("Object saved successfully");
            a.show();
        }
        catch (final FileNotFoundException e) {
            System.out.println("File not found");
        } 
        catch (final IOException e) {
            System.out.println("Error initializing stream");
        }
    }

    @FXML
    private void handleLoadButtonClick() {
        try {
            FileInputStream f = new FileInputStream(new File("savedObjects.ser"));
			ObjectInputStream o = new ObjectInputStream(f);
                
            while (f.available() > 0) {
                Object object = o.readObject();
                if (object instanceof MyCircle) {
                    ((MyCircle) object).setProperties();
                    drawingArea.getChildren().add((MyCircle) object);
                }
                else if (object instanceof MyRectangle) {
                    ((MyRectangle) object).setProperties();
                    drawingArea.getChildren().add((MyRectangle) object);
                } 
                else if (object instanceof MyHexagon) {
                    ((MyHexagon) object).setProperties();
                    drawingArea.getChildren().add((MyHexagon) object);
                }
            }
            for (Node n : drawingArea.getChildren()) System.out.println(n);

            o.close();
            f.close();
        }
        catch (final FileNotFoundException e) {
            System.out.println("File not found");
        } 
        catch (final IOException e) {
            System.out.println("Error initializing stream");
        }
        catch (final ClassNotFoundException e) {
            System.out.println("Class not found!");
        }
    }

    //Handle everything that can happen when clicking on drawingArea
    @FXML
    private void handleDrawingAreaClick(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            if (shape != null) {
                if (TempPoint.isHit(drawingArea, event.getX(), event.getY())) {
                    Alert a = new Alert(AlertType.WARNING);
                    a.setContentText("Choose another point!");
                    a.show();
                } 
                else {
                    shape.onClick(event.getX(), event.getY(), drawingArea, instructionLabel);
                }
            }

            if (hit == true) {
                hit = false;
            } else {
                MyMouseEvents.setActive(activeShape, false);
                MyMouseEvents.rotateAndResizeShapeCancel(drawingArea);
            }
        }
        else if (event.getButton() == MouseButton.SECONDARY) {
            if (activeShape != null) activeShape.setFill(colorPicker.getValue());
            if (hit == true) {
                hit = false;
            } else {
                MyMouseEvents.setActive(activeShape, false);
            }
        }
    }

    //Clipping drawingArea so that shapes don't go out of drawingArea's bounds
    @FXML
    private void clipPane() {
        drawingArea.setClip(new Rectangle(drawingArea.getWidth(), drawingArea.getHeight()));
    }
}
