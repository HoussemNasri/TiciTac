package com.example.tictactoe.board;

import com.example.tictactoe.player.IPlayer;

public class BestMoveStrategy implements GameStrategy {
    public BestMoveStrategy() {

    }

    @Override
    public int[] move(Character[][] board, IPlayer player) {
        return new int[]{1, 0};
    }
}
