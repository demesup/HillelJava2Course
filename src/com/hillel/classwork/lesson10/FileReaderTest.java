package com.hillel.classwork.lesson10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\User\\Downloads\\readMe.txt"))) {
            System.out.println(reader.readLine());
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
