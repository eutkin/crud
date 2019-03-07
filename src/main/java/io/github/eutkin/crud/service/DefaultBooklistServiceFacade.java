package io.github.eutkin.crud.service;

import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Primary
public class DefaultBooklistServiceFacade implements BooklistServiceFacade {

    @Delegate
    private final BooklistCreator booklistCreator;

    @Delegate
    private final BookAdder bookAdder;
}
