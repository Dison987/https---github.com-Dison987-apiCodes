package com.crud.test.rest.profileData;

public class DataAlreadyExistsException extends RuntimeException{
    public DataAlreadyExistsException(){

    }

    public DataAlreadyExistsException(String msg){
        super(msg);
    }
}