package com.github.mrkounniyom.calculator.gui;

import com.github.mrkounniyom.calculator.operations.basicOperations;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * Class for main GUI serving as the 'root' of the calculator
 *
 * @author Matthew Kounniyom/
 * @since 0.1.0
 *
 *  Log:
 *  - 2/4/2022: Moved testing to here to print calculator functions to a window. Play with Javafx package.
 *  - 2/6/2022: Worked through adding Buttons.
 *  - 2/10/2022: Adding logic for button event handling - remapping screen layout.\
 *  - 2/11/2022: Adjusted screenlayout and added more buttons.
 *  - 2/12/2022: Added VERY basic arithmetic and changed how buttons are created/added.
 *
 *
 */

public class mainGui extends Application {

    private TextArea mainArea = new TextArea("");
    private Label currentButton = new Label("");
    private String currentFunc = "";
    private boolean equals = false;
    private double previous = 0.0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        mainArea.setFont(new Font(18.0));
        mainArea.setPrefRowCount(5);
        mainArea.setPrefColumnCount(10);

        // Button initialization
        int fontSize = 15;

        // redo buttons to add functions :(
        String[][] buttonStr = {
                {"7", "8", "9", "*"},
                {"4", "5", "6", "-"},
                {"1", "2", "3", "+"},
                {"+/-", "0", ".", "/"},
                {"ce", "c", "="}
        };
        ArrayList<Button> buttonList = new ArrayList<Button>();
        Button period, plusMinus;
        for( int i = 0; i < buttonStr.length; i++ ) {
            for( int f = 0; f < buttonStr[i].length; f++) {
                Button temp = new Button(buttonStr[i][f]);
                temp.setMinSize(80.0, 80.0);
                temp.setStyle("-fx-font-size: " + fontSize + ";");
                buttonList.add(temp);
            }
        }

        // Initialize title
        primaryStage.setTitle("My Calculator");
        GridPane root = new GridPane();
        GridPane buttons = new GridPane();

        root.setVgap(10.0);

        //add Buttons
        Iterator<Button> it = buttonList.iterator();
        for( int i = 0; i < buttonStr.length; i++ ) {
            for( int f = 0; f < buttonStr[i].length; f++) {
                Button temp = it.next();
                // add event handler to button
                temp.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e)
                    {
                        currentButton.setText("Current Button: " +temp.getText());
                        if(temp.getText() == "=") {
                            equals = true;
                        }
                        buttonFunction(temp.getText());
                    }
                });
                buttons.add(temp, f, i);
            }
        }

        // Add text
        root.add(mainArea, 0, 0);
        root.add(buttons, 0, 1);
        root.add(currentButton, 0, 2);

        // Set window properties
        primaryStage.setScene(new Scene(root, 320, 500));

        // Show window pane
        primaryStage.show();


    }


    private void buttonFunction(String button) {

        // Make this code cleaner
        double currentValue, nextValue;

        // checks if button is NOT a number then sets the current function.
        if(!isNumber(button)) {
            if(button == "ce" || button == "c") {
                mainArea.setText("");
                currentFunc = "";
                previous = 0.0;
                return;
            }
            if(button != "=") {
                // sets current function to whatever then returns out of function.
                currentFunc = button;
                return;
            }
        }
        // checks if currentFunc not equal __
        if(currentFunc != "") {

            currentValue = Double.valueOf(mainArea.getText());
            if(!equals && previous != 0.0 && currentValue != previous) {
                mainArea.setText(mainArea.getText() + (button));
                return;
            }
            switch(currentFunc) {
                case "+":
                    if(equals) {
                        mainArea.setText(String.valueOf(basicOperations.add(previous, currentValue)));
                        ifWhole();
                        break;
                    }
                    break;
                case "-":
                    if(equals) {
                        mainArea.setText(String.valueOf(basicOperations.subtract(previous, currentValue)));
                        ifWhole();
                        break;
                    }
                    break;
                case "*":
                    if(equals) {
                        mainArea.setText(String.valueOf(basicOperations.multiply(previous, currentValue)));
                        ifWhole();
                        break;
                    }
                    break;
                case "/":
                    if(equals) {
                        mainArea.setText(String.valueOf(basicOperations.divide(previous, currentValue)));
                        ifWhole();
                        break;
                    }
                    break;

            }
            if(equals) {
                currentFunc = "";
                equals = false;
                previous = Double.valueOf(mainArea.getText());
                return;
            }
            if(!equals && previous == 0.0) previous = currentValue;
            mainArea.setText(button);
            return;
        }
        mainArea.setText(mainArea.getText() + (button));
    }

    private void ifWhole() {
        int temp = (int) Double.parseDouble(mainArea.getText());
        double db = Double.valueOf(temp);
        double db2 = Double.valueOf(mainArea.getText());
        if(db == db2) {
            String str = String.valueOf(temp);
            mainArea.setText(String.valueOf(temp));
        }
        return;
    }

    private boolean isNumber(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


}
