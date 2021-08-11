package com.pan.demo.service.impl;

import com.pan.demo.mapper.BookMapper;
import com.pan.demo.model.Book;
import com.pan.demo.model.BookTag;
import com.pan.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    BookMapper bookMapper;

    @Override
    public List<BookTag> getPopularTag() {
        return bookMapper.selectBookTag();
    }

    @Override
    public List<Book> getNewBook() {
        return bookMapper.selectNewBooks();
    }

    @Override
    public List<Book> getTopBook() {
        return bookMapper.selectTopBooks();
    }


}
