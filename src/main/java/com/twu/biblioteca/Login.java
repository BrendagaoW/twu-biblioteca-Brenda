package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class Login {
    private List<UserAccount> userAccounts;
    private PrintStream printStream;
    private BufferedReader reader;

    public Login(List<UserAccount> userAccounts, PrintStream printStream, BufferedReader reader) {
        this.userAccounts = userAccounts;
        this.printStream = printStream;
        this.reader = reader;
    }

    public UserAccount login() throws IOException {
        printStream.println("Please input your library number:");
        String userNumber = reader.readLine();
        printStream.println("Please inout your password:");
        String password = reader.readLine();

        return verifyUser(userNumber, password);
    }

    public UserAccount verifyUser(String userNumber, String password) {
        UserAccount user = new UserAccount(userNumber, password);

        for (UserAccount userAccount : userAccounts) {
            if (userAccount.verify(user)) {
                return userAccount;
            }
        }

        throw new NullPointerException("Your library number or password is wrong!");
    }
}
