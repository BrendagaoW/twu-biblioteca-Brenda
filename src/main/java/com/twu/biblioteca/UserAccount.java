package com.twu.biblioteca;

public class UserAccount {
    private String userNumber;
    private String password;
    private String email;
    private String phoneNumber;

    public UserAccount(String userNumber, String password, String email, String phoneNumber) {
        this.userNumber = userNumber;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public UserAccount(String userNumber, String password) {
        this.userNumber = userNumber;
        this.password = password;
    }

    public boolean verify(UserAccount user) {
        return this.password.equals(password) && this.userNumber.equals(user.userNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAccount that = (UserAccount) o;

        if (userNumber != null ? !userNumber.equals(that.userNumber) : that.userNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return userNumber != null ? userNumber.hashCode() : 0;
    }
}
