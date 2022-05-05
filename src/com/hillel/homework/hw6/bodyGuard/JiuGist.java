package com.hillel.homework.hw6.bodyGuard;

public class JiuGist extends BodyGuard implements PainHoldable, Capturable, Throwable, Kickable, Punchable {

    public JiuGist(boolean gun) {
        super(gun);
    }

    @Override
    public String toString() {
        return "JiuGist{}";
    }

    @Override
    public void capture() {
        System.out.println("JiuGist is capturing the opponent...");
    }

    @Override
    public void kick() {
        System.out.println("JiuGist is kicking the opponent...");
    }

    @Override
    public void painHold() {
        System.out.println("JiuGist is making a pain hold to the opponent...");
    }

    @Override
    public void punch() {
        System.out.println("JiuGist is punching the opponent...");
    }

    @Override
    public void throwMen() {
        System.out.println("JiuGist is throwing the opponent...");
    }
}
