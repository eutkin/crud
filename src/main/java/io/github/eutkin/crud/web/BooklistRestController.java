package io.github.eutkin.crud.web;

import io.github.eutkin.crud.request.AddBookToBooklistRequest;
import io.github.eutkin.crud.request.CreateBooklistRequest;
import io.github.eutkin.crud.service.BooklistServiceFacade;
import io.github.eutkin.crud.view.BooklistView;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static java.util.Objects.requireNonNull;

@RestController
@RequestMapping("/api/booklist")
public class BooklistRestController {

    private final BooklistServiceFacade booklistService;

    public BooklistRestController(BooklistServiceFacade booklistService) {
        this.booklistService = requireNonNull(booklistService);
    }

    @PostMapping
    public BooklistView create(@RequestBody @Valid CreateBooklistRequest request) {
        return booklistService.createForUser(request);
    }

    @PutMapping
    public BooklistView addBook(@RequestBody @Valid AddBookToBooklistRequest request) {
        return booklistService.addToBooklist(request);
    }
}
