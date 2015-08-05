package com.twu.biblioteca.Commands;

import com.twu.biblioteca.Resources.Book;
import com.twu.biblioteca.Command;
import com.twu.biblioteca.Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class CheckoutCommand extends Command {

    private BufferedReader reader;
    private Library library;

    public CheckoutCommand(PrintStream printStream, BufferedReader reader, Library library) {
        super("Checkout Book", printStream);
        this.reader = reader;
        this.library = library;
    }

    @Override
    public void execute() {

        getPrintStream().println("Print the book name which you want to checkout:");
        try {
            String checkoutBook = reader.readLine();
            library.checkout(new Book(checkoutBook));
            getPrintStream().println("Thank you! Enjoy the book");
        } catch (IllegalArgumentException e) {
            getPrintStream().println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
