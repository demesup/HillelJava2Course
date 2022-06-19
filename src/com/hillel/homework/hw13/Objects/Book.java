package com.hillel.homework.hw13.Objects;

public class Book extends LibraryObjects{
    private Author author;
    private String description;
    private int year;
    private Genre genre;

    public Book(String title, String description, int year, Genre genre, Author author) {
        super(title);
        this.description = description;
        this.year = year;
        this.genre = genre;
        this.author = author;
    }

    @Override
    public String toString() {
        return "\nTitle='" + name + '\'' +
                ", description='" + description + '\'' +
                ", year=" + year +
                ", genre=" + genre ;
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
