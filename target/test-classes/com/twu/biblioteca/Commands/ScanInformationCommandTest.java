package com.twu.biblioteca.Commands;

import com.twu.biblioteca.Login;
import com.twu.biblioteca.UserAccount;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockingDetails;
import static org.mockito.Mockito.when;

public class ScanInformationCommandTest {
    private PrintStream printStream;
    private Login login;
    private ScanInformationCommand scanInformationCommand;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        login = mock(Login.class);

        scanInformationCommand = new ScanInformationCommand("Scan personal Information", printStream, login);
    }

    @Test
    public void testExecute() throws Exception {

        UserAccount userAccount = new UserAccount("111-2222", "abc", "Brenda", "brendagao.lf@gmail.com", "1111111");
        when(login.login()).thenReturn(userAccount);

        scanInformationCommand.execute();

        printStream.println("Brenda" +"\t"+ "brendagao.lf@gmail.com"+"\t"+"1111111");
    }
}