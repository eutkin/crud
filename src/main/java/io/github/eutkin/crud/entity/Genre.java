package io.github.eutkin.crud.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "genres")
@Getter
@Setter
public class Genre {

    @Id
    @Column(name = "genre_id")
    private Long id;

    @Column(name = "genre")
    private String name;
}
