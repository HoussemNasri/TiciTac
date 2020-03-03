package com.example.tictactoe.player;

public class Computer implements IPlayer {
    private String name =  "computer";
    private Character symbol = '0';
    private PlayerStatistics statistics;

    public Computer(String name , Character symbol){
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
