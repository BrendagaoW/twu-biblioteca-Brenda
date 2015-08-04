package com.twu.biblioteca.Commands;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Command;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ListCommand extends Command {

    private PrintStream printStream;

    public ListCommand() {
        super("List Books");
    }

    @Override
    public void execute() {
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book("Test-Driven Development", "Kent", 2002));
        bookList.add(new Book("Code Smell", "Anybody", 2010));

        for (Book book : bookList) {
            printStream.println(book.showDetail());
        }
    }
}
