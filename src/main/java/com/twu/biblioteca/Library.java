package com.twu.biblioteca;

import com.twu.biblioteca.Resources.Book;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Resource> resourceInLibrary;
    private List<Resource> resourceOutOfLibrary;

    public Library(List<Resource> resourceInLibrary, List<Resource> resourceOutOfLibrary) {
        this.resourceInLibrary = resourceInLibrary;
        this.resourceOutOfLibrary = resourceOutOfLibrary;
    }


    public boolean checkoutContains(Resource checkoutResource) {
        return resourceOutOfLibrary.contains(checkoutResource);
    }

    public boolean remainContains(Resource remainResource) {
        return resourceInLibrary.contains(remainResource);
    }

    public void checkout(Resource resource) throws IllegalArgumentException {
        int result = removeFromStoD(resource, resourceInLibrary, resourceOutOfLibrary);
        if (result != -1) {
            String resourceClass = resource.getClass().getSimpleName().toLowerCase();
            throw new IllegalArgumentException("That " + resourceClass + " is not available.");
        }
    }


    public void returnResource(Resource resource) throws IllegalArgumentException {
        int result = removeFromStoD(resource, resourceOutOfLibrary, resourceInLibrary);
        if (result != -1) {
            String resourceClass = resource.getClass().getSimpleName().toLowerCase();
            throw new IllegalArgumentException("That is not a valid " + resourceClass + " to return.");
        }
    }

    public List<Resource> getResourceInLibrary() {
        return resourceInLibrary;
    }

    public List<Resource> getResourceOutOfLibrary() {
        return resourceOutOfLibrary;
    }
//
//    private Resource removeFromStoD(Resource resource, List<Resource> source, List<Resource> destination) {
////        Resource tempResource = null;
////        for (Resource r : source) {
////            if (r.equals(resource)) {
////                tempResource = new Resource(r);
////                destination.add(tempResource);
////                source.remove(r);
////                break;
////            }
////        }
////        return tempResource;
//
//        int i = 0;
//        for (Resource r : source) {
//            if (r.equals(resource)) {
//                destination.add(source.remove(i));
//                return -1;
//            }
//            ++i;
//        }
//        return i;
//    }

    private int removeFromStoD(Resource resource, List<Resource> source, List<Resource> destination) {
//        Resource tempResource = null;
//        for (Resource r : source) {
//            if (r.equals(resource)) {
//                tempResource = new Resource(r);
//                destination.add(tempResource);
//                source.remove(r);
//                break;
//            }
//        }
//        return tempResource;

        int i = 0;
        for (Resource r : source) {
            if (r.equals(resource)) {
                destination.add(source.remove(i));
                return -1;
            }
            ++i;
        }
        return i;
    }

    public static void main(String[] args) {
        Resource book1 = new Book("1");
        Resource book2 = new Book("2");
        Resource book3 = new Book("3");
        Resource book4 = new Book("4");
        List<Resource> inList = new ArrayList<Resource>();
        List<Resource> outList = new ArrayList<Resource>();
        inList.add(book1);
        inList.add(book2);
        outList.add(book3);
        outList.add(book4);
        Library library = new Library(inList, outList);

        System.out.println(library.checkoutContains(book1));
        System.out.println(library.checkoutContains(book3));
        System.out.println(library.remainContains(book3));
        System.out.println(library.remainContains(book1));
    }
}
