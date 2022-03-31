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
     * @return x + y
     */
    public static double add(double x, double y) {
        BigDecimal temp = BigDecimal.valueOf(x);
        BigDecimal temp2 = BigDecimal.valueOf(y);
        return temp.add(temp2).doubleValue();
    }

    /**
     * Subtracts values x & y
     *
     * @param x first value
     * @param y value to be subtracted
     * @return x - y
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
     * @return x * y
     */
    public static double multiply(double x, double y) {
        BigDecimal temp = BigDecimal.valueOf(x);
        BigDecimal temp2 = BigDecimal.valueOf(y);
        return temp.multiply(temp2).doubleValue();
    }

    /**
     * Divides values x & y
     *
     * @param x first value
     * @param y value to be divided
     * @return x / y
     */
    public static double divide(double x, double y) {
        BigDecimal temp = BigDecimal.valueOf(x);
        BigDecimal temp2 = BigDecimal.valueOf(y);
        return temp.divide(temp2).doubleValue();
    }

    /**
     * Returns the negative of x
     *
     * @param x value to be negative(d)
     * @return negative x
     */
    public static double negative(double x) {
        return x * -1;
    }

    /**
     * Returns the positive of x
     *
     * @param x value to be positive(d)
     * @return positive y
     */
    public static double positive(double x) {
        return abs(x);
    }

}
