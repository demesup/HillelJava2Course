package com.hillel.homework.hw13.Objects;

public class Genre extends LibraryObjects{
    private String description;

    public Genre(String name, String description) {
        super(name);
        this.description = description;
    }

    @Override
    public String toString() {
        return "\nGenreName='" + name + '\'' +
                ", \ndescription='" + description + '\'';
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
