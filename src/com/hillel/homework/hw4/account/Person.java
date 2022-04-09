package com.hillel.homework.hw4.account;

import java.util.Objects;

public class Person {
    private String name;

    Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public class Account {
        private String password;

        Account(String name, String password) {
            setName(name);
            this.password = password;
        }

        Account(String password) {
            this.password = password;
        }

        void displayAccount() {
            System.out.println("Имя владельца аккаунта: " + name);
        }

        public boolean authorisation(String password) {
            return password.equals(this.password);
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
