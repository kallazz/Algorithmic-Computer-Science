import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class ChooseTypeGUIController {
    @FXML
    private ChoiceBox<String> typeBox;
    @FXML
    private Button confirmButton;

    private ObservableList<String> typeList = FXCollections.observableArrayList("Integer", "Double", "String");

    private Stage stage;

    @FXML
    private void initialize() {
        typeBox.setValue("Integer");
        typeBox.setItems(typeList);

        confirmButton.setOnAction(new EventHandler<ActionEvent>() { 
            @Override 
            public void handle(ActionEvent e) {
                try {
                    new InitTreeGUI(stage, typeBox.getValue());
                }
                catch (final Exception ex) {
                    System.out.println("GUI init failed!");
                    ex.printStackTrace();
                    System.exit(0);
                }
            }
        });
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}