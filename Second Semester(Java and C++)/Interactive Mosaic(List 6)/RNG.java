import java.util.Random;

import javafx.scene.paint.Color;

public class RNG {
    private static Random rand = new Random();

    public static double getRandomNumber() {
        return rand.nextDouble();
    }

    public static int getRandomNumber(double range) {
        final double rangeMin = 0.5 * range;
        final double rangeMax = 1.5 * range;
        final double result = rangeMin + (rangeMax - rangeMin) * rand.nextDouble();

        return (int)result;
    }

    public static Color getRandomColor() {
        return Color.color(RNG.getRandomNumber(), RNG.getRandomNumber(), RNG.getRandomNumber());
    }
}
