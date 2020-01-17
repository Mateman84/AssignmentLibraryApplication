package com.company;

import java.util.ArrayList;

public class LibraryApp {
    ArrayList<Member> members = new ArrayList<>();
    ArrayList<Book> books = new ArrayList<>();
    Admin admin = new Admin("admin", Roles.ADMIN, 123);

    public void libraryAppLogin(){
        System.out.println("Welcome to Mattes library");
        System.out.println("Enter login:");
    }
}
