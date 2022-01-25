package com.github.mrkounniyom.calculator;

/**
 *
 * Class to contain basic math operations like addition, subtraction, division and multiplication.
 *
 * Created 1-24-2022
 * @author Matthew Kounniyom
 *
 */

public class basicOperations {

    /**
     * Adds values x & y
     *
     * @param x first value
     * @param y value to be added
     */
    public static double add(double x, double y) {
        return x + y;
    }

    /**
     * Subtracts values x & y
     *
     * @param x first value
     * @param y value to be subtracted
     */
    public static double subtract(double x, double y) {
        return x - y;
    }

    /**
     * Multiplies values x & y
     *
     * @param x first value
     * @param y value to be multiplied
     */
    public static double multiply(double x, double y) {
        return x * y;
    }

    /**
     * Divides values x & y
     *
     * @param x first value
     * @param y value to be divided
     */
    public static double divide(double x, double y) {
        return x / y;
    }

}
