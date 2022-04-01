package com.hillel.homework;

public class PersonMain {
    public static void main(String[] args) {
        Person[] people = new Person[5];

        /*Тут используються разные конструкторы
         Person[] people = new Person[9];
         people[5] = new Person("Никита");
         people[6] = new Person("Назар", 234567);
         people[7] = new Person(987654, "Иванов");
         people[8] = new Person("Саша", "Прохоров");*/

        people[0] = new Person(123456);
        people[1] = new Person("Петя", "Петров", 654321);
        people[2] = new Person(123456, "Коля", "Петров");
        people[3] = new Person("Вася", 123456, "Васильев");
        people[4] = people[1];

        System.out.println("Users:");
        for (Person person : people) {
            System.out.println(person);
        }

        System.out.println("Сравнение 3 и 5 пользователей:");
        if (people[2].equals(people[4])) {
            System.out.println(people[2] + " совпадает с " + people[4]);
        } else {
            System.out.println(people[2] + " не совпадает с " + people[4]);
        }


        /*Дальше я просто экспериментировала**/

        System.out.println("Совпадают:");
        int count = 0;
        for (int i = 0; i < people.length; i++) {
            for (int j = 0; j < people.length; j++) {
                if (i < j && people[i].equals(people[j])) {
                    System.out.printf(" %d пользователь совпадает с %d пользователем \n", i+1,j+1);
                    count++;
                }
            }
        }
        System.out.println("Количество совпадений: " + count);

        System.out.println("Не совпадают:");
        int number = 0;
        for (int i = 0; i < people.length; i++) {
            for (int j = 0; j < people.length; j++) {
                if (i<j  && people[i].notEquals(people[j])) {
                    System.out.printf(" %d пользователь не совпадает с %d пользователем \n", i+1,j+1);
                    number++;
                }
            }
        }
        System.out.println(" Количество несовпадений: " + number);
    }
}
