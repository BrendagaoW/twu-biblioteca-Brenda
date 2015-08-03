package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BibliotecaAppTest {

    private PrintStream printStream;
    private BibliotecaApp bibliotecaApp;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bibliotecaApp = new BibliotecaApp(printStream);
    }

    @Test
    public void shouldPrintWelcomeMessage() {
        bibliotecaApp.start();
        verify(printStream).println("Welcome!");
    }

    @Test
    public void shouldListAllBooks() throws Exception {

        Book book1 = new Book("Test-Driven Development");
        Book book2 = new Book("Code Smell");
        Book book3 = new Book("Code Smell~");

        assertEquals(2, bibliotecaApp.getBookList().size());
        assertThat(bibliotecaApp.getBookList(), hasItem(book1));
        assertThat(bibliotecaApp.getBookList(), not(hasItem(book3)));
        assertEquals(book2, bibliotecaApp.getBookList().get(1));
    }
}