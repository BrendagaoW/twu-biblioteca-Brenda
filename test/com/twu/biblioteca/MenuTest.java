package com.twu.biblioteca;

import com.twu.biblioteca.Commands.ListCommand;
import com.twu.biblioteca.Commands.QuitCommand;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuTest {

    private Menu menu;
    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        Command commandList = new ListCommand();
        Command commandQuit = new QuitCommand();
        List<Command> commands = new ArrayList<Command>();
        commands.add(commandList);
        commands.add(commandQuit);
        menu = new Menu(commands, printStream);

    }

    @Test
    public void shouldDisplayMenu() throws Exception {
        menu.displayMenu();
        verify(printStream).println("L:List Books");
        verify(printStream).println("Q:Quit");

    }
}