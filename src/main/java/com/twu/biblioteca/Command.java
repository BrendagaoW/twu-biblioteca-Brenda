package com.twu.biblioteca;

import java.io.PrintStream;

public abstract class Command {
    private String optionName;
    private PrintStream printStream;

    public Command(String optionName, PrintStream printStream) {
        this.optionName = optionName;
        this.printStream = printStream;
    }

    public PrintStream getPrintStream() {
        return printStream;
    }

    public String getOptionName() {
        return optionName;
    }

    public abstract void execute();
}
