package com.twu.biblioteca;

import com.twu.biblioteca.Commands.CheckoutCommand;
import com.twu.biblioteca.Commands.ListCommand;
import com.twu.biblioteca.Commands.QuitCommand;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MenuTest {

    private Menu menu;
    private PrintStream printStream;
    private BufferedReader reader;
    private Command commandList;
    private Command commandQuit;
    Map<String, Command> commands;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        commandList = mock(ListCommand.class);
        commandQuit = mock(QuitCommand.class);
        commands = new HashMap<String, Command>();
        commands.put("L", commandList);
        commands.put("Q", commandQuit);
        menu = new Menu(commands, printStream, reader);


    }

    @Test
    public void shouldDisplayMenu() throws Exception {

        Library library = mock(Library.class);
        Command commandCheckout = new CheckoutCommand(printStream, reader, library);
        menu.addCommand("C",commandCheckout);
        menu.displayMenu();
        verify(printStream).println("C:Checkout Book");
    }

    @Test
    public void shouldSelectOption() throws Exception {
        when(reader.readLine()).thenReturn("L");
        menu.selectOption();
        verify(commandList).execute();

        when(reader.readLine()).thenReturn("Q");
        menu.selectOption();
        verify(commandQuit).execute();

        when(reader.readLine()).thenReturn("K");
        menu.selectOption();
        verify(printStream).println("Select a valid option!");
    }
}