import javafx.scene.paint.Color;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public class MyMouseEvents {
    public static void clickShapeInit(Shape shape) {
        shape.setOnMouseClicked((event) -> {
            setActiveShape(shape);
        });
    }

    private static double orgSceneX = 0;
    private static double orgSceneY = 0;

    public static void dragShapeInit(Shape shape) {

        shape.setOnMousePressed((event) -> {
            orgSceneX = event.getSceneX();
            orgSceneY = event.getSceneY();
            setActiveShape(shape);
            shape.toFront();
          });
    
        shape.setOnMouseDragged((event) -> {
            double offsetX = event.getSceneX() - orgSceneX;
            double offsetY = event.getSceneY() - orgSceneY;
      
            if (shape instanceof MyCircle) {
                MyCircle circle = (MyCircle) shape;
                circle.setCenterX(circle.getCenterX() + offsetX);
                circle.setCenterY(circle.getCenterY() + offsetY);
            } else if (shape instanceof MyRectangle) {
                MyRectangle rectangle = (MyRectangle) shape;
                rectangle.setX(rectangle.getX() + offsetX);
                rectangle.setY(rectangle.getY() + offsetY);
            } else if (shape instanceof MyHexagon) {
                for (int i = 0; i < 12; i += 2) {
                    MyHexagon hexagon = (MyHexagon) shape;
                    hexagon.getPoints().set(i, hexagon.getPoints().get(i) + offsetX);
                    hexagon.getPoints().set(i + 1, hexagon.getPoints().get(i + 1) + offsetY);
                }
            }
      
            orgSceneX = event.getSceneX();
            orgSceneY = event.getSceneY();
          });
    }

    public static void rotateAndResizeShapeInit(Pane pane, Shape shape) {
        if (shape == null) return;

        pane.setOnScroll((event) -> {
            if (event.isControlDown()) {
                double rotationAngle = event.getDeltaY();
                shape.setRotate(shape.getRotate() + rotationAngle);
            } else {
                double zoomFactor = 1.05;
                double deltaY = event.getDeltaY();

                if (deltaY < 0) {
                    zoomFactor = 1 / zoomFactor;
                }

                if (shape != null) {
                    if (shape instanceof MyRectangle) {
                        MyRectangle rectangle = (MyRectangle) shape;
                        double oldWidth = rectangle.getWidth();
                        double oldHeight = rectangle.getHeight();
                        double oldX = rectangle.getX();
                        double oldY = rectangle.getY();
                        
                        double newWidth = oldWidth * zoomFactor;
                        double newHeight = oldHeight * zoomFactor;
                        
                        rectangle.setWidth(oldWidth * zoomFactor);
                        rectangle.setHeight(oldHeight * zoomFactor);
                        rectangle.setX(oldX - (newWidth - oldWidth) / 2);
                        rectangle.setY(oldY - (newHeight - oldHeight) / 2);
                    }
                    else if (shape instanceof MyCircle) {
                        MyCircle circle = (MyCircle) shape;
                        double oldRadius = circle.getRadius();
                        double oldCenterX = circle.getCenterX();
                        double oldCenterY = circle.getCenterY();
                        
                        double newRadius = oldRadius * zoomFactor;
                        
                        circle.setRadius(newRadius);
                        circle.setCenterX(oldCenterX - (newRadius - oldRadius) / 2);
                        circle.setCenterY(oldCenterY - (newRadius - oldRadius) / 2);
                    }
                    else if (shape instanceof MyHexagon) {
                        MyHexagon hexagon = (MyHexagon) shape;
                        double[] oldXPoints = hexagon.getPoints().stream().filter(p -> hexagon.getPoints().indexOf(p) % 2 == 0).mapToDouble(p -> (double) p).toArray();
                        double[] oldYPoints = hexagon.getPoints().stream().filter(p -> hexagon.getPoints().indexOf(p) % 2 == 1).mapToDouble(p -> (double) p).toArray();
                        double oldCenterX = (hexagon.getBoundsInLocal().getMinX() + hexagon.getBoundsInLocal().getMaxX()) / 2.0;
                        double oldCenterY = (hexagon.getBoundsInLocal().getMinY() + hexagon.getBoundsInLocal().getMaxY()) / 2.0;
                        
                        double[][] newPoints = new double[6][2];
                        for (int i = 0; i < 6; i++) {
                            double oldX = oldXPoints[i];
                            double oldY = oldYPoints[i];
                            
                            double newX = oldCenterX + (oldX - oldCenterX) * zoomFactor;
                            double newY = oldCenterY + (oldY - oldCenterY) * zoomFactor;
                            
                            newPoints[i][0] = newX;
                            newPoints[i][1] = newY;
                        }
                        
                        hexagon.getPoints().clear();
                        for (int i = 0; i < newPoints.length; i++) {
                            hexagon.getPoints().addAll(newPoints[i][0], newPoints[i][1]);
                        }
                    }
                }

                event.consume();
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
        setActive(Controller.activeShape, false);
        rotateAndResizeShapeCancel((Pane) shape.getParent());
        Controller.activeShape = shape;
        Controller.hit = true;
        setActive(shape, true);
        rotateAndResizeShapeInit((Pane) shape.getParent(), shape);
    }

    //Sets the active shape, changing its border color to red to indicate that
    public static void setActive(Shape shape, boolean active) { 
        if (shape == null) return;
        if (active == true) {
            shape.setStroke(Color.RED);
        }
        else {
            shape.setStroke(null);
        }
    }
}
