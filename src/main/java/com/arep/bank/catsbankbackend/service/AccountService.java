package com.arep.bank.catsbankbackend.service;

import com.arep.bank.catsbankbackend.model.Account;
import com.arep.bank.catsbankbackend.model.CATSAccount;

public interface AccountService {

    CATSAccount getAccountById(int id);

    CATSAccount createAccount(Account account);

}
