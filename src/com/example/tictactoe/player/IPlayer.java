package com.example.tictactoe.player;

public interface IPlayer {
    PlayerStatistics statistics = new PlayerStatistics();

    String getPlayerName();

    Character getPlayerSymbol();

    PlayerStatistics getStatistics();

    default void win(){
        getStatistics().playerWon();
    }
    default void lose(){
        getStatistics().playerLost();
    }
    default void tie(){
        getStatistics().playerTie();;
    }

}
