package com.twu.biblioteca.Commands;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Command;
import com.twu.biblioteca.InforException;
import com.twu.biblioteca.Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class ReturnCommand extends Command {

    private BufferedReader reader;
    private Library library;

    public ReturnCommand(PrintStream printStream, BufferedReader reader, Library library) {
        super("Return Book", printStream);
        this.reader = reader;
        this.library = library;
    }

    @Override
    public void execute() {
        getPrintStream().println("Print the book name which you want to return:");
        try {
            String checkoutBook = reader.readLine();
            library.returnBook(new Book(checkoutBook));
            getPrintStream().println("Thank you for returning the book.");
        } catch (InforException e) {
            getPrintStream().println(e.getExceptionMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
