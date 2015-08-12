package com.twu.biblioteca.Commands;

import com.twu.biblioteca.Command;
import com.twu.biblioteca.Login;
import com.twu.biblioteca.UserAccount;

import java.io.IOException;
import java.io.PrintStream;

public class ScanInformationCommand extends Command {

    private Login login;

    public ScanInformationCommand(String optionName, PrintStream printStream, Login login) {
        super(optionName, printStream);
        this.login = login;
    }

    @Override
    public void execute() {
        try {
            UserAccount userAccount = login.getUser();
            if (userAccount == null) {
                getPrintStream().println("Please login!");
                return;
            }
            getPrintStream().println(userAccount.getDetail());

        } catch (NullPointerException e) {
            getPrintStream().println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
