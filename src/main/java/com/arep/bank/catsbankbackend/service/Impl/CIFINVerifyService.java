package com.arep.bank.catsbankbackend.service.Impl;

import com.arep.bank.catsbankbackend.model.User;
import com.arep.bank.catsbankbackend.service.UserVerificationService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class CIFINVerifyService implements UserVerificationService{

    Set<Integer> registeredUsersDataBase = new HashSet<>();
    Set<Integer> blackList = new HashSet<>();

    public CIFINVerifyService() {

        registeredUsersDataBase.add(123);
        registeredUsersDataBase.add(124);
        registeredUsersDataBase.add(125);
        registeredUsersDataBase.add(126);
        registeredUsersDataBase.add(127);

        blackList.add(123);
        blackList.add(125);
    }

    @Override
    public boolean verifyUser(int id, String name, String tipo) {

        /*if (registeredUsersDataBase.contains(id)){
            return true;
        }else{
            return false;
        }*/
        return true;
    }

    @Override
    public boolean isUserBlackListed(int id) {

        if (blackList.contains(id)){
            return true;
        }else{
            return false;
        }
    }


}
