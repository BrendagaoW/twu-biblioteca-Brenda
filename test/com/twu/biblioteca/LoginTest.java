package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LoginTest {

    private Login login;

    @Before
    public void setUp() throws Exception {

        UserAccount user1 = new UserAccount("111-2222", "abc");
        UserAccount user2 = new UserAccount("333-2222", "abc");
        UserAccount user3 = new UserAccount("555-2222", "abc");
        List<UserAccount> userAccounts = new ArrayList<UserAccount>();
        userAccounts.add(user1);
        userAccounts.add(user2);
        userAccounts.add(user3);
        login = new Login(userAccounts);
    }

    @Test
    public void testVerifyUser() throws Exception {
        UserAccount user1 = new UserAccount("111-2222", "abc");

        assertEquals(user1, login.verifyUser("111-2222", "abc"));

        try {
            login.verifyUser("111-2223", "abc");
            fail();
        } catch (NullPointerException e) {
            assertEquals("Your library number or password is wrong!", e.getMessage());
        }

    }
}