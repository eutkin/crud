package io.github.eutkin.crud.service;

import io.github.eutkin.crud.converter.BooklistViewMapper;
import io.github.eutkin.crud.entity.Book;
import io.github.eutkin.crud.entity.Booklist;
import io.github.eutkin.crud.repository.BooklistRepository;
import io.github.eutkin.crud.request.AddBookToBooklistRequest;
import io.github.eutkin.crud.service.exception.BooklistNotFoundServiceException;
import io.github.eutkin.crud.view.BooklistView;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Objects.requireNonNull;

@Service
@Transactional
public class DefaultBookAdder implements BookAdder {

    private final BooklistRepository booklistRepository;
    private final BooklistViewMapper viewConverter;

    public DefaultBookAdder(
            BooklistRepository booklistRepository,
            BooklistViewMapper viewConverter
    ) {
        this.booklistRepository = requireNonNull(booklistRepository);
        this.viewConverter = requireNonNull(viewConverter);
    }

    @Override
    public BooklistView addToBooklist(AddBookToBooklistRequest request) {
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
