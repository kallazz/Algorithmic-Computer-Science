public class Pentagon extends Shape {
    private double side;

    public Pentagon(int side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return Math.sqrt(25 + 10 * Math.sqrt(5)) * (Math.pow(side, 2) / 4);
    }

    @Override
    public double getPerimeter() {
        return 5 * side;
    }

    @Override
    public String getName() {
        return "Pentagon";
    }
}
