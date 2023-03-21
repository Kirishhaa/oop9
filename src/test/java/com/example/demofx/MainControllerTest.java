package com.example.demofx;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class MainControllerTest {

    private static final double EPS = 1e-8;

    Operations operations;
    @BeforeEach
    void setUp() {
        operations = new Operations();
    }

    @Test
    public void calcStepsTest(){
        double start = 0.0;
        double end = 2.0;
        double h = 0.002;
        int expected = 1001;
        assertEquals(expected, operations.calcSteps(start,end,h));
    }

    @ParameterizedTest
    @CsvSource({"4, 0","3.72046505, 1.4","0.98386991, 2"})
    public void calcYTest(double expected, double x){
        assertEquals(expected, operations.calcY(x), EPS);
    }

    @ParameterizedTest
    @CsvSource({"4, 0", "9.0529312, 699", "0.9849261, 999"})
    public void getMassiveFromDataTest(double expected, int index){
        ArrayList<Point> values = createArrayList();
        assertEquals(expected, values.get(index).y(), EPS);
    }

    @Test
    public void findMaxTest(){
        ArrayList<Point> values = createArrayList();

        double expectedY = 9.0529312;
        double expectedX = 1.398;
        Point currentPoint = operations.findMax(values);
        assertEquals(expectedY, currentPoint.y(), EPS);
        assertEquals(expectedX, currentPoint.x(), EPS);
    }

    @Test
    public void findMinTest(){
        ArrayList<Point> values = createArrayList();

        double expectedY = 0.983869910;
        double expectedX = 2;
        Point currentPoint = operations.findMin(values);
        assertEquals(expectedY, currentPoint.y(), EPS);
        assertEquals(expectedX, currentPoint.x(), EPS);
    }

    private ArrayList<Point> createArrayList() {
        double start = 0;
        double end = 2;
        double step = 0.002;
        return operations.getMassiveFromData(
                start,step, operations.calcSteps(start,end, step));
    }


    @Test
    public void sumValuesTest(){
        ArrayList<Point> values = createArrayList();
        double expected = 4285.09577854;
        assertEquals(expected, operations.sumValues(values), EPS);
    }

    @Test
    public void averageValuesTest(){
        ArrayList<Point> values = createArrayList();
        double expected = 4.28081496;
        assertEquals(expected, operations.averageValues(values), EPS);
    }
}