package com.hillel.classwork.lesson6.chess;

public class Pawn extends ChessItem{

    public Pawn(int x, int y) {
        super(x, y, 10);
    }

    @Override
    public void draw() {
        System.out.println("Draw pawn");
    }
}
