package com.berktas.dbRouting.book.controller.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveAuthorRequest {
    private String email;
    private String name;
    private String dbName;
}
