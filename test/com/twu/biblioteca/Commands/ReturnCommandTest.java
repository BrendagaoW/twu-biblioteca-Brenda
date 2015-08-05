package com.twu.biblioteca.Commands;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Library;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ReturnCommandTest {

    private PrintStream printStream;
    private ReturnCommand returnCommand;
    private BufferedReader reader;
    private Library library;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
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
        returnCommand = new ReturnCommand(printStream, reader, library);
    }

    @Test
    public void testExecute() throws Exception {


        returnCommand.execute();
        verify(printStream).println("Print the book name which you want to return:");

        when(reader.readLine()).thenReturn("3");
        returnCommand.execute();
        assertTrue(library.remainContains("3"));
        assertFalse(library.checkoutContains("3"));
    }

    @Test
    public void testSuccessful() throws Exception {
        when(reader.readLine()).thenReturn("3");
        returnCommand.execute();
        verify(printStream).println("Thank you for returning the book.");
    }

    @Test
    public void testUnsuccessful() throws Exception {
        when(reader.readLine()).thenReturn("1");

        returnCommand.execute();
        verify(printStream).println("That is not a valid book to return.");
    }
}