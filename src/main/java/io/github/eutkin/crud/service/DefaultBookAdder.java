package io.github.eutkin.crud.service;

import io.github.eutkin.crud.entity.Book;
import io.github.eutkin.crud.entity.Booklist;
import io.github.eutkin.crud.repository.BookRepository;
import io.github.eutkin.crud.repository.BooklistRepository;
import io.github.eutkin.crud.request.AddBookToBooklistRequest;
import io.github.eutkin.crud.service.exception.BookNotFoundServiceException;
import io.github.eutkin.crud.service.exception.BooklistNotFoundServiceException;
import io.github.eutkin.crud.view.BooklistView;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import static java.util.Objects.requireNonNull;

@Service
public class DefaultBookAdder implements BookAdder {

    private final BooklistRepository booklistRepository;
    private final BookRepository bookRepository;
    private final Converter<Booklist, BooklistView> viewConverter;

    public DefaultBookAdder(
            BooklistRepository booklistRepository,
            BookRepository bookRepository,
            Converter<Booklist, BooklistView> viewConverter
    ) {
        this.booklistRepository = requireNonNull(booklistRepository);
        this.bookRepository = requireNonNull(bookRepository);
        this.viewConverter = requireNonNull(viewConverter);
    }

    @Override
    public BooklistView addToBooklist(AddBookToBooklistRequest request) {
        boolean bookExists = bookRepository.existsById(request.getBookId());
        if (!bookExists) {
            throw new BookNotFoundServiceException(request.getBookId());
        }

        Booklist booklist = request
                .getOwner()
                .getBooklists()
                .stream()
                .filter(bk -> bk.getId().equals(request.getBooklistId()))
                .findFirst()
                .orElseThrow(() -> new BooklistNotFoundServiceException(request.getBooklistId(), request.getOwner().getDisplayName()))
                .addBooks(new Book().setId(request.getBookId()));
        Booklist savedBooklist = booklistRepository.save(booklist);
        return viewConverter.convert(savedBooklist);

    }
}
