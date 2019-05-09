package com.arep.bank.catsbankbackend.service.Impl;

import com.arep.bank.catsbankbackend.model.User;
import com.arep.bank.catsbankbackend.service.BankAccountException;
import com.arep.bank.catsbankbackend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {

    Map<Integer, User> users =  new HashMap<>();
    @Override
    public List<User> getUsers() throws BankAccountException {

        return null;
    }

    @Override
    public User getUserById(int id) throws BankAccountException {
        if(users.containsKey(id)){
            return users.get(id);
        }else{
            throw new BankAccountException(BankAccountException.NOT_FOUND);
        }

    }

    @Override
    public User getUserByEmail(String email) throws BankAccountException {
        return null;
    }

    @Override
    public User createUser(User user) throws BankAccountException {
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public User updateUser(User user) throws BankAccountException {
        return null;
    }

    @Override
    public boolean removeUser(int id) throws BankAccountException {
        return false;
    }
}
