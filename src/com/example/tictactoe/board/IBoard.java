package com.example.tictactoe.board;

import com.example.tictactoe.player.IPlayer;

public interface IBoard {
    void show();

    IPlayer getPlayer1();

    IPlayer getPlayer2();

    BoardStateEvaluator getBoarderEvaluator();

    void playerTurn();

}
