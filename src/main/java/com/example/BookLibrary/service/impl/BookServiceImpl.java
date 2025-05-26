package com.example.BookLibrary.service.impl;

import com.example.BookLibrary.controller.Book;
import com.example.BookLibrary.dto.FilterParamBook;
import com.example.BookLibrary.service.BookService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private static final int LESS_MODE = -1;
    private static final int EQUAL_MODE = 0;
    private static final int GREATER_MODE = 1;

    public static List<Book> books=new ArrayList<>(List.of(
            new Book(1,"ten1","tacgia1",10000.344, LocalDate.of(2024, 5, 24)),
            new Book(2,"ten2","tacgia2",11000.344, LocalDate.of(2024, 4, 24)),
            new Book(3,"ten3","tacgia3",12000.344, LocalDate.of(2024, 3, 24)),
            new Book(4,"ten4","tacgia4",13000.344, LocalDate.of(2024, 2, 24)),
            new Book(5,"ten5","tacgia5",14000.344, LocalDate.of(2024, 1, 24)),
            new Book(6,"ten6","tacgia6",15000.344, LocalDate.of(2024, 2, 24))


        ));


    @Override
    public List<Book> getBook(FilterParamBook param) {
        Predicate<Book> predicate= books-> true;

        if(param.getId()!=null && param.getIdMode()==null) {
            predicate=predicate.and(book-> {
                return book.getId() == param.getId();
            });
        }
        if(param.getIdMode()!=null){
            if (param.getIdMode() == EQUAL_MODE) {
                predicate=predicate.and(book->book.getId()==param.getId());
            } else if (param.getIdMode()>= GREATER_MODE){
                predicate=predicate.and(book -> book.getId()>=param.getId());
            } else if(param.getIdMode()<=LESS_MODE){
                predicate=predicate.and(book->book.getId()<=param.getId());
            }
        }
        return books.stream().filter(predicate).collect(Collectors.toList());

    }
    @Override
    public List<Book> getBook(Long id) {
        Predicate<Book> predicate= book-> book.getId()==id;
        return books.stream().filter(predicate).collect(Collectors.toList());
    };


    @Override
    public Integer CreateBook(Book book) {
        books.add(book);
        return Math.toIntExact(book.getId());
    }

    @Override
    public Integer UpdateBook(Book book) {
        for(Book bookitem: books){
            if(bookitem.getId()==book.getId()){
                bookitem.setId(book.getId());
                bookitem.setTitle(book.getTitle());
                bookitem.setAuthor(book.getAuthor());
                bookitem.setPrice(book.getPrice());
                bookitem.setPublishedDate(book.getPublishedDate());
            }
        }
        return Math.toIntExact(book.getId());
    }

    @Override
    public Long deleteBook(Long id) {
        books.remove(books.stream().filter(book-> book.getId()==id));
        return id;
    }
}
