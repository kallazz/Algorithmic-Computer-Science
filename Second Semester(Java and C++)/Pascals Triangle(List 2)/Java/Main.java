public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Program requires at least 2 arguments, got " + args.length);
            return;
        }

        try { //Checking if the first argument(size of ArrayList) is correct
            final int n = Integer.parseInt(args[0]);
            final PascalsTriangleRowGenerator row = new PascalsTriangleRowGenerator(n);

            for (int i = 1; i < args.length; i++) {
                System.out.print(args[i] + " --> ");

                try {
                    final int elementIndex = Integer.parseInt(args[i]);
                    System.out.println(row.getElement(elementIndex));
                } 
                catch (final IllegalArgumentException e) {
                    System.out.println("not an integer");
                } 
                catch (final IndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        catch (final IllegalArgumentException e) {
            System.out.println("Program requires an integer in range <0, 34>, got " + args[0]);
        }
    }
}
