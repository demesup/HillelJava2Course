package com.hillel.homework.hw13.Objects;

import com.hillel.homework.hw13.enums.AvailableActions;
import com.hillel.homework.hw13.exceptions.ObjectAlreadyExistException;
import com.hillel.homework.hw13.exceptions.ObjectDoesNorExist;

import java.io.IOException;

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
    }

    @Override
    public String toString() {
        return "\nTitle='" + name + '\'' +
                ", description='" + description + '\'' +
                ", year=" + year +
                ", genre=" + genre;
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

    @Override
    public void workWithField(AvailableActions action, String title) throws ObjectAlreadyExistException, IOException, ObjectDoesNorExist {
        // TODO: 20.06.2022 print/remove for book

        {
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
            while (genreIndex == -1) {
                System.out.println("Genres: ");
                if (genres.size() > 0) {
                    for (int i = 0; i < genres.size(); i++) {
                        System.out.println(i + " " + genres.get(i));
                    }
                    System.out.println("\nEnter number of genre or -1 to create new");
                    genreIndex = readNumber();
                } else {
                    System.out.println("Genre list is empty. Adding new. Enter name");
                    String name = READER.readLine().replaceAll(" ", "");
                    new Genre().workWithField(AvailableActions.ADD, name);
                }
            }
            Genre genre = genres.get(genreIndex);

            int authorIndex = -1;
            while (authorIndex == -1) {
                System.out.println("Authors: ");
                if (authors.size() > 0) {
                    for (int i = 0; i < authors.size(); i++) {
                        System.out.println(i + " " + authors.get(i));
                    }
                    System.out.println("\nEnter number of genre or -1 to create new");
                    authorIndex = readNumber();
                } else {
                    System.out.println("Author list is empty. Adding new. Enter name");
                    String name = READER.readLine().replaceAll(" ", "");
                    new Author().workWithField(AvailableActions.ADD, name);
                }
            }
            Author author = authors.get(authorIndex);
            books.add(new Book(title, description, year, genre, author));
        }
    }
}
