package com.twu.biblioteca.Commands;

import com.twu.biblioteca.Command;

import java.io.PrintStream;

public class QuitCommand extends Command {


    public QuitCommand(PrintStream printStream) {
        super("Quit", printStream);
    }

    @Override
    public void execute() {
        getPrintStream().println("Quit!");
    }
}
