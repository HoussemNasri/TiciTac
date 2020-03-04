package com.example.tictactoe.player;

import com.example.tictactoe.board.IBoard;

public class Human implements IPlayer {
    private String name = "human";
    private Character symbol = '*';
    private IBoard board;


    public Human(String name, Character symbol) {
        this.name = name;
        this.symbol = symbol;
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


    @Override
    public void move() {
        board.readInput(this);
    }

    @Override
    public void linkToBoard(IBoard board) {
        this.board = board;
    }

}
