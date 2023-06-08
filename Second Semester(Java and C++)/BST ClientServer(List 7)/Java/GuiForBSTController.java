import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class GuiForBSTController<T extends Comparable<T>> {
    @FXML
    private Button insertButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button searchButton;
    @FXML
    private Button printButton;
    @FXML
    private TextField argumentField;
    @FXML
    private Label drawingArea;

    private BST<T> tree = new BST<>();
    private Parser parser;

    //Set the parser in the constructor
    public GuiForBSTController(Parser parser) {
        this.parser = parser;
    }

    @FXML
    private void treeInsert() {
        String userInput = argumentField.getText();
        if (checkArguments(1, userInput)) tree.insert((T) parser.parse(userInput));
        showInfoAlert("Insert successfull!");
    }

    @FXML
    private void treeDelete() {
        String userInput = argumentField.getText();
        if (checkArguments(1, userInput)) tree.delete((T) parser.parse(userInput));
        showInfoAlert("Delete successfull!");
    }

    @FXML
    private void treeSearch() {
        String userInput = argumentField.getText();
        if (checkArguments(1, userInput)) {
            if (tree.search((T) parser.parse(userInput))) showInfoAlert(userInput + " IS in the tree!");
            else showInfoAlert(userInput + " IS NOT in the tree!");
        }
    }

    @FXML
    private void treePrint() {
        drawingArea.setText(tree.print());
    }

    //checks if arguments are correct
    private boolean checkArguments(int n, String userInput) {
        drawingArea.setText(null);

        //check the number of arguments
        if (userInput.split(" ").length != n) {
            System.out.println("Expected " + n + " arguments!");
            return false;
        }

        //check if they are of the apropriate type
        try {
            parser.parse(userInput);
        }
        catch (final NumberFormatException ex) {
            System.out.println(userInput + " is not of the type you chose!");
            return false;
        }

        return true;
    }

    void showInfoAlert(String content) {
        Alert infoAlert = new Alert(AlertType.INFORMATION);
        infoAlert.setContentText(content);
        infoAlert.showAndWait();
    }
}
