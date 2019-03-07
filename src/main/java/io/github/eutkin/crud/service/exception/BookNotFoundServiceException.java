package io.github.eutkin.crud.service.exception;

import java.util.Collection;
import java.util.UUID;

import static java.util.stream.Collectors.joining;

public class BookNotFoundServiceException extends ServiceException {

    public BookNotFoundServiceException(UUID bookId) {
        super("book.not-exists", bookId);
    }

    public BookNotFoundServiceException(Collection<UUID> bookIdSet) {
        super(
                bookIdSet.size() == 1 ? "book.not-exists" : "books.not-exists",
                bookIdSet.stream().map(UUID::toString).collect(joining(", "))
        );
    }
}
