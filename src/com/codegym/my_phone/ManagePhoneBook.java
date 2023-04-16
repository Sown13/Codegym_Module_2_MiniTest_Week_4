package com.codegym.my_phone;

import com.codegym.my_phone.controller.PhoneBookManage;
import com.codegym.my_phone.model.Contact;
import com.codegym.my_phone.model.Type;

public class ManagePhoneBook {
    public static void main(String[] args) {
        PhoneBookManage listTest = new PhoneBookManage();
        Type friend = new Type("Friend");
        Type family = new Type("Family");

        Contact contact1 = new Contact("bon","123456", friend);
        Contact contact2 = new Contact("aon","123456", family);
        Contact contact3 = new Contact("cam","123456", family);
        listTest.insertPhone(contact1);
        listTest.insertPhone(contact2);
        listTest.insertPhone(contact3);
       listTest.insertPhone(contact1);
       listTest.removePhone("aon");
       listTest.display();
        Contact contact4 = new Contact("bon","999999999", friend);
        Contact contact5 = new Contact("1on","999999999", friend);
       listTest.insertPhone(contact4);
       listTest.insertPhone(contact5);
       listTest.display();
       listTest.sortByName();
        System.out.println("searching");
       listTest.searchPhone("999999999");


    }
}
