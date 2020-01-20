package com.company;

import java.util.ArrayList;
import java.util.Scanner;

import static com.company.FileUtils.readObject;

public class LibraryApp {

    private ArrayList<Librarian> librarians = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Book> books = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);
    private Admin admin = new Admin("admin", Roles.ADMIN, 123);
    private Book book;
    private String userName;
    private int userPin;
    private boolean loginSuccessful = false;
    private int choice;
    private String title;
    private String author;
    private String description;
    private int noOfPages;
    private boolean isAvailable;

    public void librarianMenu(int choice){
        System.out.println("Welcome Librarian what would you like to do:");
        System.out.println("1. Add a book to the library.");
        choice = scanner.nextInt();
        if (choice == 1){
            scanner.nextLine();
            System.out.println("Enter book title: ");
            title = scanner.nextLine();
            System.out.println("Enter book author: ");
            author = scanner.nextLine();
            System.out.println("Enter a short description: ");
            description = scanner.nextLine();
            System.out.println("Enter number of pages: ");
            noOfPages = scanner.nextInt();

            addBookToLibrary(new Book(title, author, description ,noOfPages, true));
        }
        if (choice == 2){
            showBooksInLibrary();
        }
    }

    public void addMember(){

    }
    public void addBookToLibrary(Book book){
        books.add(book);
        FileUtils.writeObject(books, "books");
    }
    public void showBooksInLibrary(){
        System.out.println(readObject("books.ser"));
    }
}