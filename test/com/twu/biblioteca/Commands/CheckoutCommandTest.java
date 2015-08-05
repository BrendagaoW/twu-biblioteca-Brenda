package com.twu.biblioteca.Commands;

import com.twu.biblioteca.Login;
import com.twu.biblioteca.Resource;
import com.twu.biblioteca.Resources.Book;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.UserAccount;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.InstanceOf;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class CheckoutCommandTest {

    private PrintStream printStream;
    private CheckoutCommand checkoutCommand;
    private BufferedReader reader;
    private Library library;
    private Login login;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        login = mock(Login.class);
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
        checkoutCommand = new CheckoutCommand("Checkout Book", printStream, reader, library, login);
    }

    @Test
    public void testExecute() throws Exception {
        when(login.login()).thenReturn(mock(UserAccount.class));
        checkoutCommand.execute();
        verify(printStream).println("Print the book name which you want to checkout:");

        when(reader.readLine()).thenReturn("1");
        checkoutCommand.execute();
        assertTrue(library.checkoutContains("1"));
        assertFalse(library.remainContains("1"));
    }

    @Test
    public void testSuccessful() throws Exception {
        when(login.login()).thenReturn(mock(UserAccount.class));
        when(reader.readLine()).thenReturn("1");
        checkoutCommand.execute();
        verify(printStream).println("Thank you! Enjoy the book");
    }

    @Test
    public void testUnsuccessful() throws Exception {
        when(login.login()).thenReturn(mock(UserAccount.class));
        when(reader.readLine()).thenReturn("3");
        checkoutCommand.execute();
        verify(printStream).println("That book is not available.");
    }
}