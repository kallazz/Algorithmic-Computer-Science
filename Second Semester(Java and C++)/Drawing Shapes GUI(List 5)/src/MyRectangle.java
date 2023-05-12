import java.io.Serializable;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MyRectangle extends Rectangle implements Serializable {
    private double x, y, width, height, rotationAngle, scaleX, scaleY, translateX, translateY;
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
        scaleX = this.getScaleX();
        scaleY = this.getScaleY();
        translateX = this.getTranslateX();
        translateY = this.getTranslateY();
    }

    public void setProperties() {
        this.setX(x);
        this.setY(y);
        this.setWidth(width);
        this.setHeight(height);
        this.setFill(Color.color(red, green, blue));
        this.setRotate(rotationAngle);
        this.setScaleX(scaleX);
        this.setScaleY(scaleY);
        this.setTranslateX(translateX);
        this.setTranslateY(translateY);
        MyMouseEvents.clickShapeInit(this);
        MyMouseEvents.dragShapeInit(this);
    }
}
