package com.example.tictactoe.board;

import com.example.tictactoe.exceptions.IllegalPositionException;
import com.example.tictactoe.player.IPlayer;

public class Board implements IBoard {
    private static final int BOARD_SIZE = 3;
    private IPlayer player1;
    private IPlayer player2;
    private IPlayer currentPlayer;
    private Character[][] gameBoard;
    private BoardStateEvaluator evaluator;

    public Board(IPlayer player1, IPlayer player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        gameBoard = new Character[BOARD_SIZE][BOARD_SIZE];
        evaluator = new BoardStateEvaluator(gameBoard, player1, player2);
        for (int i = 0; i < BOARD_SIZE; i++)
            for (int j = 0; j < BOARD_SIZE; j++)
                gameBoard[i][j] = ' ';

    }

    @Override
    public void show() {
        for (int i = 0; i < 8; i++) {
            System.out.print("--");
        }
        System.out.println();
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (gameBoard[i][j] == null)
                    gameBoard[i][j] = ' ';
                System.out.printf("|%2c |", gameBoard[i][j]);
            }
            System.out.println();
        }
        for (int i = 0; i < 8; i++) {
            System.out.print("--");
        }
    }


    @Override
    public IPlayer getPlayer1() {
        return null;
    }

    @Override
    public IPlayer getPlayer2() {
        return null;
    }

    @Override
    public BoardStateEvaluator getBoarderEvaluator() {
        return evaluator;
    }

    public void move(int i, int j) throws IllegalPositionException {
        if (i < 0 || i >= BOARD_SIZE || j < 0 || j >= BOARD_SIZE || gameBoard[i][j] != ' ')
            throw new IllegalPositionException();

        gameBoard[i][j] = currentPlayer.getPlayerSymbol();

        if (evaluator.checkWinner() != null)
            System.out.println(evaluator.checkWinner().getPlayerName() + " Has Won !!!");

        playerTurn();
    }

    @Override
    public void playerTurn() {
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }
}
