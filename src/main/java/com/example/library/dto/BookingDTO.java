package com.example.library.dto;

import com.example.library.entity.Book;
import com.example.library.entity.Booking;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookingDTO {

    private Long id;

    private String username;
    private String phone;
    private LocalDateTime date;

    public static BookingDTO from(Booking booking) {
        return BookingDTO.builder()
                .username(booking.getUsername())
                .phone(booking.getPhone())
                .date(booking.getDate())
                .build();
    }
}
