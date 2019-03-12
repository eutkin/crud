package io.github.eutkin.crud.service;

import io.github.eutkin.crud.converter.BooklistViewMapper;
import io.github.eutkin.crud.converter.CreateBooklistRequestMapper;
import io.github.eutkin.crud.entity.Book;
import io.github.eutkin.crud.entity.Booklist;
import io.github.eutkin.crud.repository.BookRepository;
import io.github.eutkin.crud.repository.BooklistRepository;
import io.github.eutkin.crud.request.CreateBooklistRequest;
import io.github.eutkin.crud.service.exception.BookNotFoundServiceException;
import io.github.eutkin.crud.view.BooklistView;
import org.springframework.data.domain.Example;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

@Service
@Transactional
public class DefaultBooklistCreator implements BooklistCreator {

    private final CreateBooklistRequestMapper requestMapper;
    private final BooklistViewMapper viewMapper;
    private final BookRepository bookRepository;
    private final BooklistRepository booklistRepository;

    public DefaultBooklistCreator(
            CreateBooklistRequestMapper requestMapper,
            BooklistViewMapper viewMapper,
            BookRepository bookRepository, BooklistRepository booklistRepository) {
        this.requestMapper = requireNonNull(requestMapper);
        this.viewMapper = requireNonNull(viewMapper);
        this.bookRepository = requireNonNull(bookRepository);
        this.booklistRepository = requireNonNull(booklistRepository);
    }

    @Override
    public BooklistView createForUser(@NonNull CreateBooklistRequest request) {
        Booklist booklist = requestMapper.convert(request);

        Set<UUID> notExistsBooks = booklist.getBooks()
                .stream()
                .filter(book -> !bookRepository.exists(Example.of(book)))
                .map(Book::getId)
                .collect(Collectors.toSet());

        if (!notExistsBooks.isEmpty()) {
            throw new BookNotFoundServiceException(notExistsBooks);
        }

        Booklist savedBooklist = booklistRepository.save(booklist);
        return viewMapper.convert(savedBooklist);
    }
}
