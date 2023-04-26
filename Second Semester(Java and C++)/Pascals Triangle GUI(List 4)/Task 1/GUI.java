import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;

public class GUI {
    public GUI(Stage stage) {
        // Create a textarea for user input
        TextArea userInput = new TextArea();
        userInput.setPromptText("Enter the number of rows of the Pascals Triangle");
        userInput.setStyle("-fx-prompt-text-fill: grey;");
        userInput.setPrefRowCount(1);
        userInput.setPrefColumnCount(22);

        //Create a label where the triangle will be displayed
        Label triangleLabel = new Label();
        triangleLabel.setStyle("-fx-font-size: 15px");
        
        //Create a button to display the triangle
        Button confirm = new GUIButton("Calculate", userInput, triangleLabel);

        //GridPane for the textarea and the button
        GridPane inputGrid = new GridPane();
        inputGrid.setHgap(10);
        inputGrid.setPadding(new Insets(10));
        inputGrid.add(userInput, 0, 0);
        inputGrid.add(confirm, 1, 0);

        //BorderPane with everything inside
        BorderPane root = new BorderPane();
        root.setCenter(triangleLabel);
        root.setTop(inputGrid);

        //Create scene
        Scene scene = new Scene(root, 400, 500);
        stage.setScene(scene);
        stage.setTitle("Pascal's Triangle Generator");
        stage.show();
    }
}
