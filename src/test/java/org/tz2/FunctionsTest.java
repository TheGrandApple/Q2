package org.tz2;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;


public class FunctionsTest {

    @Test
    void checkSum() {
        long[] numbers = Functions.readFile("testSum.txt");

        long sumTotal = Functions.sum(numbers);

        assertEquals(11, sumTotal);
    }

    @Test
    void checkMult() {
        long[] numbers = Functions.readFile("testMult.txt");

        long multTotal = Functions.mult(numbers);

        assertEquals(120, multTotal);
    }

    @Test
    void checkMax() {
        long[] numbers = Functions.readFile("testMax.txt");

        long maxTotal = Functions.max(numbers);

        assertEquals(92, maxTotal);
    }

    @Test
    void checkMin() {
        long[] numbers = Functions.readFile("testMin.txt");

        long minTotal = Functions.min(numbers);

        assertEquals(0, minTotal);
    }

    @Test
    void checkException() {
        long[] numbers = Functions.readFile("testException.txt");
        assertThrows(ArithmeticException.class, () -> Functions.mult(numbers));
    }

    @Test
    @Timeout(value = 300, unit = TimeUnit.MILLISECONDS)
    void checkTime() throws InterruptedException {
        long[] numbers = Functions.readFile("testMax.txt");
        
        Thread.sleep(300);
        long maxTotal = Functions.max(numbers);

        assertEquals(92, maxTotal);
    }

    @Test
    void wrongOnPurposeTest() {
        long[] numbers = Functions.readFile("testMax.txt");

        long maxTotal = Functions.max(numbers);

        assertEquals(91, maxTotal);
    }
}

