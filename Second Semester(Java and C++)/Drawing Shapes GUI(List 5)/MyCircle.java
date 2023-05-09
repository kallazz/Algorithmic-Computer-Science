import java.io.Serializable;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MyCircle extends Circle implements Serializable {
    private double centerX, centerY, radius;
    private double red, green, blue;

    public MyCircle() {
        super();
        MyMouseEvents.clickShapeInit(this);
        MyMouseEvents.dragShapeInit(this);
    }

    public void saveProperties() {
        centerX = this.getCenterX();
        centerY = this.getCenterY();
        radius = this.getRadius();
        red = ((Color)this.getFill()).getRed();
        green = ((Color)this.getFill()).getGreen();
        blue = ((Color)this.getFill()).getBlue();
    }

    public void setProperties() {
        this.setCenterX(centerX);
        this.setCenterY(centerY);
        this.setRadius(radius);
        this.setFill(Color.color(red, green, blue));
        MyMouseEvents.clickShapeInit(this);
        MyMouseEvents.dragShapeInit(this);
    }
}
