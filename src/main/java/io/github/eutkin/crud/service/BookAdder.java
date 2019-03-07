package io.github.eutkin.crud.service;

import io.github.eutkin.crud.request.AddBookToBooklistRequest;
import io.github.eutkin.crud.view.BooklistView;
import org.springframework.lang.NonNull;

public interface BookAdder {

    @NonNull
    BooklistView addToBooklist(@NonNull AddBookToBooklistRequest request);
}
