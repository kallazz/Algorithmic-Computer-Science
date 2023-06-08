import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try {
            new InitChooseTypeGUI(stage);
        }
        catch (final Exception ex) {
            System.out.println("GUI init failed!");
            ex.printStackTrace();
            System.exit(0);
        }
    }
}