package io.github.eutkin.crud.converter;

import io.github.eutkin.crud.entity.Booklist;
import io.github.eutkin.crud.view.BooklistView;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;

@Mapper(
        componentModel = "spring",
        injectionStrategy = CONSTRUCTOR,
        uses = BookViewMapper.class
)
public interface BooklistViewMapper extends Converter<Booklist, BooklistView> {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "books", target = "books")
    @Override
    BooklistView convert(Booklist source);
}
