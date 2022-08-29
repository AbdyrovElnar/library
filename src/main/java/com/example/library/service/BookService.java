package com.example.library.service;

import com.example.library.dto.BookDTO;

import java.util.Optional;

public interface BookService {
    void addBook(BookDTO bookDTO);

    Optional<BookDTO> getBookByBarcode(String code);
}
