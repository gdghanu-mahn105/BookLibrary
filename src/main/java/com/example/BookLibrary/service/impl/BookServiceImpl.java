package com.example.BookLibrary.service.impl;

import com.example.BookLibrary.core.exception.ResourceNotFoundException;
import com.example.BookLibrary.entity.Book;
import com.example.BookLibrary.dto.FilterParamBook;
import com.example.BookLibrary.repository.BookRepository;
import com.example.BookLibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private static final int LESS_MODE = -1;
    private static final int EQUAL_MODE = 0;
    private static final int GREATER_MODE = 1;
    @Autowired
    public BookRepository bookRepository;

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
        return bookRepository.findAll().stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public Book getBookId(Long id) {
//        Predicate<Book> predicate= book-> book.getId()==id;
        return bookRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Book not found"));
    };

    @Override
    public Integer CreateBook(Book book) {
        bookRepository.save(book);
        return Math.toIntExact(book.getId());
    }

    @Override
    public Integer UpdateBook(Book book) {
        if (book != null) {
            Book existingBook = bookRepository.findById(book.getId())
                    .orElseThrow(() -> new RuntimeException("Book not found with id: " + book.getId()));
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setPrice(book.getPrice());
            existingBook.setPublishedDate(book.getPublishedDate());
            bookRepository.save(existingBook);
        }
        return Math.toIntExact(book.getId());
    }

    @Override
    public Long deleteBook(Long id) {
        bookRepository.delete(bookRepository.getReferenceById(id));
        return id;
    }
}
