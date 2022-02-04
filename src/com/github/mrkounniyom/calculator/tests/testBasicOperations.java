package com.github.mrkounniyom.calculator.tests;

import com.github.mrkounniyom.calculator.operations.basicOperations;
import org.junit.Test;

import static org.junit.Assert.*;

public class testBasicOperations {

    @Test
    public void additionSuccess() {
        assertEquals(2.0, basicOperations.add(1.0, 1.0), 0.0);
        assertEquals(1.0, basicOperations.add(2.0, -1.0), 0.0);
        assertEquals(5.0, basicOperations.add(3.0, 2.0), 0.0);
    }

    @Test
    public void additionFail() {
        assertNotEquals(2.99, basicOperations.add(1.999, 0.99999999999), 0.0);
    }

    @Test
    public void subtractionSuccess() {
        assertEquals(2.0, basicOperations.subtract(5.0, 3.0), 0.0);
        assertEquals(1.1, basicOperations.subtract(4.0, 2.9), 0.0);
        assertEquals(96.0, basicOperations.subtract(99.0, 3.0), 0.0);
    }

    @Test
    public void subtractionFail() {
        assertNotEquals(2.99, basicOperations.subtract(1.999, 0.99999999999), 0.0);
    }

    @Test
    public void multiplicationSuccess() {
        assertEquals(110.0, basicOperations.multiply(11.0, 10.0), 0.0);
        assertEquals(10.0, basicOperations.multiply(5.0, 2.0), 0.0);
        assertEquals(7.0, basicOperations.multiply(2.0, 3.5), 0.0);
    }

    @Test
    public void multiplicationFail() {
        assertNotEquals(2.99, basicOperations.multiply(1.999, 0.99999999999), 0.0);
    }

    @Test
    public void divisionSuccess() {
        assertEquals(2.0, basicOperations.divide(18.0, 9.0), 0.0);
        assertEquals(5.0, basicOperations.divide(25.0, 5.0), 0.0);
        assertEquals(100.0, basicOperations.divide(1000.0, 10.0), 0.0);
    }

    @Test
    public void divisionFail() {
        assertNotEquals(2.99, basicOperations.divide(1.999, 0.99999999999), 0.0);
    }

    @Test
    public void negativeSuccess() {
        assertEquals(-18.0, basicOperations.negative(18.0), 0.0);
        assertEquals(-25.0, basicOperations.negative(25.0), 0.0);
        assertEquals(-1000.0, basicOperations.negative(1000.0), 0.0);
    }

    @Test
    public void negativeFail() {
        assertNotEquals(2.99, basicOperations.negative(-1.999), 0.0);
    }

    @Test
    public void positiveSuccess() {
        assertEquals(18.0, basicOperations.negative(-18.0), 0.0);
        assertEquals(25.0, basicOperations.negative(-25.0), 0.0);
        assertEquals(1000.0, basicOperations.negative(-1000.0), 0.0);
    }

    @Test
    public void positiveFail() {
        assertNotEquals(2.99, basicOperations.negative(-1.999), 0.0);
    }

}
