package com.github.mrkounniyom.calculator.operations;
import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

/**
 *
 * Class to contain advanced math operations like square root, -- more to come.
 *
 * Created 1-24-2022
 * @author Matthew Kounniyom
 *
 */

public class advOperations {

    /**
     * Gets the square root of x
     *
     * @param x value to be find the square root of.
     * @return the squareroot of x.
     */
    public static double square(double x) {
        return sqrt(x);
    }


    /**
     * Gets the square of x
     *
     * @param x value to be find the square of.
     * @return x squared.
     */
    public static double squared(double x) {
        return abs(x) * abs(x);
    }

    /**
     * Turns x into a percent
     *
     * @param x value out of 100.
     * @return x out of 100.
     */
    public static double percentage(double x) {
        return abs(x) / 100;
    }
}
