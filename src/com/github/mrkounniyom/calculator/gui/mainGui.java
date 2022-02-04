package com.github.mrkounniyom.calculator.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import static com.github.mrkounniyom.calculator.operations.advOperations.square;
import static com.github.mrkounniyom.calculator.operations.basicOperations.*;
import static com.github.mrkounniyom.calculator.operations.basicOperations.divide;

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
        StackPane root = new StackPane();

        // Text Thing
        Text t = new Text();
        t.setFont(new Font(20));
        t.setText(textStr);

        // Add text
        root.getChildren().add(t);

        // Set window properties
        primaryStage.setScene(new Scene(root, 1366, 768));

        // Show window pane
        primaryStage.show();


    }
}
