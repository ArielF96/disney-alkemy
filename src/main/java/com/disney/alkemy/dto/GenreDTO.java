package com.disney.alkemy.dto;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class GenreDTO {
    private Long id;
    //@NotNull(message = "Please insert a valid name")
    private String name;
    private String image;

}