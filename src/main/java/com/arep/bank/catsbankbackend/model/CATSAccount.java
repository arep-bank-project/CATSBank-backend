package com.arep.bank.catsbankbackend.model;

import java.util.HashSet;
import java.util.Set;

public class CATSAccount implements Account{

    private int accountId;
    private double amount;

    Set<Integer> accounts = new HashSet<>();

    public CATSAccount() {
        this.accountId = (int)((Math.random() * 9000000)+1000000);
        this.amount = 100;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
