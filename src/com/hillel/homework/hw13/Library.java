package com.hillel.homework.hw13;

import com.hillel.homework.hw13.Objects.AvailableObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Library {
    static BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to library");
        start();
    }

    private static void start() throws IOException {
        try {
            while (true) {
                System.out.println("Enter field you want to work with:genre, author, book(press any key to exit)");
                String str = READER.readLine();

                AvailableObjects field = AvailableObjects.valueOf(str.toUpperCase(Locale.ROOT).replaceAll(" ", ""));
                boolean isFound = false;

                for (AvailableObjects object : AvailableObjects.values()) {
                    if (object.equals(field)) {
                        isFound = true;
                        break;
                    }
                }

                if (!isFound) throw new IllegalArgumentException("You can enter only fields or their translation");


            }
        } catch (IllegalArgumentException e) {
            System.out.println("To confirm exit enter ex");
            if (!READER.readLine().replaceAll(" ", "").toLowerCase(Locale.ROOT).equals("ex")) {
                start();
            } else System.out.println("Good bye :)");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
