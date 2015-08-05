package com.twu.biblioteca.Commands;

import com.twu.biblioteca.Command;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.Login;
import com.twu.biblioteca.Resources.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class CheckoutCommand extends Command {

    private BufferedReader reader;
    private Library library;
    private Login login;

    public CheckoutCommand(String resourceKind, PrintStream printStream, BufferedReader reader, Library library, Login login) {
        super(resourceKind, printStream);
        this.reader = reader;
        this.library = library;
        this.login = login;
    }

    @Override
    public void execute() {

        try {
            if (login.login() == null) {
                getPrintStream().println("Please login!");
                return;
            }
            getPrintStream().println("Print the book name which you want to checkout:");
            String checkoutBook = reader.readLine();
            library.checkout(new Book(checkoutBook));
            getPrintStream().println("Thank you! Enjoy the book");
        } catch (NullPointerException e) {
            getPrintStream().println(e.getMessage());
        } catch (IllegalArgumentException e) {
            getPrintStream().println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
