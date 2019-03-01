package io.github.eutkin.crud.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "booklists")
@Getter
@Setter
public class Booklist {

    @Id
    @GeneratedValue(generator = "org.hibernate.id.UUIDGenerator")
    @Column(name = "booklist_id")
    private UUID id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "author")
    private User author;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "booklist_id"), inverseJoinColumns = @JoinColumn(name = "login"))
    private Set<User> users;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "booklist_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Book> books;

}
