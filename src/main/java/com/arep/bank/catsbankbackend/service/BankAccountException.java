package com.arep.bank.catsbankbackend.service;


public class BankAccountException extends Exception{
    public final static String NOT_FOUND = "The element does not exists";
    public final static String USER_IS_ALREADY_CREATED = "The user is alredy created";
    public final static String TRANSFER_NOT_SUCCESSFUL = "The transfer could'nt be done, please try again later.";

    public BankAccountException(String message) {
        super(message);
    }

    public BankAccountException(String message, Throwable cause) {
        super(message, cause);
    }

}
