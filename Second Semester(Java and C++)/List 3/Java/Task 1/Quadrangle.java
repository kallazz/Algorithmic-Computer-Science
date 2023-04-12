import java.util.ArrayList;

public abstract class Quadrangle extends Shape {
    protected ArrayList<Integer> sides = new ArrayList<Integer>();
    protected int angle;

    @Override
    public double getArea() {
        return ((double)sides.get(0)) * ((double)sides.get(2)) * Math.sin(Math.toRadians(angle));
    }

    @Override
    public double getPerimeter() {
        double result = 0.0;
        for (int side : sides) result += (double)side;
        return result;
    }
}
