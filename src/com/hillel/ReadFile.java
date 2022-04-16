package com.hillel;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class ReadFile {
    public static void main(String[] args) {

        try (InputStream inputStream = new FileInputStream("D:\\1급.docx");
             BufferedInputStream buffer = new BufferedInputStream(inputStream)) {
            while (buffer.available() > 0) {
                char c = (char) buffer.read();
                System.out.println("Был прочитан символ " + c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
