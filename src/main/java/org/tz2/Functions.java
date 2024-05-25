package org.tz2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.Math.abs;

public class Functions
{
    public static void main( String[] args ) throws IOException {
        long[] numbers = readFile("input.txt");
        long pr = mult(numbers);
        System.out.println(pr);
    }

    public static long[] readFile(String filename) {
        String line = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            line = reader.readLine();
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        String[] strList = line.split(" ");
        long[] numList = new long[strList.length];
        for (int i = 0; i < strList.length; i++) {
            numList[i] = Long.parseLong(strList[i]);
        }
        return numList;
    }

    public static long sum(long[] list) {
        long s = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] > 0) {
                if (s > Long.MAX_VALUE - list[i]) {
                    throw new ArithmeticException();
                }
            } else {
                if (s < Long.MIN_VALUE - list[i]) {
                    throw new ArithmeticException();
                }
            }
            s += list[i];
        }
        return s;
    }

    public static long mult(long[] list) {
        long pr = 1;
        for (int i = 0; i < list.length; i++) {
            if (abs(Long.MAX_VALUE / pr) < abs(list[i])) {
                throw new ArithmeticException();
            }
            pr *= list[i];
        }
        return pr;
    }
    public static long min(long[] list) {
        long m = Long.MAX_VALUE;
        for (int i = 0; i < list.length; i++) {
            if (list[i] < m) {
                m = list[i];
            }
        }
        return m;
    }

    public static long max(long[] list) {
        long m = Long.MIN_VALUE;
        for (int i = 0; i < list.length; i++) {
            if (list[i] > m) {
                m = list[i];
            }
        }
        return m;
    }
}
