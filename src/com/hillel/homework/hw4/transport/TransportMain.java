package com.hillel.homework.hw4.transport;

public class TransportMain {
    public static void main(String[] args) {
        Transport train = new Train(69, 140, "2022/10/05 23:30", "2022/11/05 10:30",
                "Kiev", "Odessa", 0, true, true, 15);
        Transport airplane = new Airplane(50, 800, "2022/10/05 23:30", "2022/11/05 01:00",
                "Kiev", "Odessa", 0, true, true);


        System.out.println(train);
        System.out.println(airplane);
    }
}
