package com.arep.bank.catsbankbackend.service;

import com.arep.bank.catsbankbackend.model.User;

public interface UserVerificationService {

    boolean verifyUser( int id, String name, String tipo);

    boolean isUserBlackListed(int id);


}
