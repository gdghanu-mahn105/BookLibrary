package com.example.BookLibrary.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter


public class Book {
    private long id;
    private String title;
    private String author;
    private double price;
    private LocalDate publishedDate;


}
