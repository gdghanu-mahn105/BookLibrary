package com.example.BookLibrary.service;

import com.example.BookLibrary.entity.Book;
import com.example.BookLibrary.dto.FilterParamBook;
import java.util.List;

public interface BookService {
    List<Book> getBook(FilterParamBook filterParamBook);
    Book getBookId(Long id);
    Integer CreateBook(Book book);
    Integer UpdateBook(Book book);
    Long deleteBook(Long id);



}
