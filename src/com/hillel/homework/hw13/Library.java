package com.hillel.homework.hw13;

import com.hillel.homework.hw13.Objects.Author;
import com.hillel.homework.hw13.Objects.LibraryObjects;
import com.hillel.homework.hw13.enums.AvailableActions;
import com.hillel.homework.hw13.enums.AvailableObjects;
import com.hillel.homework.hw13.Objects.Book;
import com.hillel.homework.hw13.Objects.Genre;
import com.hillel.homework.hw13.exceptions.ObjectAlreadyExistException;
import com.hillel.homework.hw13.exceptions.ObjectDoesNorExist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class Library {
    static List<Genre> genres = new LinkedList<>();
    static List<Author> authors = new LinkedList<>();
    static List<Book> books = new LinkedList<>();
    static BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to library");
        start();
    }

    private static void start() throws IOException {
        try {
            while (true) {
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
// TODO: 18.06.2022 Добавить жанр, удалить жанр, вывести все жанры
//  Добавить автора, удалить автора, вывести всех авторов
//  Добавить книгу, удалить книгу по названию, вывести все книги
//  При добавлении книги у пользователя должна быть функция выбора жанра и автора.
//  Например можно распечатать в консоль все жанры по порядковым номерам,
//  и пользователь выбирает номер необходимого жанра, так же с автором.
                System.out.println("Enter action: add, remove, print all genres");
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
                System.out.println("Enter name: ");
                switch (field) {
                    case BOOK:
                        workWithBook(action);
                        break;
                    case GENRE:
                        workWithGenre(action, READER.readLine());
                        break;
                    case AUTHOR:
                        workWithAuthor(action);
                }
            }

        } catch (IllegalArgumentException e) {
            System.out.println("To confirm exit enter ex");
            if (!READER.readLine().replaceAll(" ", "").toLowerCase(Locale.ROOT).equals("ex")) {
                start();
            } else System.out.println("Good bye :)");
        } catch (ObjectAlreadyExistException | ObjectDoesNorExist | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void workWithAuthor(AvailableActions action) {

    }

    private static void workWithGenre(AvailableActions action, String name) throws IOException, ObjectAlreadyExistException, ObjectDoesNorExist {
        switch (action) {
            case ADD:
                if (checkIfHave(genres, name)) {
                    throw new ObjectAlreadyExistException("Genre already exist");
                }
                System.out.println("Enter a description in 1 line");
                String description = READER.readLine();
                genres.add(new Genre(name, description));
                break;
            case REMOVE:
                if (genres.size() > 0) {
                    genres.remove(findObject(genres, name));
                } else System.out.println("Empty list");
                break;
            case PRINT:
                if (genres.size() < 1) System.out.println("Empty list");
                System.out.println(genres);
        }

    }

    private static int findObject(List<? extends LibraryObjects> objects, String name) throws ObjectDoesNorExist {
        for (LibraryObjects object : objects) {
            if (object.getName().equalsIgnoreCase(name)) return objects.indexOf(object);
        }
        throw new ObjectDoesNorExist("No object with name " + name);
    }

    private static boolean checkIfHave(List<? extends LibraryObjects> objects, String name) {
        if (objects.size() == 0) return false;
        for (LibraryObjects object : objects) {
            if (object.equals(name)) return true;
        }
        return false;
    }

    private static void workWithBook(AvailableActions action) {
    }
}
