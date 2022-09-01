package com.example.library.service;

import com.example.library.dto.AuthorDTO;
import com.example.library.dto.BookDTO;

import java.util.List;
import java.util.Optional;

public interface BookService {
    BookDTO addBook(BookDTO bookDTO);

    Optional<BookDTO> getBookByBarcode(String code);

    List<BookDTO> getAllBooks();
}
