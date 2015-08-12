package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BibliotecaAppTest {

    private PrintStream printStream;
    private BibliotecaApp bibliotecaApp;
    private BufferedReader reader;
    private Menu menu;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        menu = mock(Menu.class);
        bibliotecaApp = new BibliotecaApp(printStream, reader, menu);
    }

    @Test
    public void shouldPrintWelcomeMessage() {
        bibliotecaApp.start();
        verify(printStream).println("Welcome!");
    }


    @Test
    public void shouldSelectOption() throws Exception {
        bibliotecaApp.start();
        verify(menu).selectOption();
    }

}