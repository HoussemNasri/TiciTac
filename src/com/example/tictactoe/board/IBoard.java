package com.example.tictactoe.board;

import com.example.tictactoe.exceptions.IllegalPositionException;
import com.example.tictactoe.player.IPlayer;

public interface IBoard {
    void show();

    IPlayer getPlayer1();

    IPlayer getPlayer2();

    BoardStateEvaluator getBoarderEvaluator();

    void startGame(GameType gameType) throws IllegalPositionException;

    void finishGame();

    void nextTurn();

    void readInput(IPlayer player);

    Character[][] getBoardMatrix();

    void move(int i, int j) throws IllegalPositionException;

}
