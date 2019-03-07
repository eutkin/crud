package io.github.eutkin.crud.service;

import io.github.eutkin.crud.entity.Booklist;
import io.github.eutkin.crud.entity.User;
import io.github.eutkin.crud.repository.BookRepository;
import io.github.eutkin.crud.repository.UserRepository;
import io.github.eutkin.crud.request.CreateBooklistRequest;
import io.github.eutkin.crud.service.exception.BookNotFoundServiceException;
import io.github.eutkin.crud.view.BooklistView;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

@Service
@Transactional
public class DefaultBooklistCreator implements BooklistCreator {

    private final Converter<CreateBooklistRequest, Booklist> requestMapper;
    private final Converter<Booklist, BooklistView> viewMapper;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public DefaultBooklistCreator(
            Converter<CreateBooklistRequest, Booklist> requestMapper,
            Converter<Booklist, BooklistView> viewMapper,
            UserRepository userRepository,
            BookRepository bookRepository) {
        this.requestMapper = requireNonNull(requestMapper);
        this.viewMapper = requireNonNull(viewMapper);
        this.userRepository = requireNonNull(userRepository);
        this.bookRepository = requireNonNull(bookRepository);
    }

    @Override
    public BooklistView createForUser(@NonNull CreateBooklistRequest request) {
        Set<UUID> notExistsBooks = request.getBooks()
                .stream()
                .filter(id -> !bookRepository.existsById(id))
                .collect(Collectors.toSet());

        if (!notExistsBooks.isEmpty()) {
            throw new BookNotFoundServiceException(notExistsBooks);
        }

        Booklist booklist = requestMapper.convert(request);
        User updatedUser = userRepository.save(booklist.getAuthor());
        Booklist savedBooklist = updatedUser
                .getBooklists()
                .stream()
                .filter(b -> Objects.equals(b.getName(), booklist.getName()))
                .findFirst()
                .get();
        return viewMapper.convert(savedBooklist);
    }
}
