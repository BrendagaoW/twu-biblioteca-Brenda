package com.twu.biblioteca.Commands;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Command;
import com.twu.biblioteca.Library;

import java.io.PrintStream;

public class ListCommand extends Command {

    private Library library;

    public ListCommand(PrintStream printStream, Library library) {
        super("List Books", printStream);
        this.library = library;
    }

    @Override
    public void execute() {

        for (Book book : library.getBooksInLibrary()) {
            getPrintStream().println(book.getDetail());
        }
    }
}
