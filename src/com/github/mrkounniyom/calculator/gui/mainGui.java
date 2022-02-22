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

    // JavaFX Stores
    private final TextArea mainArea = new TextArea("");
    private final Label currentButton = new Label("");
    private double previousValue = 0.0d;
    private double currentValue;

    // Variables for functionality
    private boolean equals = false;
    private boolean addDec = false;
    private String currentFunc = "";

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
        primaryStage.setScene(new Scene(root, 320, 600));

        // Show window pane
        primaryStage.show();


    }


    private void buttonFunction(String button) {

        // Make this code cleaner
        // default double value is 0.0d
        currentValue = 0.0d;

        // checks if button is NOT a number then sets the current function.
        if(!isNumber(button) && button != "=") {
            // clears screen/values
            if(button == "ce" || button == "c") {
                reset();
                return;
            }
            if(button=="+/-") {
                try {
                    currentValue = Double.valueOf(mainArea.getText());
                } catch (java.lang.NumberFormatException e) {
                    currentValue = previousValue;
                }
                if(currentValue == 0.0d || currentValue == 0.0) {
                    return;
                } else if((currentValue - currentValue) == 0.0) {
                    mainArea.setText(String.valueOf(basicOperations.negative(currentValue)));
                }
                else mainArea.setText(String.valueOf(basicOperations.positive(currentValue)));
                ifWhole();
                return;
            }
            // sets current function to whatever then returns out of function.
            if(button == "." ) {
                addDec = true;
                if (currentFunc != "") {
                    previousValue = Double.valueOf(mainArea.getText());
                    mainArea.setText(button);
                    return;
                }
                else mainArea.setText(mainArea.getText() + (button));
                return;
            }
            addDec = false;
            currentFunc = button;
            previousValue = Double.valueOf(mainArea.getText());
            return;
        }
        // checks if currentFunc not equal __
        if(currentFunc != "") {

            if(addDec && equals) {
                addDec = false;
                currentValue = Double.valueOf(mainArea.getText());
            } else if (!addDec) {
                currentValue = Double.valueOf(mainArea.getText());
            }
            if(!equals && previousValue != 0.0 && !addDec) {
                if(currentFunc != "" && previousValue != 0.0d) mainArea.setText(button);
                else mainArea.setText(mainArea.getText() + (button));
                return;
            }
            switch(currentFunc) {
                case "+":
                    if(equals) {
                        mainArea.setText(String.valueOf(basicOperations.add(previousValue, currentValue)));
                        ifWhole();
                        break;
                    }
                    break;
                case "-":
                    if(equals) {
                        mainArea.setText(String.valueOf(basicOperations.subtract(previousValue, currentValue)));
                        ifWhole();
                        break;
                    }
                    break;
                case "*":
                    if(equals) {
                        mainArea.setText(String.valueOf(basicOperations.multiply(previousValue, currentValue)));
                        ifWhole();
                        break;
                    }
                    break;
                case "/":
                    if(equals) {
                        mainArea.setText(String.valueOf(basicOperations.divide(previousValue, currentValue)));
                        ifWhole();
                        break;
                    }
                    break;
            }
            if(equals) {
                currentFunc = "";
                equals = false;
                previousValue = Double.valueOf(mainArea.getText());
                return;
            }
            if(previousValue == 0.0d) previousValue = currentValue;
            if(addDec) { mainArea.setText(mainArea.getText() + (button)); return; }
            mainArea.setText(button);
            return;
        }
        mainArea.setText(mainArea.getText() + (button));
    }

    private void reset() {
        mainArea.setText("");
        currentFunc = "";
        previousValue = 0.0d;
        equals = false;
        addDec = false;
        return;
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
