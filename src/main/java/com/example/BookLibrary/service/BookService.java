package com.example.BookLibrary.service;

import com.example.BookLibrary.controller.Book;
import com.example.BookLibrary.dto.FilterParamBook;

import java.util.List;

public interface BookService {
    List<Book> getBook(FilterParamBook filterParamBook);
    Integer CreateBook(Book book);
    Integer UpdateBook(Book book);
    Long deleteBook(Long id);



}
