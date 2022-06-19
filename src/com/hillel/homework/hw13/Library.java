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
// TODO: 19.06.2022  //  Добавить книгу, удалить книгу по названию, вывести все книги
//  При добавлении книги у пользователя должна быть функция выбора жанра и автора.
//  Например можно распечатать в консоль все жанры по порядковым номерам,
//  и пользователь выбирает номер необходимого жанра, так же с автором.
                AvailableActions action = getAction();
                String name = null;
                if (!action.equals(AvailableActions.PRINT)) {
                    System.out.println("Enter name: ");
                    name = READER.readLine();
                }
                switch (field) {
                    case BOOK:
                        workWithBook(action, name);
                        break;
                    case GENRE:
                        workWithGenre(action, name);
                        break;
                    case AUTHOR:
                        workWithAuthor(action, name);
                }
            }
        } catch (ObjectAlreadyExistException |
                 ObjectDoesNorExist e) {
            System.out.println(e.getMessage());
            start();
        } catch (IllegalArgumentException e) {
            System.out.println("To confirm exit from program enter ex");
            if (!READER.readLine().replaceAll(" ", "").toLowerCase(Locale.ROOT).equals("ex")) {
                start();
            } else System.out.println("Good bye :)");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private static AvailableActions getAction() throws IOException {
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

    private static void workWithAuthor(AvailableActions action, String surname) throws IOException, ObjectAlreadyExistException {
        int index = findObject(authors, surname);

        switch (action) {
            case ADD:
                if (index != -1) {
                    throw new ObjectAlreadyExistException("Author already exist");
                }
                System.out.println("Enter firstname");
                String firstname = READER.readLine();
                System.out.println("Do you want to enter his books? Enter yes/ press any key");
                Author author = new Author(surname, firstname);
                authors.add(author);
                break;
            case REMOVE:
                if (genres.size() > 0) {
                    genres.remove(index);
                } else System.out.println("Empty list");
                break;
            case PRINT:
                if (genres.size() < 1) System.out.println("Empty list");
                System.out.println(genres);

        }
        System.out.println("Stay in working with authors field? Yes / any key");
        if (READER.readLine().replaceAll(" ", "").equalsIgnoreCase("yes")) {
            action = getAction();
            String name = null;
            if (!action.equals(AvailableActions.PRINT)) {
                System.out.println("Enter name: ");
                name = READER.readLine();
            }
            workWithAuthor(action, name);
        }
    }

    private static Book createBook(String title) throws IOException {
        System.out.println("Enter book description in 1 line");
        String description = READER.readLine();
        System.out.println("Enter year in format 0000");
        String yearSTr = READER.readLine();
        while (yearSTr.length() != 4) {
            System.out.println("Wrong year, try again");
            yearSTr = READER.readLine();
        }
        int year = Integer.parseInt(yearSTr);

        int index = -1;
        while (index == -1) {
            System.out.println("Genres: ");
            if (genres.size() > 0) {
                for (int i = 0; i < genres.size(); i++) {
                    System.out.println(i + " " + genres.get(i));
                }
                System.out.println("\nEnter number of genre or -1 to create new");
                index = readNumber();
            } else {
                System.out.println("Genre list is empty. Adding new. Enter name");
                String name = READER.readLine().replaceAll(" ", "");
                workWithGenre(AvailableActions.ADD, name);
            }
        }
        Genre genre = genres.get(index);
        return new Book(title, description, year, genre);
    }

    private static int readNumber() throws IOException {
        return Integer.parseInt(READER.readLine());
    }

    private static void workWithGenre(AvailableActions action, String name) throws IOException {
        try {
            switch (action) {
                case ADD:
                    if (checkIfHave(genres, name)) {
                        throw new ObjectAlreadyExistException("Genre already exist");
                    }
                    System.out.println("Enter genre description in 1 line");
                    String description = READER.readLine();
                    genres.add(new Genre(name, description));
                    break;
                case REMOVE:
                    if (genres.size() > 0) {
                        int index = findObject(genres, name);
                        if (index > -1) {
                            genres.remove(index);
                            System.out.println("Genre is removed");
                        } else System.out.println("No genre with name " + name);

                    } else System.out.println("Empty genre list");
                    break;
                case PRINT:
                    if (genres.size() < 1) {
                        System.out.println("Empty genre list");
                        break;
                    }
                    System.out.println(genres);
            }
        } catch (ObjectAlreadyExistException e) {
            System.out.println(e.getMessage());
        } finally {
            action = getAction();
            String name1 = null;
            if (!action.equals(AvailableActions.PRINT)) {
                System.out.println("Enter name: ");
                name1 = READER.readLine();
            }
            workWithGenre(action, name1);
        }
    }


    private static void workWithBook(AvailableActions action, String title) throws ObjectAlreadyExistException, IOException, ObjectDoesNorExist {
        {
            switch (action) {
                case ADD:
                    if (checkIfHave(books, title)) {
                        throw new ObjectAlreadyExistException("Book already exist");
                    }
                    books.add(createBook(title));
                    System.out.println("Book is added");
                    break;
                case REMOVE:
                    if (books.size() > 0) {
                        int index = findObject(books, title);
                        if (index > -1) {
                            books.remove(index);
                            System.out.println("Book is removed");
                        } else System.out.println("No book with name " + title);

                    } else System.out.println("Empty book list");
                    break;
                case PRINT:
                    if (books.size() < 1) {
                        System.out.println("Empty books list");
                        break;
                    }
                    System.out.println(books);
            }
            System.out.println("Stay in working with books field? Yes / any key");
            if (READER.readLine().replaceAll(" ", "").equalsIgnoreCase("yes")) {
                action = getAction();
                String name1 = null;
                if (!action.equals(AvailableActions.PRINT)) {
                    System.out.println("Enter name: ");
                    name1 = READER.readLine();
                }
                workWithBook(action, name1);
            }
        }
    }

    private static int findObject(List<? extends LibraryObjects> objects, String name) {
        for (LibraryObjects object : objects) {
            if (object.getName().equalsIgnoreCase(name)) return objects.indexOf(object);
        }
        return -1;
    }

    private static boolean checkIfHave(List<? extends LibraryObjects> objects, String name) {
        if (objects.size() == 0) return false;
        for (LibraryObjects object : objects) {
            if (object.getName().equalsIgnoreCase(name)) return true;
        }
        return false;
    }
}
