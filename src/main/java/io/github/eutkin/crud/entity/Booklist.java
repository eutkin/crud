package io.github.eutkin.crud.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "booklists")
public class Booklist {

    @Id
    @GeneratedValue(generator = "org.hibernate.id.UUIDGenerator")
    @Column(name = "booklist_id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "author")
    private User author;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(joinColumns = @JoinColumn(name = "booklist_id"), inverseJoinColumns = @JoinColumn(name = "login"))
    private Set<User> users = new HashSet<>();

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "booklist_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Book> books;

    public UUID getId() {
        return id;
    }

    public Booklist setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Booklist setName(String name) {
        this.name = name;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public Booklist setAuthor(User author) {
        this.author = author;
        this.users.add(author);
        return this;
    }

    public Set<User> getUsers() {
        return users;
    }

    public Booklist setUsers(Set<User> users) {
        this.users = users;
        return this;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public Booklist setBooks(Set<Book> books) {
        this.books = books;
        return this;
    }

    public Booklist addBooks(Book book) {
        this.books.add(book);
        return this;
    }
}
