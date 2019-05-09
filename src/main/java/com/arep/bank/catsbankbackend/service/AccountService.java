package com.arep.bank.catsbankbackend.service;

import com.arep.bank.catsbankbackend.model.CATSAccount;

public interface AccountService {

    CATSAccount getAccountById(int id);

    CATSAccount createAccount(CATSAccount account);

}
