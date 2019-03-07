package io.github.eutkin.crud.view;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public class BookView {

    private UUID id;

    private LocalDate publishDate;

    private String genre;

    private String shortDescription;

    private Set<String> authors;

    private String publisher;

    public UUID getId() {
        return id;
    }

    public BookView setId(UUID id) {
        this.id = id;
        return this;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public BookView setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
        return this;
    }

    public String getGenre() {
        return genre;
    }

    public BookView setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public BookView setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }

    public Set<String> getAuthors() {
        return authors;
    }

    public BookView setAuthors(Set<String> authors) {
        this.authors = authors;
        return this;
    }

    public String getPublisher() {
        return publisher;
    }

    public BookView setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }
}
