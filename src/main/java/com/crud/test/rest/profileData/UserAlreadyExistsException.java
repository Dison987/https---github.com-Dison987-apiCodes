package com.crud.test.rest.profileData;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException(){

    }

    public UserAlreadyExistsException(String msg){
        super(msg);
    }
}