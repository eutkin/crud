package io.github.eutkin.crud.view;

import io.github.eutkin.crud.entity.Booklist;

import java.util.Set;

public class BooklistView {

    private String name;

    private Set<BookView> books;

    public BooklistView(Booklist booklist) {
        this.name = booklist.getName();
    }

    public BooklistView() {
    }

    public String getName() {
        return name;
    }

    public BooklistView setName(String name) {
        this.name = name;
        return this;
    }

    public Set<BookView> getBooks() {
        return books;
    }

    public BooklistView setBooks(Set<BookView> books) {
        this.books = books;
        return this;
    }
}
