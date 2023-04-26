import java.util.ArrayList;

public class PascalsTriangle {
    private ArrayList<ArrayList<Long>> rows;

    public PascalsTriangle(int rowNumber) throws IllegalArgumentException {   
        if (rowNumber < 0 || rowNumber > 32) throw new IllegalArgumentException();
        
        rows = new ArrayList<ArrayList<Long>>(); //2D ArrayList - each ArrayList inside is the next row

        for(int i = 0; i <= rowNumber; i++) {
            rows.add(new ArrayList<>());
            rows.get(i).add(1L);

            //Generating rows
            for (int j = 0; j < i; j++) {
                long newValue = (rows.get(i).get(j) * (i - j)) / (j + 1);
                rows.get(i).add(newValue); 
            }
        }
    }

    public long getElement(int rowNumber, int columnNumber) throws IndexOutOfBoundsException {
        if (rowNumber < 0 || rowNumber > rows.size() - 1) throw new IndexOutOfBoundsException();
        if (columnNumber < 0 || columnNumber > rows.get(rowNumber).size() - 1) throw new IndexOutOfBoundsException();

        return rows.get(rowNumber).get(columnNumber);
    }

    //This function returns a string with the whole Pascal's Triangle(up to the specified row number)
    public String getWholePascalsTriangle() {
        String result = "";

        for (int i = 0; i < rows.size(); i++) {   
            for (int j = 0; j <= i; j++) 
                result += " " + getElement(i, j);
            
            result += '\n';
        }
        return result;
    }
}
