package com.github.mrkounniyom.calculator.tests;

import com.github.mrkounniyom.calculator.operations.advOperations;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class testAdvOperations {

    @Test
    public void squareRootSuccess() {
        assertEquals(5.0, advOperations.square(25.0), 0.0);
        assertEquals(7.0, advOperations.square(49.0), 0.0);
        assertEquals(8.0, advOperations.square(64.0), 0.0);
    }

    @Test
    public void squareRootFail() {
        assertNotEquals(4.0, advOperations.square(25.0), 0.0);
    }

    @Test
    public void squareSuccess() {
        assertEquals(25.0, advOperations.squared(5.0), 0.0);
        assertEquals(49.0, advOperations.squared(7.0), 0.0);
        assertEquals(64.0, advOperations.squared(8.0), 0.0);
    }

    @Test
    public void squareFail() {
        assertNotEquals(4.0, advOperations.squared(25.0), 0.0);
    }

    @Test
    public void percentageSuccess() {
        assertEquals(0.05, advOperations.percentage(5.0), 0.0);
        assertEquals(0.07, advOperations.percentage(7.0), 0.0);
        assertEquals(0.08, advOperations.percentage(8.0), 0.0);
    }

    @Test
    public void percentageFail() {
        assertNotEquals(4.0, advOperations.percentage(25.0), 0.0);
    }

}
