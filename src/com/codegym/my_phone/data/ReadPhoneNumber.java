package com.codegym.my_phone.data;

import com.codegym.my_phone.model.Contact;
import com.codegym.my_phone.model.Type;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadPhoneNumber {
    public static List<Contact> importPhoneBook(String pathName){
        List<Contact> importList = new ArrayList<>();
//        Path importPhoneBook = Paths.get(".src\\com\\codegym\\my_phone\\data\\phone_book_importer.txt");
        File importPhoneBook = new File(pathName);
        try (Scanner scanner = new Scanner(importPhoneBook)){
            while (scanner.hasNext()){
                String name = scanner.next();
                String phoneNumber = scanner.next();
                String typeName = scanner.next();
                Contact contact = new Contact(name,phoneNumber, new Type(typeName));
                importList.add(contact);
                System.out.println(name + phoneNumber + contact);
            }
        } catch (IOException e) {
            System.out.println("Something wrong");
            throw new RuntimeException(e);
        }
        return importList;
    }
    public static void readPhoneBook(){
        String pathName = "src\\com\\codegym\\my_phone\\data\\phone_book.txt";
        File importPhoneBook = new File(pathName);
        try (Scanner scanner = new Scanner(importPhoneBook)){
            int order = 0;
            while (scanner.hasNext()){
                String contact = scanner.nextLine();
                System.out.println(++order + " " + contact);
            }
        } catch (IOException e) {
            System.out.println("Something wrong");
            throw new RuntimeException(e);
        }
    }
}
