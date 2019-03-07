package io.github.eutkin.crud.service;

import io.github.eutkin.crud.request.CreateBooklistRequest;
import io.github.eutkin.crud.view.BooklistView;
import org.springframework.lang.NonNull;

public interface BooklistCreator {

    @NonNull
    BooklistView createForUser(@NonNull CreateBooklistRequest request);
}
