package com.example.library.controller;

import com.example.library.dto.AuthorDTO;
import com.example.library.dto.BookDTO;
import com.example.library.service.BookService;
import com.example.library.service.CategoryService;
import com.example.library.service.QRCodeService;
import com.example.library.service.impl.BookServiceImpl;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.multi.GenericMultipleBarcodeReader;
import com.google.zxing.multi.MultipleBarcodeReader;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.Hashtable;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class BookingController {
    private final BookService bookService;
    private final CategoryService categoryService;
    private final BookServiceImpl bookServiceImpl;

    @GetMapping
    public String getMainPage(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "index";
    }

    @GetMapping("/barcode/{id}")
    public void barcode(@PathVariable("id") String id, HttpServletResponse response) throws Exception {
        response.setContentType("image/png");
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(Objects.requireNonNull(BookServiceImpl.getBarCodeImage(id, 200, 200)));
        outputStream.flush();
        outputStream.close();
    }



    @GetMapping("/add/book")
    public String getAddBook(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "add_book";
    }

    @PostMapping("/add/book")
    public String addBook(AuthorDTO authorDTO) {
        bookService.addBook(authorDTO);
        return "redirect:/";
    }

    @GetMapping("/search/{barcode}")
    public String getBookByBarcode(@PathVariable String barcode) {
        Optional<BookDTO> bookByBarcode = bookService.getBookByBarcode(barcode);
        if (bookByBarcode.isPresent()) {
            return "redirect:/book/" + barcode;
        }
        return "redirect:/add/book";
    }
}
