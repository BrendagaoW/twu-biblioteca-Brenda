package com.twu.biblioteca;

import java.util.List;

public class Login {
    private List<UserAccount> userAccounts;

    public Login(List<UserAccount> userAccounts) {
        this.userAccounts = userAccounts;
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
