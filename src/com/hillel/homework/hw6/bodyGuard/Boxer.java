package com.hillel.homework.hw6.bodyGuard;

public class Boxer extends BodyGuard implements Punchable {
    public Boxer(boolean gun) {
        super(gun);
    }

    @Override
    public String toString() {
        return "Boxer{}";
    }


    @Override
    public void punch() {
        System.out.println("Boxer is hitting the opponent..");

    }
}
