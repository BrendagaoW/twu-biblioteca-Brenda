package com.twu.biblioteca;

import com.twu.biblioteca.Resources.Book;

import java.util.List;

public class Library {

    private List<Resource> resourceInLibrary;
    private List<Resource> resourceOutOfLibrary;

    public Library(List<Resource> resourceInLibrary, List<Resource> resourceOutOfLibrary) {
        this.resourceInLibrary = resourceInLibrary;
        this.resourceOutOfLibrary = resourceOutOfLibrary;
    }

    public boolean checkoutContains(String checkoutResource) {
        return resourceOutOfLibrary.contains(new Resource(checkoutResource));
    }

    public boolean remainContains(String remainResource) {
        return resourceInLibrary.contains(new Resource(remainResource));
    }

    public boolean checkoutContains(Resource checkoutResource) {
        return resourceOutOfLibrary.contains(checkoutResource);
    }

    public boolean remainContains(Resource remainResource) {
        return resourceInLibrary.contains(remainResource);
    }

    public void checkout(Resource resource) throws IllegalArgumentException {
        Resource tempResource;
        for (Resource r : resourceInLibrary) {
            if (r.equals(resource)) {
                tempResource = new Resource(r);
                resourceOutOfLibrary.add(tempResource);
                resourceInLibrary.remove(r);

                return;
            }
        }

        String resourceClass = resource.getClass().getSimpleName().toLowerCase();
        throw new IllegalArgumentException("That " + resourceClass + " is not available.");
    }

    public void returnResource(Resource resource) throws IllegalArgumentException {
        Resource tempResource;

        for (Resource b : resourceOutOfLibrary) {
            if (b.equals(resource)) {
                tempResource = new Resource(b);
                resourceOutOfLibrary.remove(b);
                resourceInLibrary.add(tempResource);
                return;
            }
        }

        String resourceClass = resource.getClass().getSimpleName().toLowerCase();
        throw new IllegalArgumentException("That is not a valid " + resourceClass + " to return.");
    }

    public List<Resource> getResourceInLibrary() {
        return resourceInLibrary;
    }

    public List<Resource> getResourceOutOfLibrary() {
        return resourceOutOfLibrary;
    }
}
