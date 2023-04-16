package com.codegym.my_phone.controller;
import com.codegym.my_phone.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PhoneBookManage extends Phone implements IPhone {
    List<Contact> contactList = new ArrayList<>();

    @Override
    public void searchPhone(String name) {
        List<Contact> listByName = contactList
                .stream()
                .filter(contact -> contact.getName().contains(name))
                .collect(Collectors.toList());
        System.out.println(listByName);
    }

    @Override
    public void sortByName() {
        List<Contact> listSortedByName = contactList
                .stream()
                .sorted(Comparator.comparing(Contact::getName))
                .collect(Collectors.toList());
        System.out.println(listSortedByName);
    }

    @Override
    public void display(Type type) {
            List<Contact> listFilter = contactList.stream()
                    .filter(typeFilter -> typeFilter.getType().getTypeName().equals(type.getTypeName()))
                    .collect(Collectors.toList());
            System.out.println(listFilter);
    }
    public void display(){
        System.out.println(contactList);
    }

    @Override
    public void insertPhone(Contact contact) {
        boolean isExisted = contactList
                .stream()
                .anyMatch(nameCheck -> nameCheck.getName().equals(contact.getName()));
        if(isExisted){
            for(int i =0; i< contactList.size();i++){
                if(contactList.get(i).getName().equals(contact.getName())){
                    contactList.get(i).setPhoneNumer(contact.getPhoneNumer());
                    contactList.get(i).setType(contact.getType());
                    break;
                }
            }
        }else {
            contactList.add(contact);
        }
    }

    @Override
    public void removePhone(String name) {
        contactList = contactList
                .stream()
                .filter(contact -> !contact.getName().equals(name)).collect(Collectors.toList());
    }

    @Override
    public void updatePhone(String name, String newPhone) {

    }
}
