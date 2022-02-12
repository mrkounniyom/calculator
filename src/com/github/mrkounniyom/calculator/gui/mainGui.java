package com.github.mrkounniyom.calculator.gui;

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
 *
 *
 */

public class mainGui extends Application {

    private TextArea mainArea = new TextArea("");
    private Label currentButton = new Label("");

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
        String[] buttonStr = {
                "7", "8", "9", "*",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "+/-", "0", ".", "="
        };
        ArrayList<Button> buttonList = new ArrayList<Button>();
        Button period, plusMinus;
        for( int i = 0; i < buttonStr.length; i++ ) {
            Button temp = new Button(buttonStr[i]);
            temp.setMinSize(80.0, 80.0);
            temp.setStyle("-fx-font-size: " + fontSize + ";");
            buttonList.add(temp);
           /* if (i == 0) {
                plusMinus = new Button("+/-");
                period = new Button(".");
                plusMinus.setMinSize(80.0, 80.0);
                period.setMinSize(80.0, 80.0);
                plusMinus.setStyle("-fx-font-size: " + fontSize + ";");
                period.setStyle("-fx-font-size: " + fontSize + ";");
                buttonList.add(period);
                buttonList.add(temp);
                buttonList.add(plusMinus);
            }
            else
                buttonList.add(temp);*/
        }

        // Initialize title
        primaryStage.setTitle("My Calculator");
        GridPane root = new GridPane();
        GridPane buttons = new GridPane();

        root.setVgap(10.0);

        //add Buttons
        Iterator<Button> it = buttonList.iterator();
        int row = 1;
        int colMax = 4;
        while(it.hasNext()) {
            for(int col = 0; col<colMax; col++) {
                Button temp = it.next();
                // add event handler to button
                temp.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e)
                    {
                         currentButton.setText("Current Button: " +temp.getText());
                         buttonFunction(temp.getText());
                    }
                });
                buttons.add(temp, col, row);
            }
            row++;
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
        boolean isText = false;
        double currentValue = 0.0;

        /**
         * something more like
         *
         * if(number) {
         *  if(!notBlank)
         *      if funcion(x)
         *          switch(curfunc)
         *          return
     *          current = current.concat(new)
     *
         *      return
         *   text = x
         * }
         */

//        if(!isNumber(button)) {
//            currentValue = -1.0;
//        } else {
//            if (mainArea.getText() == "") {
//                currentValue = Double.valueOf(mainArea.getText());
//            } else currentValue = Double.valueOf(button);
//        }





        mainArea.setText(String.valueOf(currentValue));
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
