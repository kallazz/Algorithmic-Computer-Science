public class Hexagon extends Shape {
    private double side;

    public Hexagon(int side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return (3 * Math.sqrt(3) * Math.pow(side, 2)) / 2;
    }

    @Override
    public double getPerimeter() {
        return 6 * side;
    }

    @Override
    public String getName() {
        return "Hexagon";
    }
}
