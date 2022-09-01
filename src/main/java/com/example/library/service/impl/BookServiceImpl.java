package com.example.library.service.impl;

import com.example.library.dto.BookDTO;
import com.example.library.entity.Book;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.security.SecureRandom;
import java.util.Hashtable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public BookDTO addBook(BookDTO bookDTO) {
        Book book = Book.builder()
                .title(bookDTO.getTitle())
                .year(bookDTO.getYear())
                .description(bookDTO.getDescription())
                .barcode(bookDTO.getBarcode().isEmpty() ? generatePassword(13) : bookDTO.getBarcode())
                .category(bookDTO.getCategory())
                .booking(bookDTO.getBooking())
                .build();
        bookRepository.save(book);
        return BookDTO.from(book);
    }

    private String generatePassword(int length) {
        final String chars = "1234567890";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        return sb.toString();
    }

    @Override
    public Optional<BookDTO> getBookByBarcode(String code) {
        return bookRepository.findBookByBarcode(code).map(BookDTO::from);
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream().map(BookDTO::from).collect(Collectors.toList());
    }

    public static byte[] getBarCodeImage(String id, int width, int height) {
        try {
            Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<>();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            Writer writer = new Code128Writer();
            BitMatrix bitMatrix = writer.encode(id, BarcodeFormat.CODE_128, width, height);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "png", byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            return null;
        }
    }
}
