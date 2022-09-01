package com.example.library.service.impl;

import com.example.library.dto.AuthorDTO;
import com.example.library.dto.BookDTO;
import com.example.library.entity.Author;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;
import com.google.zxing.*;
import com.google.zxing.Writer;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.multi.GenericMultipleBarcodeReader;
import com.google.zxing.multi.MultipleBarcodeReader;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.oned.EAN13Writer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.pnuema.java.barcode.Barcode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Hashtable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Override
    public void addBook(AuthorDTO authorDTO) {
        authorRepository.save(Author.builder()
                .name(authorDTO.getName())
                .book(authorDTO.getBook())
                .build());
    }

    @Override
    public Optional<BookDTO> getBookByBarcode(String code) {
        return bookRepository.findBookByBarcode(code).map(BookDTO::from);
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream().map(BookDTO::from).collect(Collectors.toList());
    }

//    public static byte[] getBarCodeImage(String text, int width, int height) {
//        try {
//            Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<>();
//            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
//            Writer writer = new Code128Writer();
//            BitMatrix bitMatrix = writer.encode(text, BarcodeFormat.CODE_128, width, height);
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            MatrixToImageWriter.writeToStream(bitMatrix, "png", byteArrayOutputStream);
//            return byteArrayOutputStream.toByteArray();
//        } catch (Exception e) {
//            return null;
//        }
//    }

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
