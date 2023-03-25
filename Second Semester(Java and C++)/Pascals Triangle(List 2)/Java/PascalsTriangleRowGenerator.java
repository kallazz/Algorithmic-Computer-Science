import java.util.ArrayList;

/**
 * @class PascalsTriangleRowGenerator
 * 
 * @brief This class contains the n-th row of the Pascal's Triangle
 *        In order to generate it you have to create an object with an argument n(row number) 
 *        Then you can get the m-th element of that row
 * 
 *        Example:
 *        PascalsTriangleRowGenerator r = new PascalsTriangleRowGenerator(2); //{1, 2, 1} generated
 *        int secondElement = r.getElement(1); // The second element is 2    
 */
public class PascalsTriangleRowGenerator {

    private ArrayList<Long> row;

    /**
     * @brief Creates a class instance with the n-th row of the Pascal's Triangle
     * 
     * @param n row number(starting from 0)
     */
    public PascalsTriangleRowGenerator(final int n) throws IllegalArgumentException {
        row = PascalsTriangleRowMath.generateRow(n); //IllegalArgumentException fwd
    }

    /**
     * @brief Getting in O(1) the m-th element of the previously generated n-th row of the Pascal's triangle
     * 
     * @param m the index of the element you want to get(starting from 0)
     * 
     * @return the m-th element of the Pascal's Triangle row
     */
    public long getElement(final int m) throws IndexOutOfBoundsException {
        if (m < 0 || m >= row.size()) {
            throw new IndexOutOfBoundsException("out of range, use <0, " + Integer.toString(row.size() - 1) + ">");
        }
        return row.get(m);
    }
} 