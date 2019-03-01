package io.github.eutkin.crud.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "publishers")
@Getter
@Setter
public class Publisher {

    @Id
    @Column(name = "publisher_id")
    private Long id;

    @Column(name = "publisher_name", nullable = false)
    private String name;

}
