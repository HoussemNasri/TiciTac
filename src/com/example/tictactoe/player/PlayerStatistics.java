package com.example.tictactoe.player;

public class PlayerStatistics {
    private int wins;
    private int lost;
    private int tie;

    PlayerStatistics(){
        wins = 0;
        lost = 0;
        tie  = 0;
    }

    public void playerWon(){
        wins++;
    }

    public void playerLost(){
        lost++;
    }

    public void playerTie(){
        tie++;
    }

    @Override
    public String toString() {
        return "PlayerStatistics{" +
                "wins=" + wins +
                ", lost=" + lost +
                ", tie=" + tie +
                '}';
    }
}
