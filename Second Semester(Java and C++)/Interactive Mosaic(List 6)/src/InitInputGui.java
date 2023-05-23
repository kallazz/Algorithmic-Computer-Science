import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InitInputGui {
    public InitInputGui(Stage stage) throws IOException {
        //Loading FXML
        final FXMLLoader loader = new FXMLLoader(getClass().getResource("InputLayout.fxml")); //throws exceptions
        final Parent root = loader.load();
        
        InputController inputController = loader.getController();
        inputController.setStage(stage);
        
        //Stage setup
        stage.setTitle("Interactive Mosaic - Input Data");
        stage.setMinWidth(640);
        stage.setMinHeight(440);
        stage.setScene(new Scene(root, 640, 400));
        stage.setResizable(false);
        stage.show(); 
    }
}
