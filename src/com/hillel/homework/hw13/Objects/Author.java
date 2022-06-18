package com.hillel.homework.hw13.Objects;

import java.util.LinkedList;

public class Author {
    private String surname;
    private String firstname;
    private LinkedList<Book> books;

    public Author(String surname, String firstname, LinkedList<Book> books) {
        this.surname = surname;
        this.firstname = firstname;
        this.books = books;
    }

    @Override
    public String toString() {
        return "\nSurname='" + surname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", books=" + books ;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
