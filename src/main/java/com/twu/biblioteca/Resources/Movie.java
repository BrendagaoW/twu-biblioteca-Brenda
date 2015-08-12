package com.twu.biblioteca.Resources;

import com.twu.biblioteca.Resource;

public class Movie extends Resource {
    private String director;
    private int rating;

    public Movie(String name, int year, String director, int rating) {
        super(name, year);
        this.director = director;
        this.rating = rating;
    }

    public Movie(String name) {
        super(name);
    }

    public Movie(Movie movie) {
        super(movie);
        this.director = movie.director;
        this.rating = movie.rating;
    }

    public String getDetail() {
        return getName() + "\t" +
                getYear() + "\t" +
                director + "\t" +
                rating;
    }
}
