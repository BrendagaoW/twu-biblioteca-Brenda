package com.twu.biblioteca;

public abstract class Resource {

    private String name;
    private int year;

    public Resource(String name) {
        this.name = name;
    }

    public Resource(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public Resource(Resource r) {
        this.name = r.name;
        this.year = r.year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resource resource = (Resource) o;

        if (!name.equals(resource.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public abstract String getDetail();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
