package com.github.mrkounniyom.calculator;

import com.github.mrkounniyom.calculator.gui.mainGui;

import java.util.ArrayList;

/**
 *
 * Basic/Scientific Calculator application created for a coding project.
 *
 * @author Matthew Kounniyom
 * @version 0.1.2
 * @since 0.0.1
 *
 * Log:
 * - 1/24/2022: added java classes for advance operations and basic operations. Did some testing in the main method.
 * - 2/4/2022: Moved testing to mainGui package to print calculator functions to a window.
 *
 *
 */

public class Main {

    private ArrayList<Float> history = new ArrayList<Float>();
    private float current = 0;

    public static void startgui(String[] args) {
        mainGui.main(args);
    }

    public static void main(String[] args) {
	// write your code here
    // bleh

        startgui(args);

    }
}
