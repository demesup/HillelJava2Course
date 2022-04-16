package com.hillel.classwork.lesson6.chess;

import java.util.ArrayList;
import java.util.List;

public class Chess {


    public static void main(String[] args) {
        List<Drawable> chess = new ArrayList<>();

        chess.add(new Pawn(1,1));
        chess.add(new Pawn(2,1));
        chess.add(new Pawn(3,1));
        chess.add(new Pawn(4,1));
        chess.add(new Queen(1,2));
        chess.add(new King(1,3));

        ChessBoard chessBoard = new ChessBoard();

        for (Drawable item : chess) {
            item.draw();
        }
    }
}
