package com.twu.biblioteca;

import com.twu.biblioteca.Commands.ListCommand;
import com.twu.biblioteca.Commands.QuitCommand;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    Map<String, Command> commands;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        commandList = mock(ListCommand.class);
        Command commandQuit = new QuitCommand();
        commands = new HashMap<String, Command>();
        commands.put("L", commandList);
        commands.put("Q", commandQuit);
        menu = new Menu(commands, printStream, reader);


    }

    @Test
    public void shouldDisplayMenu() throws Exception {
        menu.displayMenu();
        verify(printStream).println("Q:Quit");
    }

    @Test
    public void shouldSelectOption() throws Exception {
        String answer = "L";
        when(reader.readLine()).thenReturn(answer);
        assertTrue(commands.containsKey(answer));
        menu.selectOption();
        verify(commandList).execute();

        when(reader.readLine()).thenReturn("K");
        menu.selectOption();
        verify(printStream).println("Select a valid option!");
    }
}