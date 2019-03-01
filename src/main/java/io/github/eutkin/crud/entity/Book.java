package io.github.eutkin.crud.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "books")
@Getter
@Setter
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
}
