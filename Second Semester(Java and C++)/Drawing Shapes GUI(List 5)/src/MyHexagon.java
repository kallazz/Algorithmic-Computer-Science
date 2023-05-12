import java.io.Serializable;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class MyHexagon extends Polygon implements Serializable {
    private double[] points = new double[12];
    private double rotationAngle, scaleX, scaleY, translateX, translateY;
    private double red, green, blue;
    public MyHexagon() {
        super();
        MyMouseEvents.clickShapeInit(this);
        MyMouseEvents.dragShapeInit(this);
    }

    public void saveProperties() {
        for (int i = 0; i < 12; i += 2) {     
            points[i] = this.getPoints().get(i);
            points[i + 1] = this.getPoints().get(i + 1);
        }
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
        for (int i = 0; i < 12; i += 2) {
            this.getPoints().addAll(points[i], points[i + 1]);
        }
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
