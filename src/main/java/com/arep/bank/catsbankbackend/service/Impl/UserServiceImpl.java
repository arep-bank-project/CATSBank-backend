package com.arep.bank.catsbankbackend.service.Impl;

import com.arep.bank.catsbankbackend.model.Account;
import com.arep.bank.catsbankbackend.model.CATSAccount;
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
    Map<Integer, Account> accounts= new HashMap<>();
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


    public Account getAccountById(int account) throws BankAccountException{
        if(accounts.containsKey(account)){
            return accounts.get(account);
        }else{
            throw new BankAccountException(BankAccountException.NOT_FOUND);
        }
    };

    public void updateAccount(Account account) throws BankAccountException {
        if(accounts.containsKey(account.getAccountId())){
            accounts.put(account.getAccountId(),account);
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
        Account account;
        if (user.getType().equals("CTS")){
            account = new CATSAccount();
            accounts.put(account.getAccountId(), account);
            user.setAccount(account);
            users.put(user.getId(), user);
            /*for (Map.Entry<Integer, Account> entry : accounts.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }*/

        }else{
            users.put(user.getId(), user);
        }

        return user;
    }

    @Override
    public void updateUser(User user) throws BankAccountException {
        if(users.containsKey(user.getId())){
            users.put(user.getId(), user);
        }
        else {

            throw new BankAccountException(BankAccountException.NOT_FOUND);
        }
    }

    @Override
    public boolean removeUser(int id) throws BankAccountException {
        return false;
    }

    @Override
    public boolean transfer(int fromAccount, int toAccount, double amount) {
        /*for (Map.Entry<Integer, Account> entry : accounts.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }*/
        try{

            Account from = getAccountById(fromAccount);
            Account to = getAccountById(toAccount);
            /*User from = getUserById(fromAccount);
            User to = getUserById(toAccount);*/

            if (from.getAmount() < amount){
                throw new BankAccountException(BankAccountException.TRANSFER_NOT_SUCCESSFUL);
            }else{
                from.setAmount(from.getAmount() - amount);

                to.setAmount(to.getAmount() + amount);
            }

        } catch (BankAccountException e) {
            e.printStackTrace();
        }

        return false;
    }
}
