public class Main {
    public static void main(String args[]) {
        if (args.length < 2) {
            System.out.println("Expected at least 2 arguments, got " + args.length);
            return;
        }

        Shape newShape = new Square(1, 90);
        
        if (args[0].equals("c")) { //Czworokąt
            if (args.length != 6) {
                System.out.println("Expected 6 arguments, got " + args.length);
                return;
            }
            
            int sides[];
            sides = new int [4];
            final int angle;

            for (int i = 1; i < 5; i++) { //Sprawdzenie czy wszystkie argumenty to inty
                try {
                    sides[i - 1] = Integer.parseInt(args[i]);
                } 
                catch (NumberFormatException e) {
                    System.out.println(args[i] + " is not an integer");
                    return;
                }
            }

            try {
                angle = Integer.parseInt(args[5]);
            } 
            catch (NumberFormatException e) {
                System.out.println(args[5] + " is not an integer");
                return;
            }

            if (sides[0] == sides[1] && sides[0] == sides[2] && sides[0] == sides[3]) {
                if (angle == 90) newShape = new Square(sides[0], angle); //Kwadrat
                else { //Romb
                    try {
                        newShape = new Rhombus(sides[0], angle);
                    }
                    catch (IllegalArgumentException ex) {
                        System.out.println("This is not a rhombus. Angle should be in <1, 179>, got " + sides[5]);
                        return;
                    }
                }
            } 
            else { //Prostokąt
                try {
                    newShape = new Rectangle(sides[0], sides[1], sides[2], sides[3], angle);
                }
                catch (IllegalArgumentException ex) {
                    System.out.println("This is not a rectangle");
                    return;
                }
            }


        }
        else if (args[0].equals("o") || args[0].equals("p") || args[0].equals("s")) { //Koło, pięciokąt, sześciokąt
            if (args.length != 2) {
                System.out.println("Expected 2 arguments, got " + args.length);
                return;
            }

            final int n;
            try {
                n = Integer.parseInt(args[1]);
            } 
            catch (NumberFormatException e) {
                System.out.println(args[1] + " is not an integer");
                return;
            }

            if (args[0].equals("o")) { //Koło
                newShape = new Disk(n);
            }
            else if (args[0].equals("p")) { //Pięciokąt
                newShape = new Pentagon(n);
            }
            else if (args[0].equals("s")){ //Sześciokąt
                newShape = new Hexagon(n);
            }            
        } 
        else {
            System.out.println("Expected c or o or p or s as the first argument, got " + args[0]);
            return;
        } 

        System.out.print("Name: ");
        System.out.println(newShape.getName());
        System.out.print("Area: ");
        System.out.println(newShape.getArea());
        System.out.print("Perimeter: ");
        System.out.println(newShape.getPerimeter());
    }
}