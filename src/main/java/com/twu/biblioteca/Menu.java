package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class Menu {
    private List<Command> commands;
    private PrintStream printStream;

    public Menu(List<Command> commands, PrintStream printStream) {
        this.commands = commands;
        this.printStream = printStream;
    }

    public void displayMenu() {
        for (Command command : commands) {
            printStream.println(command);
        }
    }
}
