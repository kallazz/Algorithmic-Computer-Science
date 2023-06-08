import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InitChooseTypeGUI {
    public InitChooseTypeGUI(Stage stage) throws IOException {
        //Loading FXML
        final FXMLLoader loader = new FXMLLoader(getClass().getResource("ChooseTypeGUI.fxml")); //throws exceptions
        final Parent root = loader.load();
        
        ChooseTypeGUIController controller = loader.getController();
        controller.setStage(stage);
        
        //Stage setup
        stage.setTitle("BST Client-Server - Choose a type");
        stage.setMinWidth(640);
        stage.setMinHeight(440);
        stage.setScene(new Scene(root, 640, 400));
        stage.setResizable(false);
        stage.show(); 
    }
}