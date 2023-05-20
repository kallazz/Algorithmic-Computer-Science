import java.io.IOException;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class InitBoardGui {
    public InitBoardGui(Stage stage, int rows, int columns, int speed, double probability) throws IOException {
        //Loading FXML
        final FXMLLoader loader = new FXMLLoader(getClass().getResource("BoardLayout.fxml")); //throws exceptions
        final Parent root = loader.load();

        BoardController boardController = loader.getController();
        boardController.setData(rows, columns, speed, probability);

        //Stage setup
        stage.setTitle("Interactive Mosaic");
        stage.setScene(new Scene(root, 640, 400));
        stage.show(); 
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
    }
}
