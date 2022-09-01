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
import org.springframework.web.bind.annotation.RequestParam;

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
    @GetMapping("/add/book")
    public String getAddBook(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "add_book";
    }

    @PostMapping("/add/book")
    public String addBook(BookDTO bookDTO) {
        bookService.addBook(bookDTO);
        return "redirect:/";
    }

    @PostMapping("/search")
    public String getBookByBarcode(@RequestParam String qrContent) {
        Optional<BookDTO> bookByBarcode = bookService.getBookByBarcode(qrContent);
        if (bookByBarcode.isPresent()) {
            return "redirect:/book/" + qrContent;
        }
        return "redirect:/add/book";
    }



    @GetMapping("/book/{barcode}")
    public String getBook(Model model, @PathVariable String barcode){
        model.addAttribute("book",bookService.getBookByBarcode(barcode));
        return "book";
    }

}
