package org.tz2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;


@Timeout(value = 300, unit = TimeUnit.MILLISECONDS)
public class FunctionsTest {

    @Test
    void TestCheckSumTest() {
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
    void checkSumTime() {
        long t1 = System.nanoTime();
        long[] numbers = Functions.readFile("testSumTime.txt");

        long sumTotal = Functions.sum(numbers);

        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        assertEquals(498899085, sumTotal);
    }

    @Test
    void checkMaxTime() {
        long t1 = System.nanoTime();
        long[] numbers = Functions.readFile("testMaxTime.txt");

        long maxTotal = Functions.max(numbers);

        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        assertEquals(99980, maxTotal);
    }

    @Test
    void checkMinTime() {
        long t1 = System.nanoTime();
        long[] numbers = Functions.readFile("testMinTime.txt");

        long minTotal = Functions.min(numbers);

        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        assertEquals(4, minTotal);
    }

    @Test
    void checkMultTime() { // файл для проверки умножения значительно короче остальных, так как иначе произведение выходит на Long.MAXVALUE
        long t1 = System.nanoTime();
        long[] numbers = Functions.readFile("testMultTime.txt");

        long multTotal = Functions.mult(numbers);

        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        assertEquals(8589934592L, multTotal);
    }

    @Test
    void checkTime() throws InterruptedException {
        long t1 = System.nanoTime();
        long[] numbers = Functions.readFile("testSumTime.txt");

        Thread.sleep(300);
        long sumTotal = Functions.sum(numbers);

        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        assertEquals(498899085, sumTotal);
    }

    @Test
    void checkException() {
        long[] numbers = Functions.readFile("testException.txt");

        assertThrows(ArithmeticException.class, () -> {
            long sumTotal = Functions.mult(numbers);
        });
    }
}

