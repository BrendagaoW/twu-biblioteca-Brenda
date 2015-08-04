package com.twu.biblioteca;

public abstract class Command {
    private String optionName;

    public Command(String optionName) {
        this.optionName = optionName;
    }

    @Override
    public String toString() {
        return optionName;
    }

    public abstract void execute();
}
