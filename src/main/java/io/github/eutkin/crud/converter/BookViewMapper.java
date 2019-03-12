package io.github.eutkin.crud.converter;

import io.github.eutkin.crud.entity.Author;
import io.github.eutkin.crud.entity.Book;
import io.github.eutkin.crud.view.BookView;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.lang.NonNull;

@Mapper(componentModel = "spring")
public interface BookViewMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "publishDate", target = "publishDate")
    @Mapping(source = "genre.name", target = "genre")
    @Mapping(source = "shortDescription", target = "shortDescription")
    @Mapping(source = "authors", target = "authors")
    @Mapping(source = "publisher.name", target = "publisher")
    @NonNull
    BookView convert(@NonNull Book book);

    default String authorToString(Author author) {
        return author.getName();
    }

}
