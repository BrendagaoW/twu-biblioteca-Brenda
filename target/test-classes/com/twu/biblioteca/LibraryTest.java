package com.twu.biblioteca;

import com.twu.biblioteca.Resources.Book;
import com.twu.biblioteca.Resources.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LibraryTest {

    private Library bookLibrary;
    private Library movieLibrary;

    @Before
    public void setUp() throws Exception {
        Resource book1 = new Book("1");
        Resource book2 = new Book("2");
        Resource book3 = new Book("3");
        Resource book4 = new Book("4");
        List<Resource> bookinList = new ArrayList<Resource>();
        List<Resource> bookoutList = new ArrayList<Resource>();
        bookinList.add(book1);
        bookinList.add(book2);
        bookoutList.add(book3);
        bookoutList.add(book4);
        bookLibrary = new Library(bookinList, bookoutList);

        Resource movie1 = new Movie("1");
        Resource movie2 = new Movie("2");
        Resource movie3 = new Movie("3");
        Resource movie4 = new Movie("4");
        List<Resource> movieinList = new ArrayList<Resource>();
        List<Resource> movieoutList = new ArrayList<Resource>();
        movieinList.add(movie1);
        movieinList.add(movie2);
        movieoutList.add(movie3);
        movieoutList.add(movie4);
        movieLibrary = new Library(movieinList, movieoutList);
    }

    @Test
    public void testContains() throws Exception {
        Resource book1 = new Book("1");
        Resource book3 = new Book("3");

        assertFalse(bookLibrary.checkoutContains(book1));
        assertTrue(bookLibrary.remainContains(book1));
        assertFalse(bookLibrary.remainContains(book3));
        assertTrue(bookLibrary.checkoutContains(book3));

        
        Resource movie1 = new Movie("1");
        Resource movie3 = new Movie("3");

        assertFalse(movieLibrary.checkoutContains(movie1));
        assertTrue(movieLibrary.remainContains(movie1));
        assertFalse(movieLibrary.remainContains(movie3));
        assertTrue(movieLibrary.checkoutContains(movie3));

    }

    @Test
    public void testCheckout() throws Exception {
        Book book = new Book("1");
        bookLibrary.checkout(book);
        assertFalse(bookLibrary.remainContains(book));
        assertTrue(bookLibrary.checkoutContains(book));

        try {
            bookLibrary.checkout(new Book("4"));
            fail();
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("That book is not available."));
        }
    }

    @Test
    public void testCheckoutMovie() throws Exception {
        Movie movie = new Movie("1");
        movieLibrary.checkout(movie);
        assertFalse(movieLibrary.remainContains(movie));
        assertTrue(movieLibrary.checkoutContains(movie));

        try {
            movieLibrary.checkout(new Movie("4"));
            fail();
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("That movie is not available."));
        }

    }

    @Test
    public void testReturnBook() throws Exception {
        Book book = new Book("3");
        bookLibrary.returnResource(book);
        assertTrue(bookLibrary.remainContains(book));
        assertFalse(bookLibrary.checkoutContains(book));

        try {
            bookLibrary.returnResource(new Book("1"));
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("That is not a valid book to return.", e.getMessage());
        }
    }

    @Test
    public void testReturnMovie() throws Exception {
        Movie movie = new Movie("3");
        movieLibrary.returnResource(movie);
        assertTrue(movieLibrary.remainContains(movie));
        assertFalse(movieLibrary.checkoutContains(movie));

        try {
            movieLibrary.returnResource(new Movie("1"));
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("That is not a valid movie to return.", e.getMessage());
        }

    }

    @Test
    public void testCheckoutAndReturn() throws Exception {

        Book book = new Book("1");
        assertTrue(bookLibrary.remainContains(book));
        assertFalse(bookLibrary.checkoutContains(book));
        bookLibrary.checkout(book);
        assertFalse(bookLibrary.remainContains(book));
        assertTrue(bookLibrary.checkoutContains(book));
        bookLibrary.returnResource(book);
        assertTrue(bookLibrary.remainContains(book));
        assertFalse(bookLibrary.checkoutContains(book));


        Movie movie = new Movie("1");
        assertTrue(movieLibrary.remainContains(movie));
        assertFalse(movieLibrary.checkoutContains(movie));
        movieLibrary.checkout(movie);
        assertFalse(movieLibrary.remainContains(movie));
        assertTrue(movieLibrary.checkoutContains(movie));
        movieLibrary.returnResource(movie);
        assertTrue(movieLibrary.remainContains(movie));
        assertFalse(movieLibrary.checkoutContains(movie));

    }
}