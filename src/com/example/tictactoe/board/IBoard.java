package com.example.tictactoe.board;

import com.example.tictactoe.player.IPlayer;

public interface IBoard {
    void start();
    void stop();

    IPlayer getPlayer1();
    IPlayer getPlayer2();
    BoardStateEvaluator getBoardState();
    IPlayer playerTurn();

}
