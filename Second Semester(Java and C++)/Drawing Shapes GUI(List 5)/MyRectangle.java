import java.io.Serializable;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MyRectangle extends Rectangle implements Serializable {
    private double x, y, width, height, rotationAngle;
    private double red, green, blue;

    public MyRectangle() {
        super();
        MyMouseEvents.clickShapeInit(this);
        MyMouseEvents.dragShapeInit(this);
    }

    public void saveProperties() {
        x = this.getX();
        y = this.getY();
        width = this.getWidth();
        height = this.getHeight();
        rotationAngle = this.getRotate();
        red = ((Color)this.getFill()).getRed();
        green = ((Color)this.getFill()).getGreen();
        blue = ((Color)this.getFill()).getBlue();
    }

    public void setProperties() {
        this.setX(x);
        this.setY(y);
        this.setWidth(width);
        this.setHeight(height);
        this.setFill(Color.color(red, green, blue));
        this.setRotate(rotationAngle);
        MyMouseEvents.clickShapeInit(this);
        MyMouseEvents.dragShapeInit(this);
    }
}
