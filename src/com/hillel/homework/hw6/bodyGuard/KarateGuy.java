package com.hillel.homework.hw6.bodyGuard;

public class KarateGuy extends BodyGuard implements Capturable, Kickable, PainHoldable,Throwable{

    public KarateGuy(boolean gun) {
        super(gun);
    }

    @Override
    public String toString() {
        return "KarateGuy{}";
    }

    @Override
    public void capture() {
        System.out.println("Karate guy is capturing the opponent...");
    }

    @Override
    public void kick() {
        System.out.println("Karate guy is kicking the opponent...");
    }

    @Override
    public void painHold() {
        System.out.println("Karate guy is making a pain hold to the opponent...");
    }

    @Override
    public void throwMen() {
        System.out.println("Karate guy is throwing the opponent...");
    }
}
