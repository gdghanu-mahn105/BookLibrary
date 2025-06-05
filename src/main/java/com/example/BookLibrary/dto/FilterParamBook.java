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

    @NotBlank (message = "Title can not be blank")
    private String title;

    @NotBlank(message = "Author can not be blank")
    private String author;

    @Size(min = 1,message = "Price must be greater than 0")
    private Double price;
    private LocalDate publishedDate;
    private Integer IdMode;
}