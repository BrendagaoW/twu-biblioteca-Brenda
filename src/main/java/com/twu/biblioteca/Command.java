package com.twu.biblioteca;

public abstract class Command {
    private String optionNumber;
    private String optionName;

    public Command(String optionNumber, String optionName) {
        this.optionNumber = optionNumber;
        this.optionName = optionName;
    }

    @Override
    public String toString() {
        return optionNumber + ":" + optionName;
    }

    public abstract void execute();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Command command = (Command) o;

        if (optionNumber != null ? !optionNumber.equals(command.optionNumber) : command.optionNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return optionNumber != null ? optionNumber.hashCode() : 0;
    }
}
