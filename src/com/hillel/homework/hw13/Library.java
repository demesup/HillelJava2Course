package com.hillel.homework.hw13;

import com.hillel.homework.hw13.Objects.AvailableObjects;
import com.hillel.homework.hw13.Objects.Genre;

public class Library {
    public static void main(String[] args) {
        System.out.println("Welcome to library. To start working enter number of field you want to work with:" +
                " genre, author, book");

        AvailableObjects.valueOf("genre".toUpperCase());
    }
}
