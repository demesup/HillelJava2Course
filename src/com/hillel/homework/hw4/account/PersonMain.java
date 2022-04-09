package com.hillel.homework.hw4.account;

import java.util.Scanner;

public class PersonMain {
    public static void main(String[] args) {
        Person person = new Person("Nikolai");
        Person.Account account = person.new Account("2345678");
        account.displayAccount();


        Person person1 = new Person();
        Person.Account account1 = person1.new Account("Nikolaichick525", "12345");

        boolean loop = true;
        while (loop) {
            System.out.println("Enter password for account1");
            Scanner scanner = new Scanner(System.in);
            String pass = scanner.nextLine();
            if (account1.authorisation(pass)) {
                account1.displayAccount();
                loop = false;
            } else {
                System.out.println("Wrong password, try again");
            }
        }
    }
}
