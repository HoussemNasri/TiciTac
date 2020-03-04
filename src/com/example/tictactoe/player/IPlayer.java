package com.example.tictactoe.player;

import com.example.tictactoe.board.IBoard;
import com.example.tictactoe.exceptions.IllegalPositionException;

public interface IPlayer {
    PlayerStatistics statistics = new PlayerStatistics();

    String getPlayerName();

    Character getPlayerSymbol();

    PlayerStatistics getStatistics();

    void move() throws IllegalPositionException;

    void linkToBoard(IBoard board);

    default void win() {
        getStatistics().playerWon();
    }

    default void lose() {
        getStatistics().playerLost();
    }

    default void tie() {
        getStatistics().playerTie();
        ;
    }

}
