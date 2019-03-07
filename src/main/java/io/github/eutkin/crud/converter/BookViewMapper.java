package io.github.eutkin.crud.converter;

import io.github.eutkin.crud.entity.Author;
import io.github.eutkin.crud.entity.Book;
import io.github.eutkin.crud.view.BookView;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface BookViewMapper extends Converter<Book, BookView> {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "publishDate", target = "publishDate")
    @Mapping(source = "genre.name", target = "genre")
    @Mapping(source = "shortDescription", target = "shortDescription")
    @Mapping(source = "authors", target = "authors")
    @Mapping(source = "publisher.name", target = "publisher")
    @Override
    BookView convert(Book book);

    default String authorToString(Author author) {
        return author.getName();
    }

}
