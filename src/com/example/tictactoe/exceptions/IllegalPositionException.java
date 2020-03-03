package com.example.tictactoe.exceptions;

public class IllegalPositionException extends Exception {
    public IllegalPositionException(){
        super("The Position you picked is either already picked or is outside the boundaries");
    }
}
