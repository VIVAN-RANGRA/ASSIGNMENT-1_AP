package org.example;

public class book extends TimeCounter{
    public int getId;
    String title;
    String author;
     int copies;
     int id;
    public int getId() {

        return id;
    }
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getCopies() {
        return copies;
    }
    public book(int id, String title, String author, int copies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.copies = copies;


    }
    book(){}
    public book(int id , String title) {
        this.id = id;
        this.title = title;
    }
}