package com.example.library.service.impl;

import com.example.library.dto.BookDTO;
import com.example.library.entity.Book;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public void addBook(BookDTO bookDTO) {
        bookRepository.save(
                Book.builder()
                        .title(bookDTO.getTitle())
                        .year(bookDTO.getYear())
                        .description(bookDTO.getDescription())
                        .barcode(bookDTO.getBarcode())
                        .category(bookDTO.getCategory())
                        .booking(bookDTO.getBooking())
                        .build()
        );
    }

    @Override
    public Optional<BookDTO> getBookByBarcode(String code) {
       return bookRepository.findBookByBarcode(code).map(BookDTO::from);
    }
}
