package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, ArrayList<book>> savedData = new HashMap<>(); // HashMap to store saved data for each member

    public static void main(String[] args) {
        librarian l = new librarian();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    Library Portal Initialized…
                    ---------------------------------
                    1 - Enter as a librarian
                    2 - Enter as a member
                    3 - Exit
                    ---------------------------------""");

            int choice_1 = sc.nextInt();

            if (choice_1 == 1) {
                // Librarian's actions
                while (true) {
                    System.out.println("""
                            ---------------------------------
                            1 - Register a member
                            2 - Remove a member
                            3 - Add a book
                            4 - Remove a book
                            5 - View all members along with their books and fines to be paid
                            6 - View all books
                            7 - Back
                            ---------------------------------""");

                    int choice_2 = sc.nextInt();

                    if (choice_2 == 1) {
                        l.register_member();
                    } else if (choice_2 == 2) {
                        try {
                            System.out.print("Enter the name of the member to be removed: ");
                            String name = sc.next();
                            l.remove_member(name);
                        } catch (Exception e) {
                            System.err.println("An error occurred: " + e.getMessage());
                            e.printStackTrace();
                        }
                    } else if (choice_2 == 3) {
                        book b = new book();
                        l.add_book(b);
                    } else if (choice_2 == 4) {
                        try {
                            System.out.print("Enter the title of the book to be removed: ");
                            String title = sc.next();
                            l.remove(title);
                        } catch (InputMismatchException e) {
                            System.err.println("Input mismatch. Please enter a valid integer for ID.");
                        } catch (Exception e) {
                            System.err.println("An error occurred: " + e.getMessage());
                            e.printStackTrace();
                        }
                    } else if (choice_2 == 5) {
                        l.view_all_members_with_books();
                    } else if (choice_2 == 6) {
                        l.view_all_books();
                    } else if (choice_2 == 7) {
                        break;
                    }
                }
            } else if (choice_1 == 2) {
                System.out.print("Enter the name of the member: ");
                String name = sc.next();
                System.out.print("Enter the phone number of the member: ");
                int phone_number = sc.nextInt();

                if (l.search_member(name, phone_number)) {
                    member m = new member(name, phone_number);
                    System.out.println("Welcome Member " + name + "<" + phone_number + ">");
                    int fine = 0;
                    fine = m.total_fine();

                    // Initialize borrowed books from saved data if available
                    ArrayList<book> memberSavedData = savedData.get(phone_number);
                    if (memberSavedData != null) {
                        m.initializeBorrowedBooks(memberSavedData);
                    }

                    while (true) {
                        System.out.println("""
                                ---------------------------------
                                1 - List Available Books
                                2 - List My Books
                                3 - Issue book
                                4 - Return book
                                5 - Pay Fine
                                6 - Back
                                ---------------------------------
                                """);

                        int choice_2 = sc.nextInt();

                        if (choice_2 == 1) {
                            l.view_all_books();
                        } else if (choice_2 == 2) {
                            m.list_my_books();
                        } else if (choice_2 == 3) {
                            System.out.print("Enter the id of the book to be issued: ");
                            int id = sc.nextInt();
                            System.out.print("Enter the title of the book to be issued: ");
                            String title = sc.next();
                            m.borrow_book(id - 1,title);
                            librarian.Book_list.get(id - 1).copies -= 1;
                        } else if (choice_2 == 4) {
                            System.out.print("Enter the id of the book to be returned: ");
                            int id = sc.nextInt();
                            System.out.print("Enter the title of the book to be returned: ");
                            String title = sc.next();
                            m.return_book(id, title);

                        } else if (choice_2 == 5) {

                            if (m.fine == 0) {
                                System.out.println("You have no fine to pay for rest of the books!");
                            } else if (m.fine > 0) {
                                System.out.println("You have a fine of Rs." + m.fine + ". It has been paid successfully!\n");

                            }
                        } else if (choice_2 == 6) {
                            // Save the current state of borrowed books for this member
                            savedData.put(phone_number, m.saveBorrowedBooks());
                            break;
                        } else {
                            System.out.println("Invalid Choice!");
                        }
                    }
                } else {
                    System.out.println("Member with Name:" + name + " and Phone No: " + phone_number + " doesn't exist");
                }
            } else if (choice_1 == 3) {
                break;
            }
        }
    }
}
