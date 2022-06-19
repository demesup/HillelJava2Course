package com.hillel.homework.hw13;

import com.hillel.homework.hw13.Objects.Author;
import com.hillel.homework.hw13.Objects.Book;
import com.hillel.homework.hw13.Objects.Genre;
import com.hillel.homework.hw13.enums.AvailableActions;
import com.hillel.homework.hw13.enums.AvailableObjects;
import com.hillel.homework.hw13.exceptions.ObjectAlreadyExistException;
import com.hillel.homework.hw13.exceptions.ObjectDoesNorExist;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;


public class Library {
    static BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Thread thread = new Thread(new Sound(new File("D:\\IdeaProjects\\Java\\src\\com\\hillel\\homework\\hw13\\music.wav")));
        thread.start();

        System.out.println("Welcome to library :)");

        start();

    }

    private static void start() throws IOException {
        try {

            System.out.println("Enter field you want to work with:genre, author, book(press any key to exit)");
            String str = READER.readLine().replaceAll(" ", "");

            AvailableObjects field = null;

            for (AvailableObjects object : AvailableObjects.values()) {
                if (object.name().equalsIgnoreCase(str)) {
                    field = AvailableObjects.valueOf(str.toUpperCase());
                    break;
                }
            }
            if (field == null) {
                throw new IllegalArgumentException("You can enter only fields");
            }
            AvailableActions action = FieldProcessing.getStaticAction();
            String name = null;
            if (action.equals(AvailableActions.ADD)) {
                System.out.println("Enter name:");
                name = READER.readLine();
            }
            switch (field) {
                case AUTHOR:
                    new Author().workWithField(action, name);
                case GENRE:
                    new Genre().workWithField(action, name);
                case BOOK:
                    new Book().workWithField(action, name);
            }
        } catch (IllegalArgumentException|ObjectDoesNorExist|ObjectAlreadyExistException e) {
            System.out.println("If you want to exit from program enter exit");
            if (!READER.readLine().replaceAll(" ", "").equalsIgnoreCase("exit")) start();
            System.out.println("Good bye! :(");
        }
    }
}
