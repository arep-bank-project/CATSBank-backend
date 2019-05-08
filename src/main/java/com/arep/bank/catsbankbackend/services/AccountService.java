package com.arep.bank.catsbankbackend.services;

import com.arep.bank.catsbankbackend.model.CATSAccount;

public interface AccountService {

    CATSAccount getAccountById(int id);

    CATSAccount createAccount(CATSAccount account);

}
