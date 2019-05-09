package com.arep.bank.catsbankbackend.model;

public class Reference {

    String name;
    int id;

    String email;

    String address;

    int phone;

    public Reference(String name, int id, String address, int phone, String email) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
