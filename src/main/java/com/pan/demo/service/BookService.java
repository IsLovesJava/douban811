package com.pan.demo.service;

import com.pan.demo.model.Book;
import com.pan.demo.model.BookTag;

import java.util.List;


public interface BookService {
    List<BookTag> getPopularTag();
    List<Book> getNewBook();
    List<Book> getTopBook();
}
