package com.twu.biblioteca;

import com.twu.biblioteca.Commands.*;
import com.twu.biblioteca.Resources.Book;
import com.twu.biblioteca.Resources.Movie;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BibliotecaApp {

    private PrintStream printStream;
    private BufferedReader reader;
    private Menu menu;

    public BibliotecaApp(PrintStream printStream, BufferedReader reader, Menu menu) {
        this.printStream = printStream;
        this.reader = reader;
        this.menu = menu;
    }

    public void start() {
        printStream.println("Welcome!");
        menu.selectOption();
    }

    public static void main(String [] args) {
        PrintStream printStream = System.out;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Menu menu = getMenu(printStream, reader);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(printStream, reader, menu);
        bibliotecaApp.start();
    }

    private static Menu getMenu(PrintStream printStream, BufferedReader reader) {
        Library bookLibrary = getBookLibrary();

        Library movieLibrary = getMovieLibrary();

        List<UserAccount> userAccounts = getUserAccounts();

        Login login = new Login(userAccounts, printStream, reader);

        Map<String, Command> commandMap = getStringCommandMap(printStream, reader, bookLibrary, movieLibrary, login);

        return new Menu(commandMap, printStream, reader);
    }

    private static Library getMovieLibrary() {
        Resource movie1 = new Movie("movie1", 2000, "m1", 1);
        Resource movie2 = new Movie("movie2", 2000, "m2", 2);
        Resource movie3 = new Movie("movie3", 2000, "m3", 3);
        Resource movie4 = new Movie("movie4", 2000, "m4", 4);
        List<Resource> movieListIn = new ArrayList<Resource>();
        List<Resource> movieListOut = new ArrayList<Resource>();
        movieListIn.add(movie1);
        movieListIn.add(movie2);
        movieListOut.add(movie3);
        movieListOut.add(movie4);

        return new Library(movieListIn, movieListOut);
    }

    private static Library getBookLibrary() {
        Resource book1 = new Book("book1", "b1", 1990);
        Resource book2 = new Book("book2", "b2", 1990);
        List<Resource> bookListIn = new ArrayList<Resource>();
        bookListIn.add(book1);
        bookListIn.add(book2);
        Resource book3 = new Book("book3", "b3", 1990);
        Resource book4 = new Book("book4", "b4", 1990);
        List<Resource> bookListOut = new ArrayList<Resource>();
        bookListOut.add(book3);
        bookListOut.add(book4);

        return new Library(bookListIn, bookListOut);
    }

    private static Map<String, Command> getStringCommandMap(PrintStream printStream, BufferedReader reader, Library bookLibrary, Library movieLibrary, Login login) {
        Map<String, Command> commandMap = new HashMap<String, Command>();
        commandMap.put("CB", new CheckoutCommand("Checkout Books", printStream, reader, bookLibrary, login));
        commandMap.put("CM", new CheckoutCommand("Checkout Movies", printStream, reader, movieLibrary, login));
        commandMap.put("LB", new ListCommand("List Books", printStream, bookLibrary));
        commandMap.put("LM", new ListCommand("List Movies", printStream, movieLibrary));
        commandMap.put("Q", new QuitCommand(printStream));
        commandMap.put("RB", new ReturnCommand("Return Books", printStream, reader, bookLibrary));
        commandMap.put("RM", new ReturnCommand("Return Movies", printStream, reader, movieLibrary));
        commandMap.put("S", new ScanInformationCommand("Scan Personal Information", printStream, login));
        return commandMap;
    }

    private static List<UserAccount> getUserAccounts() {
        UserAccount user1 = new UserAccount("111-0001", "abc", "Brenda", "lfgao@tw.com", "12345678901");
        UserAccount user2 = new UserAccount("111-0002", "abc", "John", "lfgao@tw.com", "12345678901");
        UserAccount user3 = new UserAccount("111-0003", "aba", "Tom", "lfgao@tw.com", "12345678901");
        List<UserAccount> userAccounts = new ArrayList<UserAccount>();
        userAccounts.add(user1);
        userAccounts.add(user2);
        userAccounts.add(user3);
        return userAccounts;
    }

}
