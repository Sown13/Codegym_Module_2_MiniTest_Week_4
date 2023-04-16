package com.codegym.my_phone.data;

import com.codegym.my_phone.model.Contact;

import java.io.*;
import java.util.List;

public class WritePhoneNumber<E> {
    public static void exportPhoneNumber(List<Contact> exportList, String pathName){
        File exportPhoneBook = new File(pathName);
        try(FileOutputStream fileOutputStream = new FileOutputStream(exportPhoneBook);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream) ){
            for(Contact contact : exportList){
                objectOutputStream.writeObject(contact);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void saveToPhoneBook(List<Contact> exportList){
        String pathName = "src\\com\\codegym\\my_phone\\data\\phone_book.txt";
        File exportPhoneBook = new File(pathName);
        try(FileWriter fileWriter = new FileWriter(exportPhoneBook)){
            for(Contact contact : exportList){
                fileWriter.write(contact.getName() + " ");
                fileWriter.write(contact.getPhoneNumer() + " ");
                fileWriter.write(contact.getType().getTypeName() + "\n");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void exportPhoneNumberGeneric(List<E> exportList){
        String pathName = "src\\com\\codegym\\my_phone\\data\\test_generic.txt";
        File exportPhoneBook = new File(pathName);
        try(FileOutputStream fileOutputStream = new FileOutputStream(exportPhoneBook);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream) ){
            for(E contact : exportList){
                objectOutputStream.writeObject(contact);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
