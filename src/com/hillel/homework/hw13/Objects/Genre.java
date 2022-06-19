package com.hillel.homework.hw13.Objects;

import com.hillel.homework.hw13.FieldProcessing;
import com.hillel.homework.hw13.enums.AvailableActions;
import com.hillel.homework.hw13.exceptions.ObjectAlreadyExistException;
import com.hillel.homework.hw13.exceptions.ObjectDoesNorExist;

import java.io.IOException;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void workWithField(AvailableActions action, String name) throws ObjectAlreadyExistException, IOException, ObjectDoesNorExist {
        {
            try {
                switch (action) {
                    case ADD:
                        if (FieldProcessing.checkIfHave(genres, name)) {
                            throw new ObjectAlreadyExistException("Genre already exist");
                        }
                        System.out.println("Enter genre description in 1 line");
                        String description = READER.readLine();
                        genres.add(new Genre(name, description));
                        break;
                    case REMOVE:
                        if (name == null) name = READER.readLine();
                        if (genres.size() > 0) {
                            int index = FieldProcessing.findObject(genres, name);
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
            } catch (ObjectAlreadyExistException | IOException e) {
                System.out.println(e.getMessage());
            } finally {
                action = getAction();
                String name1 = null;
                if (!action.equals(AvailableActions.PRINT)) {
                    System.out.println("Enter name: ");
                    name1 = READER.readLine();
                }
                workWithField(action, name1);
            }
        }
    }
}
