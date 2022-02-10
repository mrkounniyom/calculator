package com.github.mrkounniyom.calculator.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
 * @since 0.2
 *
 *  Log:
 *  - 2/4/2022: Moved testing to here to print calculator functions to a window. Play with Javafx package.
 *  - 2/6/2022: Worked through adding Buttons.
 *  - 2/10/2022: Adding logic for button event handling - remapping screen layout.
 *
 *
 */

public class mainGui extends Application {

    private TextArea mainArea = new TextArea("");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        mainArea.setFont(new Font(18.0));

        // Button initialization
        int buttonCnt = 10;
        int fontSize = 15;

        ArrayList<Button> buttonList = new ArrayList<Button>();
        Button period, plusMinus;
        for( int i = 0; i < buttonCnt; i++ ) {
            Button temp = new Button("" + i);
            temp.setMinSize(80.0, 80.0);
            temp.setStyle("-fx-font-size: " + fontSize + ";");
            if (i == 0) {
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
                buttonList.add(temp);
        }

        // Initialize title
        primaryStage.setTitle("My Calculator");
        GridPane root = new GridPane();
        GridPane buttons = new GridPane();

        root.setVgap(10.0);

        //add Buttons
        Iterator<Button> it = buttonList.iterator();
        int row = 1;
        int col;
        while(it.hasNext()) {
            for(col = 0; col<3; col++) {
                Button temp = it.next();
                // add event handler to button
                temp.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e)
                    {
                        mainArea.setText(mainArea.getText() + temp.getText());
                    }
                });
                buttons.add(temp, col, row);
            }
            row++;
        }

        // Add text
        root.add(mainArea, 0, 0);
        root.add(buttons, 0, 1);

        // Set window properties
        primaryStage.setScene(new Scene(root, 1366, 768));

        // Show window pane
        primaryStage.show();


    }
}
