package com.example.BookLibrary.controller;

import com.example.BookLibrary.dto.FilterParamBook;
import com.example.BookLibrary.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {
    private final BookService bookService;
/*
private Long id;
    private String title;
    private String author;
    private Double price;
    private LocalDate publishedDate;
    private Integer IdMode;
 */
    @GetMapping
    public ResponseEntity<?> getBook(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "idMode",required = false) Integer idMode,
            @RequestParam(value = "title",required = false) String title,
            @RequestParam(value = "author",required = false) String author,
            @RequestParam(value = "price",required = false) Double price) {
        FilterParamBook filterParamBook= new FilterParamBook();
        filterParamBook.setId(id);
        filterParamBook.setIdMode(idMode);
        filterParamBook.setTitle(title);
        filterParamBook.setAuthor(author);
        filterParamBook.setPrice(price);
        return ResponseEntity.ok( bookService.getBook(filterParamBook));
    };

    @PostMapping
    public ResponseEntity<?> createBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.CreateBook(book));
    };

    @PatchMapping
    public ResponseEntity<?> updateBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.UpdateBook(book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") long id) {
        return ResponseEntity.ok(bookService.deleteBook(id));
    };




}
