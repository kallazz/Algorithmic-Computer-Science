public class Square extends Quadrangle {
    public Square(int side, int angle) throws IllegalArgumentException {
        if (angle != 90) {
            throw new IllegalArgumentException("This is not a square!");
        }

        for (int i = 0; i < 4; i++) sides.add(side);
        this.angle = angle;
    }

    @Override
    public String getName() {
        return "Square";
    }
}
