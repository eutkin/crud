package io.github.eutkin.crud.converter;

import io.github.eutkin.crud.entity.Book;
import io.github.eutkin.crud.entity.Booklist;
import io.github.eutkin.crud.request.CreateBooklistRequest;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.lang.NonNull;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface CreateBooklistRequestMapper {


    @Mapping(source = "owner", target = "author")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "books", target = "books")
    @NonNull
    Booklist convert(@NonNull CreateBooklistRequest source);

    default Book uuidToBook(UUID book) {
        return new Book().setId(book);
    }

    @AfterMapping
    default void fillBooklistOnAuthor(@MappingTarget Booklist booklist) {
        booklist.getAuthor().addBooklist(booklist);
    }
}
