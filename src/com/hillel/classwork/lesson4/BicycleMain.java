package com.hillel.classwork.lesson4;

public class BicycleMain {

    public static void main(String[] args) {

        Bicycle bicycle = new Bicycle(10, "Ukraine");

        System.out.println(bicycle);

        bicycle.ride();

        Bicycle.SteeringWheel steeringWheel = bicycle.new SteeringWheel();
        steeringWheel.left();
        steeringWheel.right();

        Bicycle.Seat seat = bicycle.new Seat();
        seat.up();
        seat.down();
    }
}
