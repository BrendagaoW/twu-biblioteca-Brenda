package com.twu.biblioteca.Commands;

import com.twu.biblioteca.Resource;
import com.twu.biblioteca.Resources.Book;
import com.twu.biblioteca.Library;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListCommandTest {

    private PrintStream printStream;
    private ListCommand listCommand;
    private Library library;

    @Before
    public void setUp() throws Exception {
        Resource book1 = new Book("1");
        Resource book2 = new Book("Test-Driven Development", "Kent", 2002);
        Resource book3 = new Book("3");
        Resource book4 = new Book("4");
        List<Resource> inList = new ArrayList<Resource>();
        List<Resource> outList = new ArrayList<Resource>();
        inList.add(book1);
        inList.add(book2);
        outList.add(book3);
        outList.add(book4);
        library = new Library(inList, outList);

        printStream = mock(PrintStream.class);
        listCommand = new ListCommand("List Books", printStream, library);

    }

    @Test
    public void testExecute() throws Exception {
        listCommand.execute();
        String detail = "Test-Driven Development" + "\t" + "Kent" + "\t" + 2002;
        verify(printStream).println(detail);
    }
}