package io.github.eutkin.crud.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @Column(name = "book_id")
    @GeneratedValue(generator = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private LocalDate publishDate;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @Column(nullable = false, length = 1000)
    private String shortDescription;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    public Book(){

    }

    public Book(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public Book setId(UUID id) {
        this.id = id;
        return this;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public Book setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
        return this;
    }

    public Genre getGenre() {
        return genre;
    }

    public Book setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public Book setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public Book setAuthors(Set<Author> authors) {
        this.authors = authors;
        return this;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public Book setPublisher(Publisher publisher) {
        this.publisher = publisher;
        return this;
    }
}
