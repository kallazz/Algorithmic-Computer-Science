import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.SocketException;

public class TreeOperations<T extends Comparable<T>> {
    private BST<T> tree = new BST<>();
    private Parser parser;
    private BufferedReader input;
    private PrintWriter output;
    private long id = Thread.currentThread().getId();

    public TreeOperations(Parser parser, BufferedReader input, PrintWriter output) {
        this.parser = parser;
        this.input = input;
        this.output = output;
    }

    public void handleRequests() {
            String line = "";
            do {
                try {
                    // Read what clients want to do
                    line = input.readLine();

                    if (line.equals("insert")) {
                        line = input.readLine();
                        tree.insert((T) parser.parse(line));

                        output.println(tree.print());
                        System.out.println("Insert complete for client " + id);
                    }   
                    else if (line.equals("delete")) {
                        line = input.readLine();
                        tree.delete((T) parser.parse(line));

                        output.println(tree.print());
                        System.out.println("Delete complete for client " + id);
                    } 
                    else if (line.equals("search")) {
                        line = input.readLine();
                        if (tree.search((T) parser.parse(line))) output.println("true");
                        else output.println("false");

                        System.out.println("Search complete for client" + id);
                    }
                    else if (line.equals("print")) {
                        output.println(tree.print());

                        System.out.println("Print complete for client " + id);
                    }
                }
                catch (final NumberFormatException ex) {
                    output.println("wrong_type");
                }
                catch (final SocketException ex) {
                    break;
                }
                catch (final IOException ex) {
                    System.out.println("Server exception: " + ex.getMessage());
                    ex.printStackTrace();
                    System.exit(0);
                }
            } while (!line.equals("exit"));

            //Back to ClientThread
    }
}
