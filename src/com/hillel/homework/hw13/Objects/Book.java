package com.hillel.homework.hw13.Objects;

import java.time.LocalDateTime;

public class Book {
    private String title;
    private String description;
    private int year;
    private Genre genre;

    public Book(String title, String description, int year, Genre genre) {
        this.title = title;
        this.description = description;
        this.year = year;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "\nTitle='" + title + '\'' +
                ", description='" + description + '\'' +
                ", year=" + year +
                ", genre=" + genre ;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
