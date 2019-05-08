package com.arep.bank.catsbankbackend.services;

import com.arep.bank.catsbankbackend.model.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getUserById( int id);

    User createUser( User user);

    User updateUser(User user);

    boolean removeUser(int id);
}
