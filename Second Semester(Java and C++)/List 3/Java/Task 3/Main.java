import java.util.Arrays;

public class Main {
    static void oneArgumentPrint(Shapes.OneArgument shape, final int n) {
        System.out.print("Name: ");
        System.out.println(shape.getName());
        System.out.print("Area: ");
        System.out.println(shape.getArea(n));
        System.out.print("Perimeter: ");
        System.out.println(shape.getPerimeter(n));
    }

    static void twoArgumentsPrint(Shapes.TwoArguments shape, final int a, final int b) {
        System.out.print("Name: ");
        System.out.println(shape.getName());
        System.out.print("Area: ");
        System.out.println(shape.getArea(a, b));
        System.out.print("Perimeter: ");
        System.out.println(shape.getPerimeter(a, b));
    }    

    public static void main(String args[]) {

        if (args[0].equals("c")) { //Czworokąt
            if (args.length != 6) {
                System.out.println("Expected 6 arguments, got " + args.length);
                return;
            }

            int [] input = new int[5]; //4 pierwsze elementy - boki, 5. element - kąt
            for (int i = 1; i < 6; i++) {
                try { input[i - 1] = Integer.parseInt(args[i]); }
                catch (final NumberFormatException ex) {
                    System.out.println(args[i] + " is not an integer");
                    return;
                }
            }

            if (input[0] == input[1] && input[0] == input[2] && input[0] == input[3]) {
                if (input[4] == 90) 
                    oneArgumentPrint(Shapes.OneArgument.SQUARE, input[0]); //Kwadrat
                else if (input[4] > 0 && input[4] < 180) 
                    twoArgumentsPrint(Shapes.TwoArguments.RHOMBUS, input[0], input[4]); //Romb
                else {
                    System.out.println("This is not one of the allowed quadrangles");
                    return;
                }
            }
            else {
                Arrays.sort(input, 0, 4);

                if (input[0] == input[1] && input[2] == input[3] && input[4] == 90) 
                    twoArgumentsPrint(Shapes.TwoArguments.RECTANGLE, input[0], input[2]); //Prostokąt
                else {
                    System.out.println("This is not one of the allowed quadrangles");
                    return;
                } 
            }
        }
        else if (args[0].equals("o") || args[0].equals("p") || args[0].equals("s")) {
            if (args.length != 2) {
                System.out.println("Expected 2 arguments, got " + args.length);
                return;
            }

            final int n;
            try { n = Integer.parseInt(args[1]); }
            catch (final NumberFormatException ex) {
                System.out.println(args[1] + " is not an integer");
                return;
            }

            Shapes.OneArgument shape;

            if (args[0].equals("o")) shape = Shapes.OneArgument.DISC;
            else if (args[0].equals("p")) shape = Shapes.OneArgument.PENTAGON;
            else shape = Shapes.OneArgument.HEXAGON;

            oneArgumentPrint(shape, n);
        }
        else {
            System.out.println("Expected c or o or p or s as the first argument, instead got " + args[0]);
            return;
        }
    }
}
