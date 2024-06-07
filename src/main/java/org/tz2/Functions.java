package org.tz2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Functions
{
    public static void main( String[] args ) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу");
        String path = scanner.nextLine();
        long[] numbers = readFile(path);
        System.out.println("Сумма чисел:");
        long s = sum(numbers);
        System.out.println(s);
        System.out.println("Произведение чисел:");
        long pr = mult(numbers);
        System.out.println(pr);
        System.out.println("Минимум из чисел:");
        long mn = min(numbers);
        System.out.println(mn);
        System.out.println("Максимум из чисел:");
        long mx = max(numbers);
        System.out.println(mx);
    }

    public static long[] readFile(String filename) {
        String line = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            line = reader.readLine();
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
        long t1 = System.nanoTime();
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
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        return s;
    }

    public static long mult(long[] list) {
        long t1 = System.nanoTime();
        long pr = 1;
        for (int i = 0; i < list.length; i++) {
            if ((pr != 0) && (abs(Long.MAX_VALUE / pr) < abs(list[i]))) {
                throw new ArithmeticException();
            }
            pr *= list[i];
        }
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        return pr;
    }
    public static long min(long[] list) {
        long t1 = System.nanoTime();
        long m = Long.MAX_VALUE;
        for (int i = 0; i < list.length; i++) {
            if (list[i] < m) {
                m = list[i];
            }
        }
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        return m;
    }

    public static long max(long[] list) {
        long t1 = System.nanoTime();
        long m = Long.MIN_VALUE;
        for (int i = 0; i < list.length; i++) {
            if (list[i] > m) {
                m = list[i];
            }
        }
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        return m;
    }
}
