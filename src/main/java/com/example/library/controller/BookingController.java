package com.example.library.controller;

import com.example.library.dto.BookDTO;
import com.example.library.service.impl.BookServiceImpl;
import com.example.library.service.impl.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class BookingController {
    private final BookServiceImpl bookService;
    private final CategoryServiceImpl categoryService;

//    @GetMapping
//    public String getMainPage() {
//        return "index";
//    }
//
//    @GetMapping("/add/book")
//    public String getAddBook(Model model) {
//        model.addAttribute("categories", categoryService.getAllCategories());
//        return "add_book";
//    }
//
//    @PostMapping("/add/book")
//    public String addBook(BookDTO bookDTO) {
//        bookService.addBook(bookDTO);
//        return "redirect:/";
//    }

    @GetMapping("/search/{barcode}")
    public String getBookByBarcode(@PathVariable String barcode) {
        Optional<BookDTO> bookByBarcode = bookService.getBookByBarcode(barcode);
        if (bookByBarcode.isPresent()) {
            return "redirect:/book";
        }
        return "redirect:/add/book";
    }
}
