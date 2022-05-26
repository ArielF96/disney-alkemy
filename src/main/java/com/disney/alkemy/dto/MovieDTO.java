package com.disney.alkemy.dto;

import java.time.LocalDate;
import java.util.List;

import com.disney.alkemy.entity.CharacterEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieDTO {

    private Long id;
    private String image;
    private String title;
    private LocalDate creationDate;
    //@Range(min = 0, max = 5, message = "must be a number between 1 and 5")
    private int rating;
    //@NotNull(message = "Please insert a valid gender")
    private Long genreId;
    private List<CharacterEntity> characters;

}

