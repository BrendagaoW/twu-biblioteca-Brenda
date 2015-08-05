package com.twu.biblioteca;

public class Movie {
    private String name;
    private int year;
    private String director;
    private int rating;

    public Movie(String name, int year, String director, int rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String getDetail() {
        return name + "\t" +
                year + "\t" +
                director + "\t" +
                rating;
    }
}
