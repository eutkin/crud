package io.github.eutkin.crud.service;

import io.github.eutkin.crud.converter.BooklistViewMapper;
import io.github.eutkin.crud.converter.CreateBooklistRequestMapper;
import io.github.eutkin.crud.entity.Booklist;
import io.github.eutkin.crud.repository.BooklistRepository;
import io.github.eutkin.crud.request.CreateBooklistRequest;
import io.github.eutkin.crud.view.BooklistView;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Objects.requireNonNull;

@Service
@Transactional
public class DefaultBooklistCreator implements BooklistCreator {

    private final CreateBooklistRequestMapper requestMapper;
    private final BooklistViewMapper viewMapper;
    private final BooklistRepository booklistRepository;

    public DefaultBooklistCreator(
            CreateBooklistRequestMapper requestMapper,
            BooklistViewMapper viewMapper,
            BooklistRepository booklistRepository
    ) {
        this.requestMapper = requireNonNull(requestMapper);
        this.viewMapper = requireNonNull(viewMapper);
        this.booklistRepository = requireNonNull(booklistRepository);
    }

    @Override
    public BooklistView createForUser(@NonNull CreateBooklistRequest request) {
        Booklist booklist = requestMapper.convert(request);
        Booklist savedBooklist = booklistRepository.save(booklist);
        return viewMapper.convert(savedBooklist);
    }
}
