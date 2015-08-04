package com.twu.biblioteca.Commands;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListCommandTest {

    private PrintStream printStream;
    private ListCommand listCommand;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        listCommand = new ListCommand(printStream);

    }

    @Test
    public void testExecute() throws Exception {
        listCommand.execute();
        printStream.println();
        String detail = "Test-Driven Development" + "\t" + "Kent" + "\t" + 2002;
        verify(printStream).println(detail);
    }
}