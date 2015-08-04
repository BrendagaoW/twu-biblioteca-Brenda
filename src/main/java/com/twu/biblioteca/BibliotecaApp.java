package com.twu.biblioteca;

import org.mockito.internal.matchers.Null;

import java.awt.print.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    private PrintStream printStream;
    private BufferedReader reader;
    private Menu menu;

    public BibliotecaApp(PrintStream printStream, BufferedReader reader, Menu menu) {
        this.printStream = printStream;
        this.reader = reader;
        this.menu = menu;
    }

    public BibliotecaApp(PrintStream printStream) {
        this.printStream = printStream;
    }

    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }

    public void start() {
        printStream.println("Welcome!");
        menu.displayMenu();
        menu.selectOption();
    }

}
