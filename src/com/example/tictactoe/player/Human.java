package com.example.tictactoe.player;

public class Human implements IPlayer {
    private String name =  "human";
    private Character symbol = '*';
    private PlayerStatistics statistics;

    public Human(String name , Character symbol){
        this.name = name;
        this.symbol = symbol;
        this.statistics = new PlayerStatistics();
    }
    @Override
    public String getPlayerName() {
        return this.name;
    }

    @Override
    public Character getPlayerSymbol() {
        return this.symbol;
    }

    @Override
    public PlayerStatistics getStatistics() {
        return this.statistics;
    }

}
