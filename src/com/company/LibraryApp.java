package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp {
    ArrayList<Member> members = new ArrayList<>();
    ArrayList<Book> books = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    Admin admin = new Admin("admin", Roles.ADMIN, 123);
    private String userName;
    private int userPin;

    public void libraryAppLogin(){
        System.out.println("Welcome to Mattes library");
        System.out.println("Enter login");
        System.out.println("Name: ");
        userName = scanner.nextLine();
        System.out.println("Enter pin: ");
        userPin = scanner.nextInt();
        if(userName.equals(admin.getName()) && userPin == admin.getPin()){
            System.out.println("Welcome " + admin.getName());
        }

    }
}
