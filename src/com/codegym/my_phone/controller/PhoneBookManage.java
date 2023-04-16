package com.codegym.my_phone.controller;

import com.codegym.my_phone.data.WritePhoneNumber;
import com.codegym.my_phone.model.Contact;
import com.codegym.my_phone.model.IPhone;
import com.codegym.my_phone.model.Phone;
import com.codegym.my_phone.model.Type;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneBookManage extends Phone implements IPhone {
    List<Contact> contactList = new ArrayList<>();


    @Override
    public void searchPhone(String name) {
        List<Contact> resultList = contactList
                .stream()
                .filter(contact -> contact.getName().contains(name) || contact.getPhoneNumer().contains(name))
                .toList();
        if (resultList.isEmpty()) {
            System.out.println("Result not found");
        } else {
            System.out.println(resultList);
        }
    }

    @Override
    public void sortByName() {
        List<Contact> listSortedByName = contactList
                .stream()
                .sorted(Comparator.comparing(Contact::getName))
                .toList();
        System.out.println(listSortedByName);
    }

    @Override
    public void display(Type type) {
        List<Contact> listFilter = contactList.stream()
                .filter(typeFilter -> typeFilter.getType().getTypeName().equals(type.getTypeName()))
                .collect(Collectors.toList());
        System.out.println(listFilter);
    }

    public void display() {
        System.out.println(contactList);
    }

    @Override
    public void insertPhone(Contact contact) {
        boolean isExisted = contactList
                .stream()
                .anyMatch(nameCheck -> nameCheck.getName().equals(contact.getName()));
        if (isExisted) {
            List<Contact> insertContact = contactList
                    .stream()
                    .filter(nameCheck -> nameCheck.getName().equals(contact.getName()))
                    .toList();
            insertContact.get(0).setPhoneNumer(contact.getPhoneNumer());
            if(contact.getType() != null) {
                insertContact.get(0).setType(contact.getType());
            }
        } else {
            contactList.add(contact);
        }
        WritePhoneNumber.saveToPhoneBook(contactList);
        System.out.println("Success to insert");
    }

    @Override
    public void removePhone(String name) {
        contactList = contactList
                .stream()
                .filter(contact -> !contact.getName().equals(name))
                .collect(Collectors.toList());
        WritePhoneNumber.saveToPhoneBook(contactList);
        System.out.println("Remove success");
    }

    @Override
    public void updatePhone(String name, String newPhone) {
        Contact newContact = new Contact(name, newPhone);
        insertPhone(newContact);
    }

    public void clearPhoneBook(){
        contactList.clear();
    }
    public List<Contact> getContactList() {
        return contactList;
    }
}
