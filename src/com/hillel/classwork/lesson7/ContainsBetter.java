package com.hillel.classwork.lesson7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ContainsBetter {
    public static void main(String[] args) throws IOException {
        List<String> words = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while (!(input = reader.readLine()).equals("stop")) {
            words.add(input);
        }

        int count = 0;
        for (String word : words) {
            if (word.contains("war")) {
                count++;
            }
        }
        System.out.println("Number of banned words: " + count);
    }
}
