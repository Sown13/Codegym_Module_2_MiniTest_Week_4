package com.codegym.my_phone;

import com.codegym.my_phone.controller.PhoneBookManage;
import com.codegym.my_phone.model.Contact;
import com.codegym.my_phone.model.Type;

import java.util.Scanner;


public class ManagePhoneBook {
    public static void main(String[] args) {
      menu();
    }
    public static void menu() {
        PhoneBookManage phoneBook = new PhoneBookManage();
        Scanner scanner = new Scanner(System.in);
        Type friend = new Type("Friend");
        Type family = new Type("Family");
        Type company = new Type("Company");
        Type customer = new Type("Customer");
        Type other = new Type("Other");

        int choice;
        while (true) {
            System.out.println("Please choose your action:");
            System.out.println("1/ Show phone book");
            System.out.println("2/ Insert a contact");
            System.out.println("3/ Remove a contact");
            System.out.println("4/ Quick Update a contact");
            System.out.println("5/ Search for a contact");
            System.out.println("6/ Import phone book");
            System.out.println("7/ Export phone book");
            System.out.println("0/ Exit");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> {
                    boolean isChoosing = true;
                    while (isChoosing) {
                        System.out.println("1/ Show all");
                        System.out.println("2/ Show Friend");
                        System.out.println("3/ Show Family");
                        System.out.println("4/ Show Company");
                        System.out.println("5/ Show Customer");
                        System.out.println("6/ Show Other");
                        System.out.println("0/ Back to main menu");
                        choice = Integer.parseInt(scanner.nextLine());
                        switch (choice) {
                            case 1 -> phoneBook.display();
                            case 2 -> phoneBook.display(friend);
                            case 3 -> phoneBook.display(family);
                            case 4 -> phoneBook.display(company);
                            case 5 -> phoneBook.display(customer);
                            case 6 -> phoneBook.display(other);
                            case 0 -> isChoosing = false;
                        }
                    }
                }
                case 2 -> {
                    System.out.println("Enter the contact name");
                    String name = scanner.nextLine();
                    System.out.println("Enter the phone number");
                    String phoneNumber = scanner.nextLine();
                    System.out.println("Choose Type");
                    System.out.println("1/ Friend");
                    System.out.println("2/ Family");
                    System.out.println("3/ Company");
                    System.out.println("4/ Customer");
                    System.out.println("5/ Other");
                    choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1 -> phoneBook.insertPhone(new Contact(name, phoneNumber, friend));
                        case 2 -> phoneBook.insertPhone(new Contact(name, phoneNumber, family));
                        case 3 -> phoneBook.insertPhone(new Contact(name, phoneNumber, company));
                        case 4 -> phoneBook.insertPhone(new Contact(name, phoneNumber, customer));
                        case 5 -> phoneBook.insertPhone(new Contact(name, phoneNumber, other));
                    }
                }
                case 3 -> {
                    System.out.println("Enter contact name that you want to remove:");
                    String name = scanner.nextLine();
                    phoneBook.removePhone(name);
                }
                case 4 -> {
                    System.out.println("Enter the contact name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter the phone number");
                    String phoneNumber = scanner.nextLine();
                    phoneBook.updatePhone(name,phoneNumber);
                }
                case 5 -> {
                    System.out.println("Enter the contact name or phone number to find:");
                    String name = scanner.nextLine();
                    phoneBook.searchPhone(name);
                }
                case 6 -> {

                }
                case 7 -> {

                }
                case 0 -> System.exit(0);
            }
        }
    }
}
