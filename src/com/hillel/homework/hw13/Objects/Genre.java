package com.hillel.homework.hw13.Objects;

import com.hillel.homework.hw13.enums.AvailableActions;
import com.hillel.homework.hw13.exceptions.ObjectAlreadyExistException;
import com.hillel.homework.hw13.exceptions.ObjectDoesNorExist;

import java.io.IOException;

import static com.hillel.homework.hw13.ExtraMethods.*;

public class Genre extends LibraryObjects {
    public Genre() {
    }

    private String description;

    public Genre(String name, String description) {
        super(name);
        this.description = description;
    }

    @Override
    public String toString() {
        return "{GenreName='" + name + '\'' +
                ", description='" + description + "'}";
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
                    print(genres);
            }
        } catch (ObjectAlreadyExistException | IOException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("You are in genre field");
            workWithField(getAction());
        }
    }

    @Override
    public void add() throws ObjectAlreadyExistException, IOException {
        System.out.println("Enter genre name:");
        String name = READER.readLine();
        if (checkIfHave(genres, name)) {
            throw new ObjectAlreadyExistException("Genre already exist");
        }
        System.out.println("Enter genre description in 1 line");
        String description = READER.readLine();
        genres.add(new Genre(name, description));
    }

    @Override
    public void remove() throws IOException {
        if (genres.size() > 0) {
            System.out.println("Enter genre name:");
            name = READER.readLine();
            int index = findObject(genres, name);
            if (index > -1) {
                genres.remove(index);
                System.out.println("Genre is removed");
            } else System.out.println("No genre with name " + name);

        } else System.out.println("Empty genre list");
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
