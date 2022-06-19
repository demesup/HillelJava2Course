package com.hillel.homework.hw13.Objects;

import com.hillel.homework.hw13.FieldProcessing;
import com.hillel.homework.hw13.enums.AvailableActions;
import com.hillel.homework.hw13.exceptions.ObjectAlreadyExistException;
import com.hillel.homework.hw13.exceptions.ObjectDoesNorExist;

import java.io.IOException;
import java.util.LinkedList;

public class Author extends LibraryObjects {
    private String firstname;
    private LinkedList<Book> books = new LinkedList<>();

    public Author() {
    }

    public Author(String surname, String firstname) {
        super(surname);
        this.firstname = firstname;
    }

    @Override
    public void workWithField(AvailableActions action, String surname) throws ObjectAlreadyExistException, IOException, ObjectDoesNorExist {
        int index = FieldProcessing.findObject(authors, surname);

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
                if (surname != null) {
                    index = FieldProcessing.findObject(authors, surname);
                    authors.remove(index);
                } else System.out.println("Empty authors list");
                break;
            case PRINT:
                if (authors.size() < 1) System.out.println("Empty authors list");
                System.out.println(action);

        }
        System.out.println("Stay in working with authors field? Yes / any key");
        if (READER.readLine().replaceAll(" ", "").equalsIgnoreCase("yes")) {
            action = getAction();
            String name = null;
            if (!action.equals(AvailableActions.PRINT)) {
                System.out.println("Enter name: ");
                name = READER.readLine();
            }
            workWithField(action, name);
        }
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
