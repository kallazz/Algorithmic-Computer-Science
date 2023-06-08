import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MultiThread<T extends Comparable<T>> extends Thread {
    private BST<T> tree = new BST<>();
    private Parser parser;
    private BufferedReader input;
    private PrintWriter output;

    public MultiThread(Parser parser, BufferedReader input, PrintWriter output) {
        this.parser = parser;
        this.input = input;
        this.output = output;
    }

    public void run() {
        try {
            String line;
            do {
                // Read what clients want to do
                line = input.readLine();

                if (line.equals("insert")) {
                    line = input.readLine();
                    tree.insert((T) parser.parse(line));
                }   
                else if (line.equals("delete")) {
                    line = input.readLine();
                    tree.delete((T) parser.parse(line));
                } 
                else if (line.equals("search")) {
                    line = input.readLine();
                    if (tree.search((T) parser.parse(line))) output.println("true");
                    else output.println("false");
                }
                else if (line.equals("print")) {
                    output.println(tree.print());
                }
            } while (!line.equals("exit"));

            output.println("OK");
            System.out.println("Client disconnected");
        } 
        catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
