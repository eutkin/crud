package io.github.eutkin.crud.request;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class AddBookToBooklistRequest extends Request {

    @NotNull(message = "book.id.not-null")
    private UUID bookId;

    @NotNull(message = "booklist.id.not-null")
    private UUID booklistId;

    public UUID getBookId() {
        return bookId;
    }

    public void setBookId(UUID bookId) {
        this.bookId = bookId;
    }

    public UUID getBooklistId() {
        return booklistId;
    }

    public void setBooklistId(UUID booklistId) {
        this.booklistId = booklistId;
    }
}
