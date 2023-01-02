package com.crud.test.rest;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException(){

    }

    public UserAlreadyExistsException(String msg){
        super(msg);
    }
}