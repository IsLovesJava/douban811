package com.pan.demo.mapper;

import com.pan.demo.model.Book;
import com.pan.demo.model.BookTag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {
    @Select("select * from doubanTag")
    List<BookTag> selectBookTag();

    @Select("select * from newBook")
    List<Book> selectNewBooks();

    @Select("select * from top250")
    List<Book> selectTopBooks();
}
