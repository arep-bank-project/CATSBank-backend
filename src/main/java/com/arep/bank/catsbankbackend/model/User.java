package com.arep.bank.catsbankbackend.model;

import com.arep.bank.catsbankbackend.controller.UserController;

public class User {
    private String name;
    private int id;
    private Account account;

    private Reference reference;

    private String type;

    String email;

    String address;

    int phone;

    String password;

    UserController.Token token;

    public User() {
    }

    public User(int id, String password) {
        this.id = id;
        this.password = password;
    }

    public User(String name, int id, Account account, String type, Reference reference, String email, String address, int phone) {
        this.name = name;
        this.id = id;
        this.account = account;
        this.type = type;
        this.reference = reference;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Reference getReference() {
        return reference;
    }

    public void setReference(Reference reference) {
        this.reference = reference;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public UserController.Token getToken() {
        return token;
    }

    public void setToken(UserController.Token token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", account=" + account +
                ", reference=" + reference +
                ", type='" + type + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", password='" + password + '\'' +
                '}';
    }
}
