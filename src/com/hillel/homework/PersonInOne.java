package com.hillel.homework;

import com.hillel.classwork.lesson3.bird.Bird;

import java.util.Objects;

public class PersonInOne {
    private String firstName;
    private String lastName;
    private int password;

    public PersonInOne() {
        System.out.println("Creating...");
    }

    public PersonInOne(String firstName) {
        this.firstName = firstName;
        this.lastName = "Unknown";
        this.password = 0;

    }

    public PersonInOne(int password) {
        this.firstName = "Unknown";
        this.lastName = "Unknown";
        this.password = password;
    }

    public PersonInOne(String firstName, int password) {
        this.firstName = firstName;
        this.lastName = "Unknown";
        this.password = password;
    }

    public PersonInOne(int password, String lastName) {
        this.firstName = "Unknown";
        this.lastName = lastName;
        this.password = password;

    }

    public PersonInOne(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = 0;
    }

    public PersonInOne(String firstName, String lastName, int password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public PersonInOne(String firstName, int password, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public PersonInOne(int password, String firstName, String lastName) {
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
        PersonInOne person = (PersonInOne) o;
        return password == person.password && Objects.equals(firstName, person.firstName)
                && Objects.equals(lastName, person.lastName);
    }

    public static void main(String[] args) {
        PersonInOne[] people = new PersonInOne[5];

        /*Тут используються разные конструкторы
         PersonInOne[] people = new PersonInOne[9];
         people[5] = new PersonInOne("Никита");
         people[6] = new PersonInOne("Назар", 234567);
         people[7] = new PersonInOne(987654, "Иванов");
         people[8] = new PersonInOne("Саша", "Прохоров");*/

        people[0] = new PersonInOne(123456);
        people[1] = new PersonInOne("Петя", "Петров", 654321);
        people[2] = new PersonInOne(123456, "Коля", "Петров");
        people[3] = new PersonInOne("Вася", 123456, "Васильев");
        people[4] = people[1];

        System.out.println("Users:");
        for (PersonInOne person : people) {
            System.out.println(person);
        }

        System.out.println("Сравнение 3 и 5 пользователей:");
        if (people[2].equals(people[4])) {
            System.out.println(people[2] + " совпадает с " + people[4]);
        } else {
            System.out.println(people[2] + " не совпадает с " + people[4]);
        }

        /*Дальше я просто экспериментировала**/
        System.out.println("\nНачало экспериментов");
        Bird bird = new Bird("red");
        System.out.println(bird.equals(people[1]));
        System.out.println(!people[1].equals(bird));

        System.out.println("Совпадают:");
        int count = 0;
        for (int i = 0; i < people.length; i++) {
            for (int j = 0; j < people.length; j++) {
                if (i < j && people[i].equals(people[j])) {
                    System.out.printf(" %d пользователь совпадает с %d пользователем \n", i + 1, j + 1);
                    count++;
                }
            }
        }
        System.out.println("Количество совпадений: " + count);
        System.out.println("Не совпадают:");
        int number = 0;
        for (int i = 0; i < people.length; i++) {
            for (int j = 0; j < people.length; j++) {
                if (i < j && !people[i].equals(people[j])) {
                    System.out.printf(" %d пользователь не совпадает с %d пользователем \n", i + 1, j + 1);
                    number++;
                }
            }
        }
        System.out.println(" Количество несовпадений: " + number);
    }
}