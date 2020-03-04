package com.example.tictactoe.player;

import com.example.tictactoe.board.BestMoveStrategy;
import com.example.tictactoe.board.GameStrategy;
import com.example.tictactoe.board.IBoard;
import com.example.tictactoe.exceptions.IllegalPositionException;

public class Computer implements IPlayer {
    private String name = "computer";
    private Character symbol = '0';
    private IBoard board;
    private GameStrategy bestMoveStrategy;


    public Computer(String name, Character symbol) {
        this.name = name;
        this.symbol = symbol;
        bestMoveStrategy = new BestMoveStrategy();
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
        return statistics;
    }


    @Override
    public void move() throws IllegalPositionException {
        System.out.println(getPlayerName() + " Turn : ");
        int[] bestMove = bestMoveStrategy.move(board.getBoardMatrix(), this);
        board.move(bestMove[0], bestMove[1]);
    }

    @Override
    public void linkToBoard(IBoard board) {
        this.board = board;
    }

}
