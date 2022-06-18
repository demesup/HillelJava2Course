package com.hillel.homework.hw13.Objects;

public class Genre {
    private String name;
    private String description;

    public Genre(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "\nGenreName='" + name + '\'' +
                ", \ndescription='" + description + '\'';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
