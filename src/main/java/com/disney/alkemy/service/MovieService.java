package com.disney.alkemy.service;

import com.disney.alkemy.dto.MovieDTO;
import com.disney.alkemy.entity.CharacterEntity;
import com.disney.alkemy.entity.MovieEntity;
import com.disney.alkemy.mapper.MovieMapper;
import com.disney.alkemy.repo.CharacterRepo;
import com.disney.alkemy.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private MovieRepo movieRepo;
    @Autowired
    private CharacterRepo characterRepo;
//    @Autowired
//    private MovieSpecification movieSpecification;

    public MovieDTO save(MovieDTO dto) {
        MovieEntity movie = movieMapper.movieDTO2Entity(dto);
        MovieEntity new_movie = movieRepo.save(movie);
        MovieDTO result = movieMapper.movieEntity2DTO(new_movie, true);
        return result;
    }

//    @Override
//    public List<MovieBasicDTO> getByFilters(String name, Long gender, String order) {
//        MovieFiltersDTO filtersDTO = new MovieFiltersDTO(name, gender, order);
//        List<MovieEntity> entities = movieRepository.findAll(movieSpecification.getByFilters(filtersDTO));
//        List<MovieBasicDTO> basicDTOS = movieMapper.movieEntityList2BasicDTOList(entities);
//        return basicDTOS;
//    }

    public MovieDTO getById(Long id) {
        Optional<MovieEntity> entity = movieRepo.findById(id);
        if (!entity.isPresent()) {
            //throw new ParamNotFound(ErrorsEnum.IDMOVIENOTFOUND.getMessage());
        }
        MovieDTO movie = movieMapper.movieEntity2DTO(entity.get(), true);
        //AGREGAR LOAD PAISES = TRUE
        return movie;
    }

    public MovieDTO addCharacter(Long id, Long characterId) {
        Optional<MovieEntity> movieOptional = movieRepo.findById(id);
        if (!movieOptional.isPresent()) {
            //throw new ParamNotFound(ErrorsEnum.IDMOVIENOTFOUND.getMessage());
        }
        MovieEntity movie = movieOptional.get();
        Optional<CharacterEntity> characterOptional = characterRepo.findById(characterId);
        if (!characterOptional.isPresent()) {
            //throw new ParamNotFound(ErrorsEnum.IDCHARACTERNOTFOUND.getMessage());
        }
        CharacterEntity character = characterOptional.get();
        movie.getCharacters().add(character);
        movieRepo.save(movie);
        MovieDTO result = movieMapper.movieEntity2DTO(movie, true);
        return result;
    }

    public MovieDTO deleteCharacter(Long id, Long characterId) {
        Optional<MovieEntity> movieOptional = movieRepo.findById(id);
        if (!movieOptional.isPresent()) {
            //throw new ParamNotFound(ErrorsEnum.IDMOVIENOTFOUND.getMessage());
        }
        MovieEntity movie = movieOptional.get();
        Optional<CharacterEntity> characterOptional = characterRepo.findById(characterId);
        if (!characterOptional.isPresent()) {
            //throw new ParamNotFound(ErrorsEnum.IDCHARACTERNOTFOUND.getMessage());
        }
        CharacterEntity character = characterOptional.get();
        movie.getCharacters().remove(character);
        movieRepo.save(movie);
        MovieDTO movie2 = movieMapper.movieEntity2DTO(movie, true);
        return movie2;
    }

    public MovieDTO update(Long id, MovieDTO dto) {
        Optional<MovieEntity> entity = movieRepo.findById(id);
        if (!entity.isPresent()) {
            //throw new ParamNotFound(ErrorsEnum.IDMOVIENOTFOUND.getMessage());
        }
        movieMapper.update(entity.get(), dto);
        movieRepo.save(entity.get());
        MovieDTO result = movieMapper.movieEntity2DTO(entity.get(), true);
        return result;
    }

    public void delete(Long id) {
        Optional<MovieEntity> entity = movieRepo.findById(id);
        if (!entity.isPresent()) {
            //throw new ParamNotFound(ErrorsEnum.IDMOVIENOTFOUND.getMessage());
        }
        movieRepo.deleteById(id);
    }
}