package com.hillel.classwork.lesson10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ErrorHanding {

    public static BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        System.out.println(readNumber());
        System.out.println(readNumber(1, 8));
    }

    public static int readNumber() {
        System.out.println("Input number");
        try {
            return Integer.parseInt(READER.readLine());
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
            return readNumber();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            return 0;
        }
    }

    public static int readNumber(int min, int max) {
        System.out.println("Input number");
        try {
            int number = Integer.parseInt(READER.readLine());
            if (number < min || number > max) {
                throw new NumberNotInRangeException("Number is wrong");
            }
            return number;
        } catch (RuntimeException e) {
            System.out.println("ERROR: " + e.getMessage());
            return readNumber(min, max);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            return 0;
        }
    }
}
