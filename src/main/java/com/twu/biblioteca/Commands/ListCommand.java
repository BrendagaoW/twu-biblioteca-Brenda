package com.twu.biblioteca.Commands;

import com.twu.biblioteca.Resources.Book;
import com.twu.biblioteca.Command;
import com.twu.biblioteca.Library;

import java.io.PrintStream;

public class ListCommand extends Command {

    private Library library;

    public ListCommand(String listKinds, PrintStream printStream, Library library) {
        super(listKinds, printStream);
        this.library = library;
    }

    @Override
    public void execute() {

        for (Book resource : library.getResourceInLibrary()) {
            getPrintStream().println(resource.getDetail());
        }
    }
}
