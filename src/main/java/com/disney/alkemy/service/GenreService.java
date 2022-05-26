package com.disney.alkemy.service;

import com.disney.alkemy.dto.GenreDTO;
import com.disney.alkemy.entity.GenreEntity;
import com.disney.alkemy.mapper.GenreMapper;
import com.disney.alkemy.repo.GenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    @Autowired
    private GenreMapper genreMapper;
    @Autowired
    private GenreRepo genreRepo;

    public GenreDTO save(GenreDTO dto) {
        GenreEntity genre = genreMapper.genreDTO2Entity(dto);
        GenreEntity new_genre = genreRepo.save(genre);
        GenreDTO result = genreMapper.genreEntity2DTO(new_genre);
        return result;
    }

//    public List<GenreDTO> findAll() {
//        List<GenreEntity> entities = genreRepo.findAll();
//        List<GenreDTO> dtos = genreMapper.genreEntityList2DTOList(entities);
//        return dtos;
//    }

    public GenreDTO getDetailsById(Long id) {
        Optional<GenreEntity> entity = genreRepo.findById(id);
        if (entity.isPresent()) {
            GenreDTO dto = genreMapper.genreEntity2DTO(entity.get());
            return dto;
        }
        return null;
    }

}