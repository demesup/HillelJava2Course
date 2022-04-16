package com.hillel.classwork.lesson6.chess;

public abstract class ChessItem implements Drawable{

    private int x;
    private int y;
    private final int value;

    public ChessItem(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value =value;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getValue() {
        return value;
    }

    public void move(int x, int y){
        this.x = x;
        this.y = y;
    }

    public abstract void draw();
}
