import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InitGUI {
    public InitGUI(Stage stage) throws Exception {
        //Loading FXML
        final Parent root = FXMLLoader.load(getClass().getResource("GUILayout.fxml")); //throws exceptions

        //Stage setup
        stage.setTitle("Drawing app");
        stage.setMinWidth(640);
        stage.setMinHeight(440);
        stage.setScene(new Scene(root, 640, 400));
        stage.show(); 
    }
}
