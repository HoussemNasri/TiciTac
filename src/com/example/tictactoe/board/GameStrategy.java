package com.example.tictactoe.board;

import com.example.tictactoe.player.IPlayer;

public interface GameStrategy {
    int[] move(Character[][] board, IPlayer player);
}
