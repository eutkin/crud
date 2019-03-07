package io.github.eutkin.crud.request;

import io.github.eutkin.crud.entity.Book;
import io.github.eutkin.crud.entity.Booklist;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class CreateBooklistRequest extends Request {

    @NotBlank
    private String name;
    private Set<UUID> books = new HashSet<>();

    public Booklist toBooklist() {
        return new Booklist().setName(name).setBooks(books.stream().map(Book::new).collect(Collectors.toSet()));
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    public Set<UUID> getBooks() {
        return books;
    }

    public void setBooks(Set<UUID> books) {
        this.books = books;
    }
}
