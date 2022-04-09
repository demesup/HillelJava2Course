package com.hillel.homework.hw4.transport;

public class TransportMain {
    public static void main(String[] args) {
        Train train = new Train(69, 140, "2022/10/05 23:30", "2022/11/05 10:30",
                "Kiev", "Odessa", 0, true, true, 15);
        train.moving();
        train.accelerate();
        train.hum();
        train.rails();
        train.slowingDown();
        train.stopping();
        System.out.println();

        //анн 22
        Airplane airplane = new Airplane(50, 650, 800, "2022/10/05 23:30", "2022/11/05 01:00",
                "Kiev", "Odessa", 0, true, true);

        airplane.moving();
        airplane.accelerate();
        airplane.takeOff();
        airplane.fly();
        airplane.landing();
        airplane.slowingDown();
        airplane.stopping();
        System.out.println();

        System.out.println(train);
        System.out.println(airplane);
    }
}
