package io.github.eutkin.crud.service.exception;

import java.util.UUID;

public class BooklistNotFoundServiceException extends ServiceException {

    public BooklistNotFoundServiceException(UUID booklist, String displayName) {
        super("booklist.not-exists", booklist, displayName);
    }
}
