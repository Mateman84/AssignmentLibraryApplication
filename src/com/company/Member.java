package com.company;

import java.awt.print.Book;
import java.io.Serializable;
import java.util.ArrayList;

public class Member extends Person {

    private ArrayList<Book> borrowedBooks = new ArrayList<>();

    public Member(String name, Roles role, int pin) {
        super(name, role, pin);
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(ArrayList<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    @Override
    public String toString() {
        return "Member{" +
                "Membername: " + getName() +
                " Memberrole: " + getRole() +
                " Memberpin: " + getPin() +
                " borrowedBooks=" + borrowedBooks +
                '}';
    }
}
