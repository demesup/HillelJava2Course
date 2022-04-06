package com.hillel.homework.hw4.account;

import com.hillel.classwork.lesson4.Animal;

public class Person {
    String name;

    public class Account {
        private String password;

        Account(String password) {
            this.password = password;
        }

        public void displayAccount(){
            System.out.println(name);
        }


        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
