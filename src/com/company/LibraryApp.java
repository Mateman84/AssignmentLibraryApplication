package com.company;

import java.util.ArrayList;
import java.util.Scanner;

import static com.company.FileUtils.readObject;

public class LibraryApp {

    private ArrayList<Librarian> librarians = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Book> books = new ArrayList<>();
    private String title;
    private String authorName;
    private String userName;
    private int userPin;
    private int choice;

    private Scanner scanner = new Scanner(System.in);

    public void libraryLogin (){
        librarians = (ArrayList<Librarian>)(readObject("librarians"));
        members = (ArrayList<Member>)(readObject("members"));
        System.out.println("Welcome to Library app of the century");
        System.out.println("Enter login name: ");
        userName = scanner.nextLine();
        System.out.println("Enter your pin: ");
        userPin = scanner.nextInt();
        Person loggedInUser = whatAreYou(userName, userPin);
        System.out.println(loggedInUser);


    }

    public Person whatAreYou(String userName, int userPin){
        for(Member member:members){
            if(userName.equalsIgnoreCase(member.getName()) && userPin == member.getPin()){
                return member;
            }
        }
        for (Librarian librarian: librarians) {
            if (userName.equalsIgnoreCase(librarian.getName()) && userPin == librarian.getPin()){
                return librarian;
            }
        }
        return null;
    }

    public void mainMenu() {
        books = (ArrayList<Book>)(readObject("books"));
        System.out.println("Welcome to library");
        System.out.println("What would you like to do?");
        System.out.println("1. Show available items.");
        System.out.println("2. Find out more about a book.");
        System.out.println("3. Find book by author.");
        System.out.println("4. Show Customers");
        choice = scanner.nextInt();
        switch (choice) {
            case (1):
                System.out.println("Here are all the books in the library.");
                showAllBooksInLibrary();
                break;
            case (2):
                findOutMoreAboutBook();
                break;
            case (3):
                scanner.nextLine();
                System.out.println("Enter the name of the author");
                authorName = scanner.nextLine();
                System.out.println(findBooksByAuthor(authorName));
                break;
            case (4):
                System.out.println("Here is all the customers in the library: ");
                showAllMembersOfLibrary();
                break;
        }
    }

    public void showAllBooksInLibrary(){
        for (Book book:books) {
            if (book != null){
                System.out.println(book);
            }
        }
    }

    public void findOutMoreAboutBook(){
        scanner.nextLine();
        System.out.println("Enter title of the book that you want to find out more about: ");
        title = scanner.nextLine();
        if(title == null){
            System.out.println("No book with that title");
        } else {
            System.out.println(findBookWithTitle(title));
        }
    }

    public Book findBookWithTitle(String title){
        for (Book book:books) {
            if(book == null){
                continue;
            }
            if (title.equalsIgnoreCase(book.getTitle())){
                return book;
            }
        }
        return null;
    }

    public Book findBooksByAuthor(String authorName){
        for (Book book:books) {
            if(book == null){
                continue;
            }
            if (authorName.equalsIgnoreCase(book.getAuthor())){
                return book;
            }
        }
        return null;
    }

    public Book borrowBook(){

        return null;
    }

    public ArrayList showBorrowedBooks(String memberName){
        return null;
    }

    public Book returnBorrowedBook(){
        return null;
    }

    public void addBookToLibrary(Book book){
        books.add(book);
        FileUtils.writeObject(books, "books");
    }
    public void addMemberToLibrary(Member member){
        members.add(member);
        FileUtils.writeObject(members, "members");
    }
    public void addLibrarian(Librarian librarian){
        librarians.add(librarian);
        FileUtils.writeObject(librarians, "librarians");
    }

    public void showAllMembersOfLibrary(){
        for (Member member : members) {
            if(member != null){
                System.out.println(member);
            }
        }
    }

}