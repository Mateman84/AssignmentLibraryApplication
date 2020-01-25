package com.company;

import java.util.ArrayList;
import java.util.Scanner;

import static com.company.FileUtils.readObject;

public class LibraryApp {

    private ArrayList<Librarian> librarians = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Book> tempBookList = new ArrayList<>();
    private Person loggedInUser;
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
        loggedInUser = whatAreYou(userName, userPin);
        if(loggedInUser != null){
            mainMenu(loggedInUser);
        } else {
            System.out.println("Wrong username or password");
        }
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

    public void mainMenu(Person person) {
        while(true){
        books = (ArrayList<Book>)(readObject("books"));
        System.out.println("Welcome " + person.getRole() + person.getName() + " to library");
        System.out.println("What would you like to do?");
        System.out.println("1. Show available items.");
        System.out.println("2. Find out more about a book.");
        System.out.println("3. Find book by author.");
        System.out.println("4. Show Customers");
        System.out.println("5. Show borrowed Books");
        System.out.println("6. Borrow Book");
        System.out.println("9. Exit program");
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
            case(5):
                System.out.println("Here is all the books that " + person.getName() + " has borrowed");
                showBorrowedBooks();
                break;
            case(6):
                scanner.nextLine();
                System.out.println("Enter title of book you want to borrow: ");
                String bookToBorrow = scanner.nextLine();
                borrowBook(bookToBorrow);
                break;
            case (9):
                System.out.println("Goodbye!");
                System.exit(0);
        }
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

    public void borrowBook(String title){
        for(Member member:members){
            if(userName.equalsIgnoreCase(member.getName()) && userPin == member.getPin()){
                member.addBookToBorrowedBooks(findBookWithTitle(title), member);
            }
        }
    }

    public void showBorrowedBooks(){
        for(Member member:members){
            if(userName.equalsIgnoreCase(member.getName()) && userPin == member.getPin()){
                System.out.println(member.getBorrowedBooksForMember(member));
            }
        }
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