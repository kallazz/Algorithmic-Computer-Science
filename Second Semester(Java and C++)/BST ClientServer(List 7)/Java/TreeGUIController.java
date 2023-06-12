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

    private Socket socket;
    private PrintWriter output;
    private BufferedReader input;

    //Create streams for communication with the server
    public TreeGUIController(Parser parser, String type) {
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
            System.exit(0);
    
        } 
        catch (final IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
            System.exit(0);
        }
    }

    //***BUTTONS*** 
    @FXML
    private void treeInsert() {
        String userInput = argumentField.getText();
        if (checkArguments(userInput)) {
            output.println("insert");
            output.println(userInput);

            drawingArea.setText(getAnswerFromServer());
        }
    }

    @FXML
    private void treeDelete() {
        String userInput = argumentField.getText();
        if (checkArguments(userInput)) {
            output.println("delete");
            output.println(userInput);

            drawingArea.setText(getAnswerFromServer());
        }
    }

    @FXML
    private void treeSearch() {
        String userInput = argumentField.getText();
        if (checkArguments(userInput)) {
            output.println("search");
            output.println(userInput);
            String answer = getAnswerFromServer();

            if (answer.equals("true"))  showAlert(userInput + " IS in the tree!", AlertType.INFORMATION);
            else if (answer.equals("false")) showAlert(userInput + " IS NOT in the tree!", AlertType.INFORMATION);
        }
    }

    @FXML
    private void treePrint() {
        output.println("print");

        drawingArea.setText(getAnswerFromServer());
    }


    //***Local methods***
    private boolean checkArguments(String userInput) {
        drawingArea.setText(null); //clean the drawingArea

        //check the number of arguments
        if (userInput.split(" ").length != 1) {
            showAlert("Expected 1 argument!", AlertType.WARNING);
            return false;
        }

        return true;
    }

    private String getAnswerFromServer() {
        try {
            String answer = input.readLine();
            if (answer.equals("wrong_type")) {
                showAlert("Wrong data type!", AlertType.WARNING);
                return "";
            }

            return answer;
        }
        catch (final IOException ex) {
            System.out.println("I/O error while getting answer from server");
            System.exit(0);
            return "I/O ERROR";
        }
    }

    @FXML
    private void exitProgram() {
        output.println("exit");
        System.exit(0);
    }

    private void showAlert(String content, AlertType type) {
        Alert infoAlert = new Alert(type);
        infoAlert.setContentText(content);
        infoAlert.showAndWait();
    }
}
