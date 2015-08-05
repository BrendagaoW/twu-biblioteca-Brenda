package com.twu.biblioteca;

import com.twu.biblioteca.Resources.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LibraryTest {

    private Library library;

    @Before
    public void setUp() throws Exception {
        Book book1 = new Book("1");
        Book book2 = new Book("2");
        Book book3 = new Book("3");
        Book book4 = new Book("4");
        List<Book> inList = new ArrayList<Book>();
        List<Book> outList = new ArrayList<Book>();
        inList.add(book1);
        inList.add(book2);
        outList.add(book3);
        outList.add(book4);
        library = new Library(inList, outList);
    }

    @Test
    public void testCheckoutContains() throws Exception {
        assertTrue(library.checkoutContains("3"));
        assertFalse(library.checkoutContains("1"));
    }

    @Test
    public void testRemainContains() throws Exception {
        assertTrue(library.remainContains("1"));
        assertFalse(library.remainContains("3"));
    }

    @Test
    public void testCheckout() throws Exception {
        library.checkout(new Book("1"));
        assertFalse(library.remainContains("1"));
        assertTrue(library.checkoutContains("1"));

        try {
            library.checkout(new Book("4"));
            fail();
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("That book is not available."));
        }
    }

    @Test
    public void testReturnBook() throws Exception {
        library.returnResource(new Book("3"));
        assertTrue(library.remainContains("3"));
        assertFalse(library.checkoutContains("3"));

        try {
            library.returnResource(new Book("1"));
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("That is not a valid book to return.", e.getMessage());
        }
    }

}