package com.example.tictactoe.board;

import com.example.tictactoe.player.IPlayer;

import java.util.Arrays;

public class BoardStateEvaluator {
    private IPlayer player1;
    private IPlayer player2;
    private int boardSize = 0;
    private Character[][] symbols;

    public BoardStateEvaluator(Character[][] symbols, IPlayer player1, IPlayer player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.symbols = symbols;
        this.boardSize = symbols.length;
    }

    public boolean validateBoardSymbols() {
        int n = symbols.length;
        Character[] validChars = {player1.getPlayerSymbol(), player2.getPlayerSymbol(), ' '};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Character _Char = symbols[i][j];
                if (!Arrays.stream(validChars).anyMatch(c -> c == _Char)) {
                    return false;
                }
            }
        }
        return true;
    }

    public IPlayer checkWinner() {
        Character playe1Symbol = player1.getPlayerSymbol();
        Character player2Symbol = player2.getPlayerSymbol();

        int size = symbols.length;
        Character[] flatMatrix = new Character[size * size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                flatMatrix[j + (size * i)] = symbols[i][j];
            }
        }
        Integer[][] winningCombos = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8},
                {0, 3, 6},
                {1, 4, 7},
                {2, 5, 8},
                {0, 4, 8},
                {2, 4, 6}
        };
        for (Integer[] i : winningCombos) {
            if (flatMatrix[i[0]] == playe1Symbol && flatMatrix[i[1]] == playe1Symbol && flatMatrix[i[2]] == playe1Symbol) {
                return player1;
            }
            if (flatMatrix[i[0]] == playe1Symbol && flatMatrix[i[1]] == playe1Symbol && flatMatrix[i[2]] == player2Symbol)
                return player2;
        }
        return null;
    }


    public boolean player1Win() {
        return checkWinner().equals(player1);
    }


    public boolean player2Win() {
        return checkWinner().equals(player2);
    }

    public boolean isBoardEmpty() {

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (!(symbols[i][j] == ' ')) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++)
                if (symbols[i][j] == ' ')
                    return false;
        }
        return true;
    }

    public boolean gameFinished() {
        return checkWinner() != null || checkForTie();
    }

    public boolean validatePlayerInput(String input) {


        if (input.length() != 2 || !Character.isDigit(input.charAt(0)) || !Character.isDigit(input.charAt(1)))
            return false;

        return true;
    }

    public String prettierInput(String input) {
        return input.trim().replaceAll(" ", "");
    }


    public boolean checkForTie() {
        return isBoardFull() && checkWinner() == null;
    }
}
