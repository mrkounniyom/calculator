package com.github.mrkounniyom.calculator.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Iterator;

import static com.github.mrkounniyom.calculator.operations.advOperations.square;
import static com.github.mrkounniyom.calculator.operations.basicOperations.*;

/**
 *
 * Class for main GUI serving as the 'root' of the calculator
 *
 * @author Matthew Kounniyom
 * @version 0.0.2
 * @since 0.2
 *
 *  Log:
 *  - 2/4/2022: Moved testing to here to print calculator functions to a window. Play with Javafx package.
 *  - 2/6/2022: Worked through adding Buttons.
 *
 *
 */

public class mainGui extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        String textStr = "";

        double x, y;
        x = 12.2;
        y = 25.0;

        textStr = textStr + ("x = " + x + "\n");
        textStr = textStr + ("y = " + y + "\n");
        textStr = textStr + ("Value of x + y = " + add(x, y) + "\n");
        textStr = textStr + ("Value of x - y = " + subtract(x, y) + "\n");
        textStr = textStr + ("Value of x * y = " + multiply(x, y) + "\n");
        textStr = textStr + ("Value of x / y = " + divide(x, y) + "\n");
        textStr = textStr + ("Square root of x = " + square(x) + "\n");
        textStr = textStr + ("Square root of y = " + square(y) + "\n");


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
//        primaryStage.setTitle("Hello World!");
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
//
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//        primaryStage.setScene(new Scene(root, 300, 250));
//        primaryStage.show();
        // Initialize title
        primaryStage.setTitle("My Calculator");
        GridPane root = new GridPane();

        // Text Thing
        Text t = new Text();
        t.setFont(new Font(20));
        t.setText(textStr);

        // Add text
        // root.add(t, 1, 0);


        //add Buttons
        Iterator<Button> it = buttonList.iterator();
        int row = 1;
        int col;
        while(it.hasNext()) {
            for(col = 0; col<3; col++) {
                root.add(it.next(), col, row);
            }
            row++;
            col = 0;
        }
        // Set window properties
        primaryStage.setScene(new Scene(root, 1366, 768));

        // Show window pane
        primaryStage.show();


    }
}
