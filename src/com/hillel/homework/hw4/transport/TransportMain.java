package com.hillel.homework.hw4.transport;

public class TransportMain {
    public static void main(String[] args) {
        Train train = new Train(69, 140, "2022/10/05 23:30", "2022/11/05 10:30",
                "Kiev", "Odessa", 0, true, true, 15);
        train.way();
        train.setOrigin("Kharkov");

        System.out.println();

        //анн 22
        Airplane airplane = new Airplane(50, 650, 800, "2022/10/05 23:30", "2022/11/05 01:00",
                "Kiev", "Odessa", 0, true, true);
        airplane.way();

        System.out.println();

        System.out.println(train);
        System.out.println(airplane);
    }
}
