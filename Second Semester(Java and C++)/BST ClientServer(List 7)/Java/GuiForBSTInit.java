import java.io.IOException;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GuiForBSTInit {
    public GuiForBSTInit(Stage stage, String type) throws IOException {
        //Loading FXML
        final FXMLLoader loader = new FXMLLoader(getClass().getResource("GuiForBST.fxml")); //throws exceptions

        //Create and set a controller with apropriate generic type and parser
        if (type.equals("Integer")) {
            final GuiForBSTController<Integer> controller = new GuiForBSTController<>(new IntegerParser());
            loader.setController(controller);
        }
        else if (type.equals("Double")) {
            final GuiForBSTController<Double> controller = new GuiForBSTController<>(new DoubleParser());
            loader.setController(controller);
        }
        else if (type.equals("String")) {
            final GuiForBSTController<String> controller = new GuiForBSTController<>(new StringParser());
            loader.setController(controller);
        }

        final Parent root = loader.load();

        //Stage setup
        stage.setTitle("BST Client-Server");
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