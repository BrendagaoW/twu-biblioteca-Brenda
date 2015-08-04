package com.twu.biblioteca;

import java.io.IOException;
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

    public void checkout(Book book) throws InforException {
        Book tempBook;
        for (Book b : booksInLibrary) {
            if (b.equals(book)) {
                tempBook = new Book(b);
                booksInLibrary.remove(b);
                booksOutOfLibrary.add(tempBook);
                return;
            }
        }
        InforException exception = new InforException();
        exception.setExceptionMessage("That book is not available.");
        throw exception;
    }

    public void returnBook(Book book) throws InforException {
        Book tempBook;
        for (Book b : booksOutOfLibrary) {
            if (b.equals(book)) {
                tempBook = new Book(b);
                booksOutOfLibrary.remove(b);
                booksInLibrary.add(tempBook);
                return;
            }
        }
        InforException exception = new InforException();
        exception.setExceptionMessage("That is not a valid book to return.");
        throw exception;
    }
}
