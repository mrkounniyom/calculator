package com.github.mrkounniyom.calculator.operations;

import java.math.BigDecimal;

import static java.lang.Math.abs;

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
        BigDecimal temp = BigDecimal.valueOf(x);
        BigDecimal temp2 = BigDecimal.valueOf(y);
        return temp.subtract(temp2).doubleValue();
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

    /**
     * Returns the negative of x
     *
     * @param x value to be negative(d)
     */
    public static double negative(double x) {
        return x * -1;
    }

    /**
     * Returns the positive of x
     *
     * @param x value to be positive(d)
     */
    public static double positive(double x) {
        return abs(x);
    }

}
