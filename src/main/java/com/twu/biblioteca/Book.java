package com.twu.biblioteca;

public class Book {

    private String title;
    private String author;
    private int year;

    public Book(String title) {
        this.title = title;
    }

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public Book(Book book) {
        this.title = book.title;
        this.author = book.author;
        this.year = book.year;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!title.equals(book.title)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }

    public String getDetail() {
        return title + "\t" + author + "\t" + year;
    }
}
