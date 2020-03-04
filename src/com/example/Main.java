package com.example;

import com.example.tictactoe.board.Board;
import com.example.tictactoe.board.GameType;
import com.example.tictactoe.exceptions.IllegalPositionException;
import com.example.tictactoe.player.Computer;
import com.example.tictactoe.player.Human;
import com.example.tictactoe.player.IPlayer;

public class Main {

    public static void main(String[] args) throws IllegalPositionException {
        GameType playAgainstAI = GameType.Human_AI;

        IPlayer houssem = new Human("Houssem", '0');
        IPlayer mypc = new Computer("PX7004", 'X');
        Board board = new Board(houssem, mypc);
        board.startGame(GameType.HUMAN_HUMAN);
    }
}
