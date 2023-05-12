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

/**
 * @class Controller
 * 
 * @brief This class is responsible for handling button clicks and mouse clicks on the drawing area. 
 * It allows the user to create new shapes, save them and load them. 
 * It also makes sure they don’t go out of bounds by clipping the drawingArea.
 */
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

    /**
     * @brief this method handles clicking the rectangleButton, removing any temporary points, 	
     * setting the label to appropriate instruction, disabling mouse events for shapes on the drawing area 
     * and starting the rectangle building process
     * 
     * @param event the action event triggered by clicking the rectangleButton
     */
    @FXML
    private void handleRectangleButtonClick(ActionEvent event) {
        TempPoint.remove(drawingArea);
        instructionLabel.setText("Select two opposing corners of the rectangle");
        shape = new RectangleBuilder();
        MyMouseEvents.disableMouseEvents(drawingArea);
    }

    /**
     * @brief this method handles clicking the circleButton, removing any temporary points, 	
     * setting the label to appropriate instruction, disabling mouse events for shapes on the drawing area 
     * and starting the circle building process
     * 
     * @param event the action event triggered by clicking the circleButton
     */
    @FXML
    private void handleCircleButtonClick(ActionEvent event) {
        TempPoint.remove(drawingArea);
        instructionLabel.setText("Select the center of the circle and then the radius");
        shape = new CircleBuilder();
        MyMouseEvents.disableMouseEvents(drawingArea);
    }

    /**
     * @brief this method handles clicking the hexagonButton, removing any temporary points, 	
     * setting the label to appropriate instruction, disabling mouse events for shapes on the drawing area 
     * and starting the hexagon building process
     * 
     * @param event the action event triggered by clicking the hexagonButton
     */
    @FXML
    private void handleHexagonButtonClick(ActionEvent event) {
        TempPoint.remove(drawingArea);
        instructionLabel.setText("Select six points to build a hexagon");
        shape = new HexagonBuilder();
        MyMouseEvents.disableMouseEvents(drawingArea);
    }

    /**
     * @brief this method handles clicking the resetButton, removing any temporary points, 
     * setting the label to appropriate instruction, enabling mouse events for shapes on the drawing area 
     * and stopping the current building process 
     * 
     * @param event the action event triggered by clicking the resetButton
     */
    @FXML
    private void handleResetButtonClick(ActionEvent event) {
        shape = null;
        TempPoint.remove(drawingArea);
        instructionLabel.setText("Choose what to draw");
        MyMouseEvents.enableMouseEvents(drawingArea);
    }

    /**
     * @brief this method handles mouse click events on the drawingArea. 
     * When user clicks somewhere where there is no shape, the current activeShape is set to not active. 
     * For the left click it adds another point to the currently created shape,
     * if the user hasn’t chosen another point in the same location before. 
     * For the right click it sets color of the currently active shape to the value from colorPicker
     * 
     * @param event the mouse click event on drawingArea
     */
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
                MyMouseEvents.setActiveColor(activeShape, false);
                MyMouseEvents.rotateAndResizeShapeCancel(drawingArea);
            }
        }
        else if (event.getButton() == MouseButton.SECONDARY) {
            if (activeShape != null) activeShape.setFill(colorPicker.getValue());

            if (hit == true) {
                hit = false;
            } else {
                MyMouseEvents.setActiveColor(activeShape, false);
                MyMouseEvents.rotateAndResizeShapeCancel(drawingArea);
            }
        }
    }

     /**
     * @brief this method handles clicking the saveButton, 
     * serializing and saving all the shapes created by user to a file called “savedObjects.ser”
     */
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
            a.setContentText("Objects saved successfully");
            a.show();
        }
        catch (final FileNotFoundException e) {
            System.out.println("File not found");
        } 
        catch (final IOException e) {
            System.out.println("Error initializing stream");
        }
    }

     /**
     * @brief this method handles clicking the loadButton, loading previously saved shapes from a file called “savedObjects.ser”
     */
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

    /**
     * @brief this method gets called when mouse enters the drawingArea. 
     * It clips the drawingArea in a rectangle to its current width and height. 
     * It’s done to prevent shapes from going out of bounds of the drawingArea. 
     */
    @FXML
    private void clipPane() {
        drawingArea.setClip(new Rectangle(drawingArea.getWidth(), drawingArea.getHeight()));
    }
}
