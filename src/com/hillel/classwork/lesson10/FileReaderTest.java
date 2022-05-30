package com.hillel.classwork.lesson10;

import java.io.*;

public class FileReaderTest {

    public static String FILE_NAME = "C:\\Users\\User\\Downloads\\readMe.txt";

    public static void main(String[] args) throws IOException {
        readFile();
        writeFile("\ntext new hi");
    }

    private static void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            while (reader.ready()) System.out.println(reader.readLine());
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public static void writeFile(String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(text);
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
