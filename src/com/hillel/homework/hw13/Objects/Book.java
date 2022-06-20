package com.hillel.homework.hw13.Objects;

import com.hillel.homework.hw13.enums.AvailableActions;
import com.hillel.homework.hw13.exceptions.ObjectAlreadyExistException;
import com.hillel.homework.hw13.exceptions.ObjectDoesNorExist;

import java.io.IOException;

import static com.hillel.classwork.lesson10.ErrorHanding.readNumber;
import static com.hillel.homework.hw13.ExtraMethods.findObject;
import static com.hillel.homework.hw13.ExtraMethods.getAction;

public class Book extends LibraryObjects {
    private Author author;
    private String description;
    private int year;
    private Genre genre;

    public Book() {
    }

    public Book(String name, String description, int year, Genre genre, Author author) {
        super(name);
        this.description = description;
        this.year = year;
        this.genre = genre;
        this.author = author;
    }

    @Override
    public String toString() {
        return "\nTitle='" + name + '\'' +
                ", description='" + description + '\'' +
                ", year=" + year +
                ", genre=" + genre;
    }

    @Override
    public void workWithField(AvailableActions action) throws ObjectAlreadyExistException, IOException, ObjectDoesNorExist {
        try {
            switch (action) {
                case ADD:
                    add();
                    break;
                case REMOVE:
                    remove();
                    break;
                case PRINT:
                    print(books);
            }
        } catch (ObjectAlreadyExistException | IOException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("You are in book field");
            workWithField(getAction());
        }
    }

    @Override
    public void add() throws ObjectAlreadyExistException, IOException, ObjectDoesNorExist {
        System.out.println("Enter book title");
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

        int genreIndex = -1;

        System.out.println("Genres: ");
        if (genres.size() > 0) {
            for (int i = 0; i < genres.size(); i++) {
                System.out.println(i + " " + genres.get(i));
            }
            System.out.println("\nEnter number of genre or -1 to create new");
            genreIndex = readNumber();
        } else {
            System.out.println("Genre list is empty. Adding new");
            new Genre().add();
        }
        if (genreIndex == -1) {
            new Genre().add();
            genreIndex = findObject(authors, authors.get(authors.size() - 1).name);
        }
        Genre genre = genres.get(genreIndex);

        int authorIndex = -1;
            System.out.println("Authors: ");
            if (authors.size() > 0) {
                for (int i = 0; i < authors.size(); i++) {
                    System.out.println(i + " " + authors.get(i));
                }
                System.out.println("\nEnter number of author or -1 to create new");
                authorIndex = readNumber();
            } else {
                System.out.println("Author list is empty. Adding new.");
                new Author().add();
            }

        if (authorIndex == -1) {
            new Author().add();
            authorIndex = findObject(authors, authors.get(authors.size() - 1).name);
        }
        Author author = authors.get(authorIndex);

        Book book = new Book(title, description, year, genre, author);
        authors.get(authorIndex).addBook(book);
        books.add(book);
    }

    @Override
    public void remove() throws IOException {
        if (books.size() > 0) {
            String title = READER.readLine();
            int index = findObject(books, title);
            books.remove(index);
            System.out.println("Book is removed");
        } else System.out.println("Empty book list");
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}