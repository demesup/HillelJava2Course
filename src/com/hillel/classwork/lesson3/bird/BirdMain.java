package com.hillel.classwork.lesson3.bird;

public class BirdMain {
    public static void main(String[] args) {

        Bird bird = new Bird("red");
        System.out.println(bird);
        bird.speak();

        Bird bird1 = new Bird("green");
        System.out.println(bird1);
        bird1.speak();

        Bird bird2 = new Bird("yellow");
        System.out.println(bird2);
        bird2.speak();

        System.out.println(Bird.COUNT);

        System.out.println(bird.getCOUNT());

        String color = bird.getColor();
        System.out.println("Color - " + color);

        bird.setColor("turquoise");
        System.out.println("color " + bird.getColor());
    }
}
