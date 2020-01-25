package com.company;

import java.io.Serializable;
import java.util.ArrayList;

import static com.company.FileUtils.readObject;

public class Member extends Person {

    private ArrayList<Book> borrowedBooks = new ArrayList<>();

    public Member(String name, Roles role, int pin) {
        super(name, role, pin);
        FileUtils.writeObject(borrowedBooks, name + "s_Borrowed_Books");
    }

    public ArrayList<Book> getBorrowedBooksForMember(Member member) {
        return borrowedBooks = (ArrayList<Book>)(readObject(member.getName() + "s_Borrowed_Books"));
    }

    public void addBookToBorrowedBooks(Book book, Member member){
        borrowedBooks = (ArrayList<Book>)(readObject(member.getName() + "s_Borrowed_Books"));
        borrowedBooks.add(book);
        FileUtils.writeObject(borrowedBooks, member.getName() + "s_Borrowed_Books");
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
