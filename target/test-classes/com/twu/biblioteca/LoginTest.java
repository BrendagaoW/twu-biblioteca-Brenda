package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;
import static org.mockito.Matchers.isNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LoginTest {

    private Login login;
    private PrintStream printStream;
    private BufferedReader reader;

    @Before
    public void setUp() throws Exception {

        UserAccount user1 = new UserAccount("111-2222", "abc");
        UserAccount user2 = new UserAccount("333-2222", "abc");
        UserAccount user3 = new UserAccount("555-2222", "abc");
        List<UserAccount> userAccounts = new ArrayList<UserAccount>();
        userAccounts.add(user1);
        userAccounts.add(user2);
        userAccounts.add(user3);

        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        login = new Login(userAccounts, printStream, reader);
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

    @Test
    public void testLogin() throws Exception {
        UserAccount user1 = new UserAccount("111-2222", "abc");
        String goodName = "111-2222";
        String goodPass = "abc";

        printStream.println("Please input your library number:");
        when(reader.readLine()).thenReturn(goodName, goodPass);
        printStream.println("Please input your library number:");

        UserAccount user = login.login();
        assertEquals(user1, user);

    }
}