import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;

public class GUIButton extends Button {
    public GUIButton(String name, TextArea area, Label label) {
        super(name);

        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    final int n = Integer.parseInt(area.getText());
                    PascalsTriangle triangle = new PascalsTriangle(n);
                    label.setText(triangle.getWholePascalsTriangle());
                } 
                catch (final NumberFormatException ex) {
                    Alert a = new Alert(AlertType.WARNING);
                    a.setContentText("You need to provide one integer!");
                    a.show();
                    label.setText("");
                }
                catch (final IllegalArgumentException ex) {
                    Alert a = new Alert(AlertType.WARNING);
                    a.setContentText("You need to provide an integer in range <0, 32>");
                    a.show();
                    label.setText("");
                }
            }
        });
    }
}
