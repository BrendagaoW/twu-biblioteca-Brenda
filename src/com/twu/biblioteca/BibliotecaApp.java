package com.twu.biblioteca;

import java.io.PrintStream;

public class BibliotecaApp {

    private PrintStream printStream;

    public BibliotecaApp(PrintStream printStream) {
        this.printStream = printStream;
    }

    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }

    public void start() {
        printStream.println("Welcome!");

    }
}
