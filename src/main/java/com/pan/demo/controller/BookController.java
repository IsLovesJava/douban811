package com.pan.demo.controller;

import com.pan.demo.model.Book;
import com.pan.demo.model.BookTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.pan.demo.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping(value = "/book")
    public String defaultPath() {
        return "forward:/page/book.html";
    }

    @RequestMapping("/book/tag")
    @ResponseBody
    public List<BookTag> getTagInfo(){
        return bookService.getPopularTag();
    }

    @RequestMapping("/book/newBook")
    @ResponseBody
    public List<Book> getNewBook(){
        return bookService.getNewBook();
    }

    @RequestMapping("/book/top")
    @ResponseBody
    public List<Book> getTopBook(){
        return bookService.getTopBook();
    }
}
