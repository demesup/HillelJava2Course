package com.hillel.classwork.lesson6.chess;

public class Queen extends ChessItem{
    public Queen(int x, int y) {
        super(x, y, 90);
    }

    @Override
    public void draw() {
        System.out.println("Draw queen");
    }
}
