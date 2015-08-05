package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.PrintStream;

public class BibliotecaApp {

    private PrintStream printStream;
    private BufferedReader reader;
    private Menu menu;

    public BibliotecaApp(PrintStream printStream, BufferedReader reader, Menu menu) {
        this.printStream = printStream;
        this.reader = reader;
        this.menu = menu;
    }

    public void start() {
        printStream.println("Welcome!");
        menu.displayMenu();
        menu.selectOption();
    }

}
