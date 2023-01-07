package pl.edu.wszib.newsapi.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Value;

@Value
@ToString
@Getter
@Setter
public class NewsDto {
    @NotBlank
    @Size(min=6, max=100)
    String title;

    @NotBlank @Size(min=6)
    String content;

    @NotBlank
    String author;

    @NotBlank
    String date;
}
