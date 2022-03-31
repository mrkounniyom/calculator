package com.github.mrkounniyom.calculator.gui;

import com.github.mrkounniyom.calculator.operations.advOperations;
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
import java.util.Objects;

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
 *  - 3/31/2022: Final Changes.
 *
 *
 */

public class mainGui extends Application {

    // JavaFX Stores
    private final TextArea mainArea = new TextArea("");
    private final TextArea hist = new TextArea("");
    private final Label currentButton = new Label("");
    private boolean defVal = true;
    private double previousValue = 0.0d;
    private double currentValue;

    // Variables for functionality
    private boolean equals = false;
    private boolean addDec = false;
    private String currentFunc = "";
    private String histString = "";
    private ArrayList<String> btnList = new ArrayList<String>();

    /**
     *  Default main function
     *
     * @param args default
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * GUI start method from JavaFX
     *
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {

        mainArea.setFont(new Font(18.0));
        mainArea.setPrefRowCount(5);
        mainArea.setPrefColumnCount(10);

        hist.setFont(new Font(18.0));
        hist.setPrefColumnCount(10);
        hist.setPrefRowCount(5);
        hist.setEditable(false);

        // Button initialization
        int fontSize = 15;

        // redo buttons to add functions :(
        String[][] buttonStr = {
                {"^2", "sqrt", "%", "<="},
                {"7", "8", "9", "*"},
                {"4", "5", "6", "-"},
                {"1", "2", "3", "+"},
                {"+/-", "0", ".", "/"},
                {"ce", "c", "="}
        };

        btnList.add(buttonStr[0][0]);
        btnList.add(buttonStr[0][1]);
        btnList.add(buttonStr[0][2]);
        btnList.add(buttonStr[0][3]);
        btnList.add(buttonStr[1][3]);
        btnList.add(buttonStr[2][3]);
        btnList.add(buttonStr[3][3]);
        btnList.add(buttonStr[4][0]);
        btnList.add(buttonStr[4][3]);
        btnList.add(buttonStr[5][0]);
        btnList.add(buttonStr[5][1]);
        btnList.add(buttonStr[5][2]);

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
        //root.add(currentButton, 0, 2);
        root.add(hist, 1, 0);

        // Set window properties
        primaryStage.setScene(new Scene(root, 530, 600));

        // Show window pane
        primaryStage.show();


    }


    private void buttonFunction(String button) {

        // Make this code cleaner
        // default double value is 0.0d
        currentValue = 0.0d;

        // checks if button is NOT a number then sets the current function.
        if(!isNumber(button) && !Objects.equals(button, "=")) {
            nonNumericButtons(button);
        }
        // checks if currentFunc not equal __
        else if(!Objects.equals(currentFunc, "")) {
            buttonFunctions(button);
        } else {
            defVal = false;
            mainArea.setText(mainArea.getText() + (button));
        }
    }

    private void nonNumericButtons(String button) {
        // clears screen/values
        if(button.equals("ce") || button.equals("c")) {
            reset();
            return;
        }
        if(button.equals("+/-")) {
            try {
                currentValue = Double.parseDouble(mainArea.getText());
            } catch (java.lang.NumberFormatException e) {
                currentValue = previousValue;
            }
            if(defVal) {
                return;
            } else if((currentValue - currentValue) == 0.0) {
                mainArea.setText(String.valueOf(basicOperations.negative(currentValue)));
            }
            else mainArea.setText(String.valueOf(basicOperations.positive(currentValue)));
            ifWhole();
            histStringAdd(previousValue + " " + button + " = " + mainArea.getText());
            histStringPrint();
            return;
        }
        // sets current function to whatever then returns out of function.
        if(Objects.equals(button, ".")) {
            addDec = true;
            if (!currentFunc.equals("") && mainArea.getText().isEmpty()) {
                mainArea.setText(button);
                return;
            }
            else mainArea.setText(mainArea.getText() + (button));
            return;
        }
        if(button.equals("^2")) {
            // Square
            if(!defVal|| !mainArea.getText().equals("")) {
                previousValue  = Double.parseDouble(mainArea.getText());
                mainArea.setText(String.valueOf(advOperations.squared(previousValue)));
                ifWhole();
                histStringAdd(previousValue + " " + button + " = " + mainArea.getText());
                histStringPrint();
            }
            return;
        }
        if(button.equals("sqrt")) {
            //square root
            if(!defVal || !mainArea.getText().equals("")) {
                previousValue  = Double.parseDouble(mainArea.getText());
                mainArea.setText(String.valueOf(advOperations.square(previousValue)));
                ifWhole();
                histStringAdd(previousValue + " " + button + " = " + mainArea.getText());
                histStringPrint();
            }
            return;
        }
        if(button.equals("%")) {
            //percent
            if(!defVal || !mainArea.getText().equals("")) {
                previousValue  = Double.parseDouble(mainArea.getText());
                mainArea.setText(String.valueOf(advOperations.percentage(previousValue)));
                ifWhole();
                histStringAdd(previousValue + " " + button + " = " + mainArea.getText());
                histStringPrint();
            }
            return;
        }
        if(button.equals("<=")) {
            //backspace
            if(!defVal || !mainArea.getText().equals("")) {
                String temp  = mainArea.getText();
                int len = temp.length();
                mainArea.setText(temp.substring(0, (len-1)));
                histStringAdd(previousValue + " " + button + " = " + mainArea.getText());

            }
            return;
        }
        if(addDec) {
            addDec = false;
        }
        currentFunc = button;
        previousValue = Double.parseDouble(mainArea.getText());
        defVal = false;
        mainArea.setText("");
    }

    private void buttonFunctions(String button) {
        // Are we working in decimals?
        if(addDec) {
            if (!button.equals(".")) {
                if(btnList.contains(button)){
                    addDec = false;
                } else { mainArea.setText(mainArea.getText() + (button)); return; }
            }

        }

        if(!currentFunc.equals("") && equals) {
            currentValue = Double.parseDouble(mainArea.getText());
        }

        // append to histString
        switch(currentFunc) {

            case "+":
                if(equals) {
                    mainArea.setText(String.valueOf(basicOperations.add(previousValue, currentValue)));
                    ifWhole();
                    histStringAdd(previousValue + " " + currentFunc + " " + currentValue);
                    break;
                }
                break;
            case "-":
                if(equals) {
                    Double val = basicOperations.subtract(previousValue, currentValue);
                    mainArea.setText(String.valueOf(val));
                    ifWhole();
                    histStringAdd(previousValue + " " + currentFunc + " " + currentValue);
                    break;
                }
                break;
            case "*":
                if(equals) {
                    mainArea.setText(String.valueOf(basicOperations.multiply(previousValue, currentValue)));
                    ifWhole();
                    histStringAdd(previousValue + " " + currentFunc + " " + currentValue);
                    break;
                }
                break;
            case "/":
                if(equals) {
                    mainArea.setText(String.valueOf(basicOperations.divide(previousValue, currentValue)));
                    ifWhole();
                    histStringAdd(previousValue + " " + currentFunc + " " + currentValue);
                    break;
                }
                break;
        }
        if(equals) {
            histStringAdd("= " + mainArea.getText());
            histStringPrint();
            currentFunc = "";
            equals = false;
            previousValue = Double.parseDouble(mainArea.getText());
            return;
        }
        if(defVal) { defVal = false; previousValue = currentValue; }
        else {
            if(!currentFunc.equals("") && !mainArea.getText().equals("") && !addDec)
            {
                mainArea.setText(mainArea.getText() + (button));
            }
            else mainArea.setText(button);
        }

    }

    private void histStringAdd(String s) {
        if (!histString.isEmpty()) {
            histString = histString + " " + s;
        } else {
            histString = s;
        }

    }

    private void histStringPrint() {
        if(!histString.isEmpty()) {
            hist.appendText(histString + "\n");
            histString = "";
        }
    }

    private void reset() {
        mainArea.setText("");
        currentFunc = "";
        previousValue = 0.0d;
        equals = false;
        addDec = false;
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
