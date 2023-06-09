import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class TreeGUIController<T extends Comparable<T>> {
    @FXML
    private Button insertButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button searchButton;
    @FXML
    private Button printButton;
    @FXML
    private Button exitButton;
    @FXML
    private TextField argumentField;
    @FXML
    private Label drawingArea;

    private Parser parser; 
    private Socket socket;
    private PrintWriter output;
    private BufferedReader input;

    //Set the parser in the constructor, create new client
    public TreeGUIController(Parser parser, String type) {
        this.parser = parser;

        try {
            //Create a socket for the new client
            Socket socket = new Socket("localhost", 4444); 
            this.socket = socket;
    
            //For sending data to the server
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            this.output = output;
    
            //For receiving data from the server
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.input = input;

            output.println(type);
        }
        catch (final UnknownHostException e) {
            System.out.println("Server not found: " + e.getMessage());
    
        } 
        catch (final IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }

    @FXML
    private void treeInsert() {
        String userInput = argumentField.getText();
        if (checkArguments(1, userInput)) {
            output.println("insert");
            output.println(userInput);
            showAlert("Insert successfull!", AlertType.INFORMATION);
        }
    }

    @FXML
    private void treeDelete() {
        String userInput = argumentField.getText();
        if (checkArguments(1, userInput)) {
            output.println("delete");
            output.println(userInput);
            showAlert("Delete successfull!", AlertType.INFORMATION);
        }
    }

    @FXML
    private void treeSearch() {
        String userInput = argumentField.getText();
        if (checkArguments(1, userInput)) {
            output.println("search");
            output.println(userInput);
            if (getAnswerFromServer().equals("true"))  showAlert(userInput + " IS in the tree!", AlertType.INFORMATION);
            else showAlert(userInput + " IS NOT in the tree!", AlertType.INFORMATION);
        }
    }

    @FXML
    private void treePrint() {
        output.println("print");
        drawingArea.setText(getAnswerFromServer());
    }

    @FXML
    private void exitProgram() {
        output.println("exit");
        try {
            if (input.readLine().equals("OK")) {
                socket.close();
                System.exit(0);
            }
        }
        catch (final IOException ex) {
            System.out.println("FAIL");
        }
    }

    //checks if arguments are correct
    private boolean checkArguments(int n, String userInput) {
        drawingArea.setText(null);

        //check the number of arguments
        if (userInput.split(" ").length != n) {
            showAlert("Expected " + n + " arguments!", AlertType.WARNING);
            return false;
        }

        //check if they are of the apropriate type
        try {
            parser.parse(userInput);
        }
        catch (final NumberFormatException ex) {
            showAlert(userInput + " is not of the type you chose!", AlertType.WARNING);
            return false;
        }

        return true;
    }

    void showAlert(String content, AlertType type) {
        Alert infoAlert = new Alert(type);
        infoAlert.setContentText(content);
        infoAlert.showAndWait();
    }

    String getAnswerFromServer() {
        try {
            String answer = input.readLine();
            return answer;
        }
        catch (final IOException ex) {
            return "ERROR";
        }
    }
}
