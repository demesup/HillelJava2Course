package com.hillel.homework.hw13;

import com.hillel.homework.hw13.Objects.Author;
import com.hillel.homework.hw13.Objects.Book;
import com.hillel.homework.hw13.Objects.Genre;

import com.hillel.homework.hw13.Objects.LibraryObjects;
import com.hillel.homework.hw13.enums.AvailableActions;
import com.hillel.homework.hw13.exceptions.ObjectAlreadyExistException;
import com.hillel.homework.hw13.exceptions.ObjectDoesNorExist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public interface FieldProcessing {
    BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    List<Author> authors = new ArrayList<>();
    List<Book> books = new ArrayList<>();
    List<Genre> genres = new ArrayList<>();

    void workWithField(AvailableActions action) throws ObjectAlreadyExistException, IOException, ObjectDoesNorExist;

    void add() throws ObjectAlreadyExistException, IOException, ObjectDoesNorExist;

    void remove() throws IOException, ObjectDoesNorExist;

    default void print(List<? extends LibraryObjects> list){
        if (list.size() < 1) {
            System.out.println("Empty list");
            return;
        }
        System.out.println(list);
    }
}
