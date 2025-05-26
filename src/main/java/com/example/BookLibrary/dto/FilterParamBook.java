package com.example.BookLibrary.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FilterParamBook {
    private Long id;
    private String title;
    private String author;
    private Double price;
    private LocalDate publishedDate;
    private Integer IdMode;
}