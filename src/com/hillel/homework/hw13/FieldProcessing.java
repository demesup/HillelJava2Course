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

    void workWithField(AvailableActions action, String name) throws ObjectAlreadyExistException, IOException, ObjectDoesNorExist;


    static int findObject(List<? extends LibraryObjects> objects, String name) {
        for (LibraryObjects object : objects) {
            if (object.getName().equalsIgnoreCase(name)) return objects.indexOf(object);
        }
        return -1;
    }

    static boolean checkIfHave(List<? extends LibraryObjects> objects, String name) {
        if (objects.size() == 0) return false;
        for (LibraryObjects object : objects) {
            if (object.getName().equalsIgnoreCase(name)) return true;
        }
        return false;
    }

    static AvailableActions getStaticAction() throws IOException {
        System.out.println("Enter action: add, remove, print all genres/press any key to exit");
        String string = READER.readLine().replaceAll(" ", "");

        AvailableActions action = null;

        for (AvailableActions avAction : AvailableActions.values()) {
            if (avAction.name().equalsIgnoreCase(string)) {
                action = AvailableActions.valueOf(string.toUpperCase());
                break;
            }
        }
        if (action == null) {
            throw new IllegalArgumentException("You can enter only action");
        }
        return action;
    }

    default AvailableActions getAction() throws IOException {
        System.out.println("Enter action: add, remove, print all genres/press any key to exit");
        String string = READER.readLine().replaceAll(" ", "");

        AvailableActions action = null;

        for (AvailableActions avAction : AvailableActions.values()) {
            if (avAction.name().equalsIgnoreCase(string)) {
                action = AvailableActions.valueOf(string.toUpperCase());
                break;
            }
        }
        if (action == null) {
            throw new IllegalArgumentException("You can enter only action");
        }
        return action;
    }

    default int readNumber() throws IOException {
        return Integer.parseInt(READER.readLine());
    }
}
