package com.disney.alkemy.mapper;

import com.disney.alkemy.dto.GenreDTO;
import com.disney.alkemy.entity.GenreEntity;
import org.springframework.stereotype.Component;

@Component
public class GenreMapper {

    public GenreEntity genreDTO2Entity(GenreDTO dto) {
        GenreEntity genre = new GenreEntity();
        genre.setImage(dto.getImage());
        genre.setName(dto.getName());
        return genre;
    }

    public GenreDTO genreEntity2DTO(GenreEntity entity) {
        GenreDTO dto = new GenreDTO();
        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setName(entity.getName());
        return dto;
    }

}
