package com.twu.biblioteca;

import com.twu.biblioteca.Resources.Book;

import java.util.List;

public class Library {

    private List<Book> resourceInLibrary;
    private List<Book> resourceOutOfLibrary;

    public Library(List<Book> resourceInLibrary, List<Book> resourceOutOfLibrary) {
        this.resourceInLibrary = resourceInLibrary;
        this.resourceOutOfLibrary = resourceOutOfLibrary;
    }

    public boolean checkoutContains(String checkoutBook) {
        return resourceOutOfLibrary.contains(new Book(checkoutBook));
    }

    public boolean remainContains(String remainResource) {
        return resourceInLibrary.contains(new Book(remainResource));
    }

    public void checkout(Book resource) throws IllegalArgumentException {
        Book tempResource;
        for (Book b : resourceInLibrary) {
            if (b.equals(resource)) {
                tempResource = new Book(b);
                resourceInLibrary.remove(b);
                resourceOutOfLibrary.add(tempResource);
                return;
            }
        }

        String resourceClass = resource.getClass().getSimpleName().toLowerCase();
        throw new IllegalArgumentException("That " + resourceClass + " is not available.");
    }

    public void returnResource(Book resource) throws IllegalArgumentException {
        Book tempResource;

        for (Book b : resourceOutOfLibrary) {
            if (b.equals(resource)) {
                tempResource = new Book(b);
                resourceOutOfLibrary.remove(b);
                resourceInLibrary.add(tempResource);
                return;
            }
        }

        String resourceClass = resource.getClass().getSimpleName().toLowerCase();
        throw new IllegalArgumentException("That is not a valid " + resourceClass + " to return.");
    }

    public List<Book> getResourceInLibrary() {
        return resourceInLibrary;
    }

    public List<Book> getResourceOutOfLibrary() {
        return resourceOutOfLibrary;
    }
}
