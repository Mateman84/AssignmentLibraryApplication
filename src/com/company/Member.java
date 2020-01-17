package com.company;

import java.awt.print.Book;
import java.util.ArrayList;

public class Member extends Person {

    private int socialSecurityNumber;
    private ArrayList<Book> borrowedBooks = new ArrayList<>();

    public Member(String name, Roles role, int pin, int socialSecurityNumber) {
        super(name, role, pin);
        this.socialSecurityNumber = socialSecurityNumber;
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
                "socialSecurityNumber=" + socialSecurityNumber +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}
