package com.twu.biblioteca;

import java.util.List;

public class Library {

    private List<Book> booksInLibrary;
    private List<Book> booksOutOfLibrary;

    public Library(List<Book> booksInLibrary, List<Book> booksOutOfLibrary) {
        this.booksInLibrary = booksInLibrary;
        this.booksOutOfLibrary = booksOutOfLibrary;
    }

    public boolean checkoutContains(String checkoutBook) {
        return booksOutOfLibrary.contains(new Book(checkoutBook));
    }

    public boolean remainContains(String remainBook) {
        return booksInLibrary.contains(new Book(remainBook));
    }

    public void checkout(Book book) throws IllegalArgumentException {
        Book tempBook;
        for (Book b : booksInLibrary) {
            if (b.equals(book)) {
                tempBook = new Book(b);
                booksInLibrary.remove(b);
                booksOutOfLibrary.add(tempBook);
                return;
            }
        }

        throw new IllegalArgumentException("That book is not available.");
    }

    public void returnBook(Book book) throws IllegalArgumentException {
        Book tempBook;

        for (Book b : booksOutOfLibrary) {
            if (b.equals(book)) {
                tempBook = new Book(b);
                booksOutOfLibrary.remove(b);
                booksInLibrary.add(tempBook);
                return;
            }
        }

        throw new IllegalArgumentException("That is not a valid book to return.");
    }

    public List<Book> getBooksInLibrary() {
        return booksInLibrary;
    }

    public List<Book> getBooksOutOfLibrary() {
        return booksOutOfLibrary;
    }
}
