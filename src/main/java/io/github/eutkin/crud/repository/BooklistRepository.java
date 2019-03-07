package io.github.eutkin.crud.repository;

import io.github.eutkin.crud.entity.Booklist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BooklistRepository extends JpaRepository<Booklist, UUID> {
}
