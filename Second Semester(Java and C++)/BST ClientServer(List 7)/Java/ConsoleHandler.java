import java.util.Scanner;

public class ConsoleHandler<T extends Comparable<T>> {
    final private Parser parser;
    final private BST<T> tree = new BST<>();

    public ConsoleHandler(Parser parser) {
        this.parser = parser;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String action;
        String[] choice;

        System.out.println("You have 4 available commands for tree manipulation: insert, delete, search and print");
        System.out.println("Each of these commands, except for print, takes 1 argument after a space");
        System.out.println("If you wish to finish the program, write exit");


        while (true) {
            choice = scanner.nextLine().split(" ");

            try {
                if (choice.length < 1 || choice.length > 2) throw new IndexOutOfBoundsException();
                action = choice[0];

                if (action.equalsIgnoreCase("insert")) {
                    tree.insert((T) parser.parse(choice[1]));
                }
                else if (action.equalsIgnoreCase("delete")) {
                    tree.delete((T) parser.parse(choice[1]));
                }
                else if (action.equalsIgnoreCase("search")) {
                    if (tree.search((T) parser.parse(choice[1])) == true) System.out.println(choice[1] + " is in the tree");
                    else System.out.println(choice[1] + " is NOT in the tree");
                }
                else if (action.equalsIgnoreCase("print")) {
                    if (choice.length > 1) throw new IndexOutOfBoundsException();
                    else tree.print();
                }
                else if (action.equalsIgnoreCase("exit")) {
                    System.exit(0);
                }
                else {
                    System.out.println(action + " is not one of the allowed actions!");
                }
            }
            catch (final NumberFormatException ex) { //forwarded from the parser
                System.out.println(choice[1] + " is not a value of the type you declared earlier!");
            }
            catch (final IndexOutOfBoundsException ex) {
                System.out.println((choice.length - 1) + " is not the correct number of arguments for this action!");
            }
        }
    }
}
