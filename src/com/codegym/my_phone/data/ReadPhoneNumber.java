package com.codegym.my_phone.data;

import com.codegym.my_phone.model.Contact;
import com.codegym.my_phone.model.Type;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadPhoneNumber<E> {
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
            }
        } catch (Exception e) {
            System.out.println("Something wrong");
            e.printStackTrace();
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
        } catch (Exception e) {
            System.out.println("Something wrong");
            e.printStackTrace();
        }
    }
    public List<E> readPhoneBookGeneric(){
        String pathName = "src\\com\\codegym\\my_phone\\data\\test_generic.txt";
        List<E> listContact = new ArrayList<>();
        File binaryContact = new File(pathName);
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(binaryContact))){
                listContact = (List<E>)reader.readObject();
            System.out.println("Read success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listContact;
    }
}
