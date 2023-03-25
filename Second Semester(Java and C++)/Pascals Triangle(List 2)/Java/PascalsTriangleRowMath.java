import java.util.ArrayList;

/**
 * @class PascalsTriangleRowMath
 * 
 * @brief PascalsTriangleRowMath is a static class that contains static mathematical methods realtive to the Pascal's Triangle
 */
public class PascalsTriangleRowMath {

    private PascalsTriangleRowMath() throws InstantiationError {
        throw new InstantiationError("This is a static class!");
    }

    /**
     * @brief Function generates an ArrayList with the n-th row of the Pascal's Triangle
     *        For numbers < 0 and numbers > 34 the IllegalArgumentException is raised
     *        Example: generateRow(0) -> {1}
     *                 generateRow(1) -> {1, 1}
     *                 generateRow(2) -> {1, 2, 1}
     *                 generateRow(3) -> {1, 3, 3, 1}
     *                 generateRow(4) -> {1, 4, 6, 4, 1}
     * 
     * @param n row number(starting from 0)
     * 
     * @return ArrayList with the elements from the n-th row of the Pascal's Triangle
     */
    static public ArrayList<Long> generateRow(final int n) throws IllegalArgumentException {
            if (n < 0 || n > 34) {
                throw new IllegalArgumentException("Expected an integer in range <0, 34>, got " + n);
            }

            ArrayList<Long> row = new ArrayList<Long>();
            row.add(1L);

            for (int i = 0; i < n; i++) row.add((row.get(i) * (n - i)) / (i + 1));

            return row;
    }
    
}
