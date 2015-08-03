package com.twu.biblioteca;

import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BibliotecaAppTest {

    private PrintStream printStream;

    @Test
    public void printWelcomeMessage() {
        printStream = mock(PrintStream.class);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(printStream);
        bibliotecaApp.start();

        verify(printStream).println("Welcome!");
    }

}