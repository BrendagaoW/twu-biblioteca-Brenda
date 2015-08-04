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

    public BibliotecaApp(PrintStream printStream, BufferedReader reader) {
        this.printStream = printStream;
        this.reader = reader;
    }

    public BibliotecaApp(PrintStream printStream) {
        this.printStream = printStream;
    }

    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }

    public void start() {
        printStream.println("Welcome!");

    }

    public List<Book> getBookList() {
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book("Test-Driven Development", "Kent", 2002));
        bookList.add(new Book("Code Smell", "Anybody", 2010));

        return bookList;
    }

    public void showMenu() {
        printStream.println("List Books");

        try {
            if ((reader.readLine()) == "l") {
                printStream.println("Select a valid option!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
