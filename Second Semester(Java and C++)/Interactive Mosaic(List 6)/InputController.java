import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class InputController {
    @FXML
    private TextArea rowsTextArea;
    @FXML
    private TextArea columnsTextArea;
    @FXML
    private TextArea speedTextArea;
    @FXML
    private TextArea probabilityTextArea;

    @FXML
    private Button confirmButton;

    private Stage stage;
    private int rows;
    private int columns;
    private int speed;
    private double probability;

    private Alert alert = new Alert(AlertType.WARNING);

    @FXML
    public void initialize() {
        //After clicking the button, check if user input is correct
        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                //Rows and columns textareas
                try {
                    rows = Integer.parseInt(rowsTextArea.getText());
                    columns = Integer.parseInt(columnsTextArea.getText());
                    if (rows < 0 || rows > 100 || columns < 0 || columns > 100) throw new NumberFormatException();
                }
                catch (final NumberFormatException ex) {
                    alert.setContentText("Rows and columns have to be integers lower than 100!");
                    alert.show();
                    return;
                }

                //Speed textarea
                try {
                    speed = Integer.parseInt(speedTextArea.getText());
                    if (speed < 500) throw new NumberFormatException();
                }
                catch (final NumberFormatException ex) {
                    alert.setContentText("Speed has to be an integer no lower than 500!");
                    alert.show();
                    return;
                }

                //Probability textarea
                try {
                    probability = Double.parseDouble(probabilityTextArea.getText());
                    if (probability < 0.0 || probability > 1.0) throw new NumberFormatException();
                }
                catch (final NumberFormatException ex) {
                    alert.setContentText("Probability has to be a number between 0.0 and 1.0!");
                    alert.show();
                    return;
                }

                try {
                    new InitBoardGui(stage, rows, columns, speed, probability);
                }
                catch (final Exception ex) {
                    System.out.println("Board window initialization failed");
                }
            }
        });
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

}
