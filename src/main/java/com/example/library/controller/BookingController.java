package com.example.library.controller;

import com.example.library.dto.BookDTO;
import com.example.library.service.BookService;
import com.example.library.service.CategoryService;
import com.example.library.service.impl.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
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
    public String addBook(BookDTO bookDTO) {
        BookDTO book = bookService.addBook(bookDTO);
        return "redirect:/" + book.getBarcode();
    }

    @GetMapping("/{barcode}")
    public String getBookByBarcode(@PathVariable String barcode, Model model) {
        Optional<BookDTO> bookByBarcode = bookServiceImpl.getBookByBarcode(barcode);
        model.addAttribute("book", bookByBarcode.get().getBarcode());
        return "book";
    }
}
