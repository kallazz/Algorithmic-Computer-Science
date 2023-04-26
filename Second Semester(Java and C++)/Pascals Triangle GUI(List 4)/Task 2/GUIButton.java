import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;

public class GUIButton extends Button {
    public GUIButton(String name, TextArea textArea1, TextArea textArea2, Label label) {
        super(name);

        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                ArrayList<Integer> arguments = getArguments(textArea1, textArea2);

                if (arguments.size() >= 2) {
                    try {
                        String programPath = "CppProgram/main.exe";
                        for (int n : arguments) {
                            programPath += " " + n;
                        }
                        
                        Process process = Runtime.getRuntime().exec(programPath);
    
                        try {
                            int exitValue = process.waitFor();
                            System.out.println("Program finished with " + exitValue);
                        }
                        catch (final InterruptedException ex) {
                            System.out.println("Program got interrupted");
                            System.exit(0);
                        }
    
                        BufferedReader reader = new BufferedReader(
                            new InputStreamReader(process.getInputStream()));
    
                        String result = "";
                        String line;
                        line = reader.readLine();
                        while (line != null) {
                            result += line + '\n';
                            line = reader.readLine();
                        }
                        label.setText(result);
    
                        reader.close();
                    }
                    catch (final IOException ex) {
                        System.out.println("Something is wrong with the file or its path");
                    }
                } else {
                    label.setText("");
                }
            }
        });
    }

    private ArrayList<Integer> getArguments(TextArea textArea1, TextArea textArea2) {
        ArrayList<Integer> arguments = new ArrayList<Integer>();

        //First textarea
        try {
            final int n = Integer.parseInt(textArea1.getText());
            if (n < 0 || n > 34) throw new IllegalArgumentException();

            arguments.add(n);
        } 
        catch (final NumberFormatException ex) {
            Alert a = new Alert(AlertType.WARNING);
            a.setContentText("You need to provide one integer in the first textarea!");
            a.show();
            return new ArrayList<Integer>();
        }
        catch (final IllegalArgumentException ex) {
            Alert a = new Alert(AlertType.WARNING);
            a.setContentText("The integer in the first textarea has to be in range <0, 34>");
            a.show();
            return new ArrayList<Integer>();
        }

        //Second textarea
        final String s = textArea2.getText();
        if (s.isEmpty()) {
            Alert a = new Alert(AlertType.WARNING);
            a.setContentText("You need to provide at least one integer in the second textarea!");
            a.show();
            return new ArrayList<Integer>();
        }

        try {
            String newNumber = "";

            for (int i = 0; i < s.length(); i++) {
                while (i < s.length() && s.charAt(i) != ' ') {
                    newNumber += s.charAt(i);
                    i++;
                }

                if (newNumber != "") {
                    arguments.add(Integer.parseInt(newNumber));
                    newNumber = "";
                }
            }
        }
        catch (final NumberFormatException ex) {
            Alert a = new Alert(AlertType.WARNING);
            a.setContentText("You need to provide integers separated by spaces in the second textarea!");
            a.show();
            return new ArrayList<Integer>();
        }

        return arguments;
    }
    
}
