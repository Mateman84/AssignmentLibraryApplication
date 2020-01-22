package com.company;

import javax.management.relation.Role;
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
    /*
    public void libraryLogin (){
        System.out.println("Welcome to Library app of the century");
        System.out.println("Enter login name: ");
        userName = scanner.nextLine();
        System.out.println("Enter your pin: ");
        userPin = scanner.nextInt();
        try{
            isLibrarian(userName, userPin);
        } catch (Exception e){
            System.out.println("Not librarian");
        }
        try{
            isMember(userName, userPin);
        } catch (Exception e){
            System.out.println("Not a member");
        }
    }

    public Roles isLibrarian(String name, int pin){
        librarians = (ArrayList<Librarian>)(readObject("librarians"));
        for (int i = 0; i < librarians.size(); i++){
            if (name.equalsIgnoreCase(librarians.get(i).getName())){
                if(pin == librarians.get(i).getPin()){
                    System.out.println("Successful login!");
                    return librarians.get(i).getRole();
                } else {
                    System.out.println("Wrong pin");
                }
            }
            else {
                System.out.println("No user with that name.");
                return null;
            }
        }
        return null;
    }

    public Roles isMember(String name, int pin){
        members = (ArrayList<Member>)(readObject("members"));
        for (int i = 0; i < members.size(); i++){
            if (name.equalsIgnoreCase(members.get(i).getName())){
                if(pin == members.get(i).getPin()){
                    System.out.println("Successful login!");
                    return members.get(i).getRole();
                } else {
                    System.out.println("Wrong pin");
                }
            }
            else {
                System.out.println("Np user with that name.");
                return null;
            }
        }
        return null;
    }
*/

    public void mainMenu(){
        System.out.println("Welcome member, what would you like to do: ");
        //System.out.println("1. Add a book to the library. ");
        System.out.println("1. Show available books.");
        System.out.println("2. Find out more about a book.");
        //System.out.println("3. Add Member. ");
        //System.out.println("4. Show Members. ");
        choice = scanner.nextInt();
        /*if (choice == 1){
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
                System.out.println("Would you like to add another? y/n");
                String answer = scanner.nextLine();

        }*/
        if (choice == 1){
            showBooksInLibrary();
        }
        if (choice == 2){
            findOutMoreAboutBook();
        }
        if(choice == 3){

        }
    }
    public void findOutMoreAboutBook(){
        books = (ArrayList<Book>)(readObject("books"));
        scanner.nextLine();
        System.out.println("Enter which title you would like to find out more about: ");
        title = scanner.nextLine();
        for(int i = 0; i < books.size(); i++){
            if (title.equals(books.get(i).getTitle())){
                System.out.println(books.get(i));
            } else {

            }
        }

    }

    public void addMember(Member member){
        members.add(member);
        FileUtils.writeObject(members, "members");
    }
    public void showMembers(){
        members = (ArrayList<Member>)(readObject("members"));
        System.out.println(members);
    }
    public void addBookToLibrary(Book book){
        books.add(book);
        FileUtils.writeObject(books, "books");
    }
    public void showBooksInLibrary(){
       books = (ArrayList<Book>)(readObject("books"));
        for (Book book : books) {
            System.out.println(book.getTitle());
        }
    }
}