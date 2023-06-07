public class IntegerParser extends Parser {
    public Object parse(String s) throws NumberFormatException {
        return Integer.parseInt(s);
    }
}
