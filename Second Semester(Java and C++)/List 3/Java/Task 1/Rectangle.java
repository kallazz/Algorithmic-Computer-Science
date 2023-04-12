import java.util.Comparator;

public class Rectangle extends Quadrangle {
    public Rectangle(int a, int b, int c, int d, int angle) throws IllegalArgumentException {
        sides.add(a);
        sides.add(b);
        sides.add(c);
        sides.add(d);
        this.angle = angle;

        sides.sort(Comparator.naturalOrder());

        if ((sides.get(0) != sides.get(1)) || (sides.get(2) != sides.get(3)) || (angle != 90)) {
            throw new IllegalArgumentException("This is not a rectangle!");
        }
    }

    @Override
    public String getName() {
        return "Rectangle";
    }
}
