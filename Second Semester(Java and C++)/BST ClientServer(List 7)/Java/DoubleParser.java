public class DoubleParser extends Parser {
    public Object parse(String s) throws NumberFormatException {
        return Double.parseDouble(s);
    }
}
