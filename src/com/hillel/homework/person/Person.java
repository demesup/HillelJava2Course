package com.hillel.homework.person;

import java.util.Objects;

public class Person {

    private String firstName;
    private String lastName;
    private int password;

    public Person() {
        System.out.println("Creating...");
    }

    public Person(String firstName) {
        this.firstName = firstName;
        this.lastName = "Unknown";
        this.password = 0;

    }

    public Person(int password) {
        this.firstName = "Unknown";
        this.lastName = "Unknown";
        this.password = password;
    }

    public Person(String firstName, int password) {
        this.firstName = firstName;
        this.lastName = "Unknown";
        this.password = password;
    }

    public Person(int password, String lastName) {
        this.firstName = "Unknown";
        this.lastName = lastName;
        this.password = password;

    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = 0;
    }

    public Person(String firstName, String lastName, int password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public Person(String firstName, int password, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public Person(int password, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPassword() {
        return password;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "FirstName: '" + firstName + '\'' +
                ", lastName: '" + lastName + '\'' +
                ", password: '" + password + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return password == person.password && Objects.equals(firstName, person.firstName)
                && Objects.equals(lastName, person.lastName);
    }
}
