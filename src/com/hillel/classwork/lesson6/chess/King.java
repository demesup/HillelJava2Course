package com.hillel.classwork.lesson6.chess;

public class King extends ChessItem{
    public King(int x, int y) {
        super(x, y, 100);
    }

    @Override
    public void draw() {
        System.out.println("Draw king");
    }
}
