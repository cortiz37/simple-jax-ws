package com.business.model;

import java.util.List;

public class Book {

    private String title;
    private String section;

    private List<String> authors;

    public Book() {
    }

    public Book(String title, String section, List<String> authors) {
        this.title = title;
        this.section = section;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
}
