package com.example;

import com.example.tictactoe.board.Board;
import com.example.tictactoe.board.IBoard;
import com.example.tictactoe.exceptions.IllegalPositionException;
import com.example.tictactoe.player.Human;
import com.example.tictactoe.player.IPlayer;

public class Main {

    public static void main(String[] args) throws IllegalPositionException {
        IPlayer houssem = new Human("Houssem" , '0');
        IPlayer amine = new Human("Amine" , 'X');
        Board board = new Board(houssem , amine);
        board.move(2,2);
        board.move(1,0);
        board.move(0,0);
        board.move(0,2);
        board.move(1,1);
        board.show();

    }
}
