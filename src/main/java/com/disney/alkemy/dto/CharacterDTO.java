package com.disney.alkemy.dto;


import com.disney.alkemy.entity.MovieEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CharacterDTO {

    private Long id;
    private String image;
    private String name;
    private Long age;
    private float weight;
    private String history;
    private List<MovieEntity> movies;

}
