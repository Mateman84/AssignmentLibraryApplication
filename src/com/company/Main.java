package com.company;

public class Main {

    public static void main(String[] args) {

        LibraryApp libraryApp = new LibraryApp();
        libraryApp.addMember(new Member("Johan", Roles.MEMBER, 1234));
        libraryApp.addBookToLibrary(new Book("Catcher", "Sven", "Book about a catcher", 1337, true));
        libraryApp.addBookToLibrary(new Book("Bert", "Some dude", "Book about a Bert", 1234, false));
        libraryApp.addBookToLibrary(new Book("Computer Science", "Benny", "Book about a computer science", 137, true));
        libraryApp.mainMenu();

    }
}
