import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class GUI {
    public GUI(Stage stage) {
        //Creating elements in the GUI
        TextArea rowNumberArea = new TextArea();
        TextArea elementIndexesArea = new TextArea();
        Label rowNumberLabel = new Label("Pascal's Triangle Row number");
        Label elementIndexesLabel = new Label("Numbers of elements in that row, separated with spaces");

        Label resultsLabel = new Label();
        resultsLabel.setStyle("-fx-font-size: 30px;");

        Button button = new GUIButton("Calculate", rowNumberArea, elementIndexesArea, resultsLabel);

        //VBox for the text areas and the button
        VBox usersInputVBox = new VBox(10, rowNumberLabel, rowNumberArea, elementIndexesLabel, elementIndexesArea, button);
        usersInputVBox.setPadding(new Insets(0, 10, 5, 10));
        usersInputVBox.setPrefWidth(Double.MAX_VALUE);
        usersInputVBox.setPrefHeight(stage.getHeight() * 0.25);

        //Wrapping resultsLabel in a container to then make it scrollable
        FlowPane resultsContainer = new FlowPane();
        resultsContainer.getChildren().add(resultsLabel);
        resultsContainer.setAlignment(Pos.CENTER);

        //To make the results scrollable
        ScrollPane scrollPane = new ScrollPane(resultsContainer);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        
        //Border pane with the entire layout inside
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(usersInputVBox);
        borderPane.setCenter(scrollPane);
        borderPane.setStyle("-fx-font-size: 14px;");

        //Creating scene
        Scene scene = new Scene(borderPane, 400, 400);
        stage.setScene(scene);
        stage.setTitle("Pascal's Triangle Row Generator");
        stage.show();
    }
}
