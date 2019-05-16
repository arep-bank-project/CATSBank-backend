package com.arep.bank.catsbankbackend.service;

import com.arep.bank.catsbankbackend.model.User;

import java.util.List;

public interface UserService {

    List<User> getUsers() throws BankAccountException;

    User getUserById( int id)throws BankAccountException;

    User getUserByEmail(String email) throws BankAccountException;

    User createUser( User user) throws BankAccountException;

    void updateUser(User user) throws BankAccountException;

    boolean removeUser(int id) throws BankAccountException;

    boolean transfer(int fromAccount, int toAccount, double amount);
}
