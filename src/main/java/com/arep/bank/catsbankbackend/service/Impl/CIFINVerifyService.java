package com.arep.bank.catsbankbackend.service.Impl;

import com.arep.bank.catsbankbackend.model.User;
import com.arep.bank.catsbankbackend.service.UserVerificationService;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CIFINVerifyService implements UserVerificationService{

    Set<Integer> blackList = new HashSet<>();
    @Override
    public boolean verifyUser(int id) {

        if (blackList.contains(id)){
            return false;
        }else{
            return true;
        }


    }
}
