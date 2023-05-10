import javafx.scene.paint.Color;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public class MyMouseEvents {
    public static void clickShapeInit(Shape shape) {
        shape.setOnMouseClicked((event) -> {
            setActiveShape(shape);
        });
    }

    private static double initialX = 0;
    private static double initialY = 0;
    private static double initialTranslateX = 0;
    private static double initialTranslateY = 0;

    public static void dragShapeInit(Shape shape) {

        shape.setOnMousePressed((event) -> {
            initialX = event.getSceneX();
            initialY = event.getSceneY();
            initialTranslateX = shape.getTranslateX();
            initialTranslateY = shape.getTranslateY();
            setActiveShape(shape);
          });
    
        shape.setOnMouseDragged((event) -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                double offsetX = event.getSceneX() - initialX;
                double offsetY = event.getSceneY() - initialY;
                shape.setTranslateX(initialTranslateX + offsetX);
                shape.setTranslateY(initialTranslateY + offsetY);
            }
          });
    }

    public static void rotateAndResizeShapeInit(Pane pane, Shape shape) {
        if (shape == null) return;

        pane.setOnScroll((event) -> {
            if (event.isControlDown()) {
                double rotationAngle = event.getDeltaY();
                shape.setRotate(shape.getRotate() + rotationAngle);
            } else {
                double scale;
                if (event.getDeltaY() > 0) {
                    scale = 1.1;
                }
                else {
                    scale = 0.9;
                }
                shape.setScaleX(shape.getScaleX() * scale);
                shape.setScaleY(shape.getScaleY() * scale);
            }
        });
    }

    public static void rotateAndResizeShapeCancel(Pane pane) {
        pane.setOnScroll((event) -> {});
    }

    public static void disableMouseEvents(Pane pane) {
        for (Node node : pane.getChildren()) {
            if (node instanceof Shape) {
                node.setOnMouseDragged(null);
                node.setOnMouseClicked(null);
                node.setOnMousePressed(null);
            }
        }
        rotateAndResizeShapeCancel(pane);
    }

    public static void enableMouseEvents(Pane pane) {
        for (Node node : pane.getChildren()) {
            if (node instanceof MyCircle || node instanceof MyRectangle || node instanceof MyHexagon) {
                clickShapeInit((Shape) node);
                dragShapeInit((Shape) node);
                rotateAndResizeShapeInit(pane, (Shape) node);
            }
        }
    }

    private static void setActiveShape(Shape shape) { 
        setActiveColor(Controller.activeShape, false);
        rotateAndResizeShapeCancel((Pane) shape.getParent());
        Controller.activeShape = shape;
        Controller.hit = true;
        setActiveColor(shape, true);
        shape.toFront();
        rotateAndResizeShapeInit((Pane) shape.getParent(), shape);
    }

    //Sets the active shape, changing its border color to red to indicate that
    public static void setActiveColor(Shape shape, boolean active) { 
        if (shape == null) return;
        if (active == true) {
            shape.setStroke(Color.RED);
        }
        else {
            shape.setStroke(null);
        }
    }
}
