package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

public class Menu {
    private Map<String, Command> commands;
    private PrintStream printStream;
    private BufferedReader reader;

    public Menu(Map<String, Command> commands, PrintStream printStream, BufferedReader reader) {
        this.commands = commands;
        this.printStream = printStream;
        this.reader = reader;
    }


    public void displayMenu() {
        for (String commandID : commands.keySet()) {
            printStream.println(commandID + ":" + commands.get(commandID));
        }
    }

    public void selectOption() {
        try {
            String option = reader.readLine();
            commands.get(option).execute();
        } catch (NullPointerException e) {
            printStream.println("Select a valid option!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
