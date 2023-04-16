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
        listTest.display(friend);
        listTest.display();
        listTest.sortByName();

    }
}
