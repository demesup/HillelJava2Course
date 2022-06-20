package com.hillel.homework.hw13.Objects;

import com.hillel.homework.hw13.ExtraMethods;
import com.hillel.homework.hw13.FieldProcessing;
import com.hillel.homework.hw13.enums.AvailableActions;
import com.hillel.homework.hw13.exceptions.ObjectAlreadyExistException;
import com.hillel.homework.hw13.exceptions.ObjectDoesNorExist;

import java.io.IOException;
import java.util.LinkedList;

import static com.hillel.homework.hw13.ExtraMethods.findObject;
import static com.hillel.homework.hw13.ExtraMethods.getAction;

public class Author extends LibraryObjects {
    private String firstname;
    private LinkedList<Book> authorsBooks = new LinkedList<>();

    public Author() {
    }

    public Author(String surname, String firstname) {
        super(surname);
        this.firstname = firstname;
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
                    print(authors);
            }
        } catch (ObjectAlreadyExistException | IOException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("You are in author field");
            workWithField(getAction());
        }
    }

    public void remove() throws IOException, ObjectDoesNorExist {
        if (authors.size() > 0) {
            System.out.println("Enter surname:");
            String surname = READER.readLine();
            int index = findObject(authors, surname);
            if (index == -1) throw new ObjectDoesNorExist("No author with this name");
            authors.remove(index);
            System.out.println("Author is removed");
        } else System.out.println("Empty authors list");
    }
    public void add() throws ObjectAlreadyExistException, IOException {
        System.out.println("Enter surname:");
        String surname = READER.readLine();
        int index = findObject(authors,surname);
        if (index != -1) {
            throw new ObjectAlreadyExistException("Author already exist");
        }
        System.out.println("Enter firstname");
        String firstname = READER.readLine();
        Author author = new Author(surname, firstname);
        authors.add(author);
    }

    public void addBook(Book book) {
        authorsBooks.add(book);
    }

    @Override
    public String toString() {
        return "\nSurname='" + name + '\'' +
                ", firstname='" + firstname + '\'' +
                ", books=" + authorsBooks;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public LinkedList<Book> getAuthorsBooks() {
        return authorsBooks;
    }

    public void setAuthorsBooks(LinkedList<Book> authorsBooks) {
        this.authorsBooks = authorsBooks;
    }
}
