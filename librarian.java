package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class librarian {
    public  boolean search_books(int x){
        if(Book_list.isEmpty()){
            System.out.println("No books in the library!");
            return false;
        }
        for (org.example.book book : Book_list) {
            if (book.getId == x) {
                return true;
            }
        }
        return false;
    }
    public void register_member() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Age: ");
            int age = sc.nextInt();
            System.out.print("Phone Number: ");
            int phone_number = sc.nextInt();
            member m = new member(name,phone_number);
            m.setName(name);
            m.setPhone_number(phone_number);
            System.out.println("Member Registered Successfully!");
            Member_list.add(m);
        } catch (InputMismatchException e) {
            System.err.println("Input mismatch. Please enter valid values for Age and Phone Number.");
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void remove_member(String name) {
        if( Member_list.isEmpty()) {
            System.out.println("No members in the library!");
            return;
        }
        for (int i = 0; i < Member_list.size(); i++) {
            if (Member_list.get(i).getName().equals(name)) {
                Member_list.remove(i);
                System.out.println("Member Removed Successfully!");
                return;
            }
        }
        System.out.println("Member not found!");
    }

    public void add_book(book b) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the id of the book: ");
        int id = sc.nextInt();
        System.out.print("Enter the title of the book: ");
        String title = sc.next();
        System.out.print("Enter the author of the book: ");
        String author = sc.next();
        System.out.print("Enter the number of copies of the book: ");
        int copies = sc.nextInt();
         b = new book(id, title, author, copies);
        if(search_books(id)){
            System.out.println("Book already exists, so more copies will be added to the existing book!");
            for (org.example.book book : Book_list) {
                if (book.getId == id) {
                    book.copies += copies;
                }
            }
        }
        else{
        System.out.println("Book Added Successfully!");
        Book_list.add(b);}
    }

    public void remove(int id , String title){
        if( Book_list.isEmpty()){
            System.out.println("No books in the library!");
            return;
        }
        for (org.example.book book : Book_list) {
            if (book.getTitle().equals(title)) {
                book.copies--;
                System.out.println("Book Removed Successfully!");
                return;
            }
        }
        System.out.println("Book not found!");
    }
    public void view_all_books() {
         if(Book_list.isEmpty()){
            System.out.println("No books in the library!");

        }
        else {
            for (org.example.book book : Book_list) {
                System.out.println("Id: " + book.getId() + "\nTitle: " + book.getTitle() + "\nAuthor: " + book.getAuthor() + "\nCopies: " + book.getCopies());
            }
        }
    }
    public void view_all_members_with_books() {
        if(Member_list.isEmpty()){
            System.out.println("No members in the library!");
            return;
        }
    for (member member : Member_list) {
        ArrayList<book> memberBooks = member.getBorrowedBooks(); // Use the getter method

            System.out.println("Name: " + member.getName() + " Age: " + member.getAge() + " Phone Number: " + member.getPhone_number());
            if (memberBooks.isEmpty()) {
            System.out.println("No books borrowed yet!");
            }
            else {
            System.out.println("Books: ");
            for (book book : memberBooks) {
                System.out.print("Id: " + book.getId() + "\nTitle: " + book.getTitle() +
                        "\nAuthor: " + book.getAuthor());
            }
            for (book book : memberBooks) {
                if (book.getElapsedTime() > 10) {
                    member.fine = member.total_fine();
                    System.out.print(" Fine of member " + member.getName() + " is " + member.fine);
                }
            }
        }
    }
}

    public boolean search_member(String name , int phone_number){
        if(Member_list.isEmpty()){
            System.out.println("No members in the library!");
            return false;
        }
        for (org.example.member member : Member_list) {
            if (member.getName().equals(name) && member.getPhone_number() == phone_number) {
                return true;
            }
        }
        return false;
    }
    private static ArrayList<member> Member_list = new ArrayList<member>();
    static ArrayList<book> Book_list = new ArrayList<book>();
}