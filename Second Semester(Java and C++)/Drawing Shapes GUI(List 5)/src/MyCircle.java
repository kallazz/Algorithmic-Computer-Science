import java.io.Serializable;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MyCircle extends Circle implements Serializable {
    private double centerX, centerY, radius, scaleX, scaleY, translateX, translateY;
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
        scaleX = this.getScaleX();
        scaleY = this.getScaleY();
        translateX = this.getTranslateX();
        translateY = this.getTranslateY();
    }

    public void setProperties() {
        this.setCenterX(centerX);
        this.setCenterY(centerY);
        this.setRadius(radius);
        this.setScaleX(scaleX);
        this.setScaleY(scaleY);
        this.setFill(Color.color(red, green, blue));
        this.setTranslateX(translateX);
        this.setTranslateY(translateY);
        MyMouseEvents.clickShapeInit(this);
        MyMouseEvents.dragShapeInit(this);
    }
}
