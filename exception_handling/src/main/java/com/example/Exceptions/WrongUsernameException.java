package com.example.Exceptions;

public class WrongUsernameException extends Exception{

    public WrongUsernameException(String message) {
        super(message);
    }

}
