package com.codegym.my_phone.model;

public class Contact {
    private String name;
    private String phoneNumber;
    private Type type;

    public Contact() {
    }

    public Contact(String name, String phoneNumber, Type type) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.type = type;
    }

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumer() {
        return phoneNumber;
    }

    public void setPhoneNumer(String phoneNumer) {
        this.phoneNumber = phoneNumer;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phoneNumer='" + phoneNumber + '\'' +
                ", type=" + type +
                '}'+ "\n";
    }
}
