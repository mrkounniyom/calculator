package com.github.mrkounniyom.calculator;

import java.util.ArrayList;

import static com.github.mrkounniyom.calculator.basicOperations.*;
import static com.github.mrkounniyom.calculator.advOperations.*;

/**
 *
 * Basic/Scientific Calculator application created for a coding project.
 *
 * @author Matthew Kounniyom
 * @version 0.1
 * @since 0.1
 *
 * Log:
 * - 1/24/2022: added java classes for advance operations and basic operations. Did some testing in the main method.
 *
 *
 */

public class Main {

    private ArrayList<Float> history = new ArrayList<Float>();
    private float current = 0;

    public static void main(String[] args) {
	// write your code here
    // bleh
        double x, y;
        x = 12.2;
        y = 25.0;

        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("Value of x + y = " + add(x, y));
        System.out.println("Value of x - y = " + subtract(x, y));
        System.out.println("Value of x * y = " + multiply(x, y));
        System.out.println("Value of x / y = " + divide(x, y));
        System.out.println("Square root of x = " + square(x));
        System.out.println("Square root of y = " + square(y));

    }
}
