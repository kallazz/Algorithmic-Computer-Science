public class Rhombus extends Quadrangle {
    public Rhombus(int side, int angle) throws IllegalArgumentException {
        if (angle < 1 || angle > 179) {
            throw new IllegalArgumentException("This is not a rhombus!");
        }

        for (int i = 0; i < 4; i++) sides.add(side);
        this.angle = angle;
    }

    @Override
    public String getName() {
        return "Rhombus";
    }
}
