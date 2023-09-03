package org.example;
import java.util.ArrayList;
public class member      {
    String name;
    int age;
    int phone_number;
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getPhone_number() {
        return phone_number;
    }
    int fine=0;

    private ArrayList<book> member_book = new ArrayList<book>();

    public ArrayList<book> getBorrowedBooks() {
        return new ArrayList<>(member_book); // Return a copy to prevent direct modification
    }
     public void initializeBorrowedBooks(ArrayList<book> savedData) {
        member_book = savedData;
    }

    // Method to save borrowedBooks data (when exiting the session, for example)
    public ArrayList<book> saveBorrowedBooks() {
        return member_book; // Save this data to be restored later
    }
    public member(String name, int age, int phone_number) {
        this.name = name;
        this.age = age;
        this.phone_number = phone_number;
    }
    public void list_my_books(){
        if(member_book.isEmpty()){
            System.out.println("No books borrowed yet!");
            return;
        }else {
            for (int i = 0; i < member_book.size(); i++) {
                System.out.println(member_book.get(i).getId());
                System.out.println(member_book.get(i).getTitle());
            }
        }
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public void borrow_book(int x ){


            if (librarian.Book_list.get(x).copies > 0) {
                member_book.add(librarian.Book_list.get(x));

                librarian.Book_list.get(x).startTimer();
                System.out.println("Book borrowed successfully!");

            } else {
                System.out.println("Sorry! No copies of the book are available!");
            }

    }
    public member(){}

    public member(String name, int phone_number){
        this.name = name;
        this.phone_number = phone_number;
    }
    public int  return_book(int id , String title){
        for(int i=0;i<member_book.size();i++){
           if(member_book.get(i).getId()==id && member_book.get(i).getTitle().equals(title)){
                librarian.Book_list.get(id-1).stopTimer();
                int days = librarian.Book_list.get(id-1).getElapsedTime();
                if(days>10){
                    fine=(days-10)*3;
                    System.out.println("You have a fine of Rs."+fine+" on the book "+title);
                    System.out.println("Please  pay the fine to return the book!");
                }  else System.out.println("No fine on the book "+title);
                member_book.remove(i);
                librarian.Book_list.get(id-1).copies++;
                System.out.println("Book returned successfully!");


                return 0;
                }
          }
        return fine;
    }
    public int total_fine(){
        for(int i=0;i<member_book.size();i++){
            int days = member_book.get(i).getElapsedTime();
            if(days>10){
             fine=(days-10)*3;
            }
            librarian.Book_list.get(i).resetTimer();
        }
        return fine;
    }
}