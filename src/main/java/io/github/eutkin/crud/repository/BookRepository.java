package io.github.eutkin.crud.repository;

import io.github.eutkin.crud.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {

    @Query("select count(b) from #{#entityName} b where b.id in :idSet")
    boolean exists(Collection<UUID> idSet);
}
