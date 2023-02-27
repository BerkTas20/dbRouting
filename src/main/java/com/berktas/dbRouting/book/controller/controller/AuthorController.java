package com.berktas.dbRouting.book.controller.controller;

import com.berktas.dbRouting.book.service.AuthorManager;
import com.berktas.dbRouting.book.controller.requests.SaveAuthorRequest;
import com.berktas.dbRouting.book.entity.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
