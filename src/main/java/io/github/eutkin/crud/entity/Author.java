package io.github.eutkin.crud.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
@Getter
@Setter
public class Author {

    @Id
    @Column(name = "author_id")
    private Long id;

    @Column(nullable = false)
    private String name;
}
