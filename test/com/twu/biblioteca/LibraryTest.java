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
        Resource book1 = new Book("1");
        Resource book2 = new Book("2");
        Resource book3 = new Book("3");
        Resource book4 = new Book("4");
        List<Resource> inList = new ArrayList<Resource>();
        List<Resource> outList = new ArrayList<Resource>();
        inList.add(book1);
        inList.add(book2);
        outList.add(book3);
        outList.add(book4);
        library = new Library(inList, outList);
    }

    @Test
    public void testContains() throws Exception {
        Resource book1 = new Book("1");
        Resource book3 = new Book("3");

        assertFalse(library.checkoutContains(book1));
        assertTrue(library.remainContains(book1));
        assertFalse(library.remainContains(book3));
        assertTrue(library.checkoutContains(book3));

    }

    @Test
    public void testCheckout() throws Exception {
        Book book = new Book("1");
        library.checkout(book);
        assertFalse(library.remainContains(book));
        assertTrue(library.checkoutContains(book));

        try {
            library.checkout(new Book("4"));
            fail();
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("That book is not available."));
        }
    }

    @Test
    public void testReturnBook() throws Exception {
        Book book = new Book("3");
        library.returnResource(book);
        assertTrue(library.remainContains(book));
        assertFalse(library.checkoutContains(book));

        try {
            library.returnResource(new Book("1"));
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("That is not a valid book to return.", e.getMessage());
        }
    }

    @Test
    public void testCheckoutAndReturn() throws Exception {

        Book book = new Book("1");
        assertTrue(library.remainContains(book));
        assertFalse(library.checkoutContains(book));
        library.checkout(book);
        assertFalse(library.remainContains(book));
        assertTrue(library.checkoutContains(book));
        library.returnResource(book);
        assertTrue(library.remainContains(book));
        assertFalse(library.checkoutContains(book));

    }
}