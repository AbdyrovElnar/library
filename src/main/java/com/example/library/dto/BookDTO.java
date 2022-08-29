package com.example.library.dto;

import com.example.library.entity.Book;
import com.example.library.entity.Booking;
import com.example.library.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookDTO {

    private Long id;

    private String title;

    private Integer year;

    private String description;
    private String barcode;

    private Category category;

    private Booking booking;

    public static BookDTO from(Book book) {
        return BookDTO.builder()
                .title(book.getTitle())
                .year(book.getYear())
                .description(book.getDescription())
                .barcode(book.getBarcode())
                .category(book.getCategory())
                .booking(book.getBooking())
                .build();
    }
}
