package com.twu.biblioteca.Resources;

public class Book extends com.twu.biblioteca.Resource {

    private String author;

    public Book(String title) {
        super(title);
    }

    public Book(String title, String author, int year) {
        super(title, year);
        this.author = author;
    }

    public Book(Book book) {
        super(book.getName(), book.getYear());
        this.author = book.author;
    }

    public String getDetail() {
        return getName() + "\t" + author + "\t" + getYear();
    }
}
