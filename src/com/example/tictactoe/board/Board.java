package com.example.tictactoe.board;

import com.example.tictactoe.exceptions.IllegalPositionException;
import com.example.tictactoe.player.IPlayer;

import java.util.Scanner;

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
        player1.linkToBoard(this);
        player2.linkToBoard(this);

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
        System.out.println();
    }


    @Override
    public IPlayer getPlayer1() {
        return player1;
    }

    @Override
    public IPlayer getPlayer2() {
        return player2;
    }

    @Override
    public BoardStateEvaluator getBoarderEvaluator() {
        return evaluator;
    }

    @Override
    public void startGame(GameType gameType) {
        System.out.println("------------------- Welcome to tic tac toe ----------------------");
        if(gameType == GameType.HUMAN_HUMAN){

        do {
            readInput(player1);
            if (evaluator.gameFinished())
                break;
            readInput(player2);
        } while (!evaluator.gameFinished());
        }
        else {
            System.out.println("Human Vs AI");
        }
    }

    @Override
    public void readInput(IPlayer player2) {
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            System.out.print(player2.getPlayerName() + " Turn : ");
            input = scanner.nextLine();
            input = evaluator.prettierInput(input);
        }
        while (!evaluator.validatePlayerInput(input));

        Integer[] playerInput = new Integer[2];

        playerInput[0] = Integer.parseInt(String.valueOf(input.charAt(0)));
        playerInput[1] = Integer.parseInt(String.valueOf(input.charAt(1)));

        try {
            move(playerInput[0], playerInput[1]);
        } catch (IllegalPositionException il) {
            System.out.println("FUCK OFF");
            nextTurn();
        }

    }

    @Override
    public void finishGame() {
        System.out.println("Game Finished");
    }

    @Override
    public void move(int i, int j) throws IllegalPositionException {
        if (i < 0 || i >= BOARD_SIZE || j < 0 || j >= BOARD_SIZE || gameBoard[i][j] != ' ')
            throw new IllegalPositionException();

        gameBoard[i][j] = currentPlayer.getPlayerSymbol();

        if (evaluator.checkWinner() != null)
            System.out.println(evaluator.checkWinner().getPlayerName() + " Has Won !!!");
        show();
        nextTurn();
    }

    @Override
    public void nextTurn() {
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }

    @Override
    public Character[][] getBoardMatrix() {
        return gameBoard;
    }
}
