package com.hillel.homework.hw6.bodyGuard;

public class BodyGuard {
    private boolean gun;

    public BodyGuard(boolean gun) {
        this.gun = gun;
    }

    public boolean isGun() {
        return gun;
    }

    public void setGun(boolean gun) {
        this.gun = gun;
    }

    public void protect() {
        System.out.println("Bodyguard starts protection");
        if (gun) System.out.println("Bodyguard is using his weapon");
    }

    public void success() {
        System.out.println("The defense is over, the client is safe");
    }
}
