package com.hillel.homework.hw13.Objects;

import java.util.LinkedList;

public class Author extends LibraryObjects {
    private String firstname;
    private LinkedList<Book> books;

    public Author(String surname, String firstname, LinkedList<Book> books) {
        super(surname);
        this.firstname = firstname;
        this.books = books;
    }

    public Author(String name, String firstname) {
        super(name);
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        return "\nSurname='" + name + '\'' +
                ", firstname='" + firstname + '\'' +
                ", books=" + books;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public LinkedList<Book> getBooks() {
        return books;
    }

    public void setBooks(LinkedList<Book> books) {
        this.books = books;
    }
}
