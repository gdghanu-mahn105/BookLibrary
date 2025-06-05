package com.example.BookLibrary.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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