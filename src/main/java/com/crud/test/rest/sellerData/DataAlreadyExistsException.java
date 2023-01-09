package com.crud.test.rest.sellerData;

public class DataAlreadyExistsException extends RuntimeException{
    public DataAlreadyExistsException(){

    }

    public DataAlreadyExistsException(String msg){
        super(msg);
    }
}