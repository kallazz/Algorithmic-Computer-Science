import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Choosing the type of BST
        System.out.println("Choose the type of this BST by writing its name");
        System.out.println("Write integer/double/string:");

        Scanner scanner = new Scanner(System.in);
        String type;

        while (true) {
            type = scanner.nextLine();

            if (type.equalsIgnoreCase("integer")) {
                final ConsoleHandler<Integer> handler = new ConsoleHandler<>(new IntegerParser());
                handler.run();
            }
            else if (type.equalsIgnoreCase("double")) {
                final ConsoleHandler<Double> handler = new ConsoleHandler<>(new DoubleParser());
                handler.run();
            }
            else if (type.equalsIgnoreCase("string")) {
                final ConsoleHandler<String> handler = new ConsoleHandler<>(new StringParser());
                handler.run();
            }
            else {
                System.out.println("Type " + type + " is not accepted. Choose integer/double/string");
            }
        }
    }
}