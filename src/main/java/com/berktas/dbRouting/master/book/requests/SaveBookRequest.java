package com.berktas.dbRouting.master.book.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveBookRequest {
    String dbName;
    String code;
    String title;
}
