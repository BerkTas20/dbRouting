package com.berktas.dbRouting.book.controller;

import com.berktas.dbRouting.book.controller.requests.SaveAuthorRequest;
import com.berktas.dbRouting.book.controller.requests.SaveBookRequest;
import com.berktas.dbRouting.book.controller.requests.UpdateBookRequest;
import com.berktas.dbRouting.book.entity.Author;
import com.berktas.dbRouting.book.entity.Book;
import com.berktas.dbRouting.book.service.AuthorManager;
import com.berktas.dbRouting.book.service.BookManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/author")
public class AuthorController {
    private final AuthorManager authorManager;
    
    @PostMapping("/create")
    public Author insertAuthor(@RequestBody SaveAuthorRequest request) {
        return authorManager.createAuthor(request);
    }
}
