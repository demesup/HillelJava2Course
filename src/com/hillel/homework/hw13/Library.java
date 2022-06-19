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
        } catch (
                IllegalArgumentException e) {
            System.out.println("To confirm exit from program enter ex");
            if (!READER.readLine().replaceAll(" ", "").toLowerCase(Locale.ROOT).equals("ex")) {
                start();
            } else System.out.println("Good bye :)");
        } catch (
                IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private static AvailableActions getAction() throws IOException {
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
        return action;
    }

    private static void workWithAuthor(AvailableActions action, String surname) throws ObjectAlreadyExistException, IOException, ObjectDoesNorExist {
        switch (action) {
            case ADD:
                if (checkIfHave(authors, surname)) {
                    throw new ObjectAlreadyExistException("Author already exist");
                }
                System.out.println("Enter firstname");
                String firstname = READER.readLine();
                System.out.println("Do you want to enter his books? Enter yes/ press any key");
                Author author = new Author(surname, firstname);
                if (READER.readLine().replaceAll(" ", "").equalsIgnoreCase("yes"))
                    author.setBooks((LinkedList<Book>) enterAuthorsBooks(author));
                authors.add(author);
                break;
            case REMOVE:
                if (genres.size() > 0) {
                    genres.remove(findObject(authors, surname));
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

    private static List<Book> enterAuthorsBooks(Author author) throws IOException, RuntimeException {
        List<Book> books = new LinkedList<>();
        try {
            String choice = "yes";
            while (choice.replaceAll(" ", "").equalsIgnoreCase("yes")) {
                System.out.println("Enter title");
                String title = READER.readLine();
                System.out.println("Enter book description in 1 line");
                String description = READER.readLine();
                System.out.println("Enter year in format 0000");
                String yearSTr = READER.readLine();
                while (yearSTr.length() != 4) {
                    System.out.println("Wrong year, try again");
                    yearSTr = READER.readLine();
                }
                int year = Integer.parseInt(yearSTr);
                System.out.println(genres + "\nEnter genre");
                String genreName = READER.readLine();
                while (findObject(genres, genreName) < 0) {
                    System.out.println("There is no genre " + genreName + " in the list. You need to create it first");
                    workWithGenre(AvailableActions.ADD, genreName);
                }
                Genre genre = genres.get(findObject(genres, genreName));
                books.add(new Book(title, description, year, genre, author));
                System.out.println("Books:\n" + books);
                System.out.println("Continue entering? yes/ any key");
                choice = READER.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Continue entering? yes/ any key");
            if (READER.readLine().equalsIgnoreCase("yes")) enterAuthorsBooks(author);
        } catch (ObjectDoesNorExist | ObjectAlreadyExistException e) {
            System.out.println(e.getMessage());
        }
        return books;

    }

    private static void workWithGenre(AvailableActions action, String name) throws IOException, ObjectAlreadyExistException, ObjectDoesNorExist {
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
        System.out.println("Stay in working with genres field? Yes / any key");
        if (READER.readLine().replaceAll(" ", "").equalsIgnoreCase("yes")) {
            action = getAction();
            String name1 = null;
            if (!action.equals(AvailableActions.PRINT)) {
                System.out.println("Enter name: ");
                name1 = READER.readLine();
            }
            workWithGenre(action, name1);
        }
    }

    private static void workWithBook(AvailableActions action, String s) {
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
            if (object.getName().equals(name)) return true;
        }
        return false;
    }
}
