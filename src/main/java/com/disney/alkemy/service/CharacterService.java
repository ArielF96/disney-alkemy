package com.disney.alkemy.service;

import java.util.List;
import java.util.Optional;

import com.disney.alkemy.dto.CharacterBasicDTO;
import com.disney.alkemy.dto.CharacterDTO;
import com.disney.alkemy.entity.CharacterEntity;
import com.disney.alkemy.mapper.CharacterMapper;
import com.disney.alkemy.repo.CharacterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

    @Service
    public class CharacterService {

        @Autowired
        private CharacterMapper characterMapper;
        @Autowired
        private CharacterRepo characterRepository;
//        @Autowired
//        private CharacterSpecification characterSpecification;

        public CharacterDTO save(CharacterDTO dto) {
            CharacterEntity character = characterMapper.characterDTO2Entity(dto);
            CharacterEntity new_character = characterRepository.save(character);
            CharacterDTO result = characterMapper.characterEntity2DTO(new_character, true);
            return result;
        }

//        @Override
//        public List<CharacterBasicDTO> getByFilters(String name, Long age, List<Long> moviesId, String order) {
//            CharacterFiltersDTO filtersDTO = new CharacterFiltersDTO(name, age, moviesId, order);
//            List<CharacterEntity> entities = characterRepository.findAll(characterSpecification.getByFilters(filtersDTO));
//            List<CharacterBasicDTO> dtos = characterMapper.characterEntityList2BasicDTOList(entities);
//            return dtos;
//        }

        public CharacterDTO getById(Long id) {
            Optional<CharacterEntity> entity = characterRepository.findById(id);
            if (!entity.isPresent()) {
                //throw new ParamNotFound(ErrorsEnum.IDCHARACTERNOTFOUND.getMessage());
            }
            CharacterDTO character = characterMapper.characterEntity2DTO(entity.get(), true);
            return character;
        }

        public CharacterDTO update(Long id, CharacterDTO dto) {
            Optional<CharacterEntity> entity = characterRepository.findById(id);
            if (!entity.isPresent()) {
                //throw new ParamNotFound(ErrorsEnum.IDCHARACTERNOTFOUND.getMessage());
            }
            characterMapper.update(entity.get(), dto);
            characterRepository.save(entity.get());
            CharacterDTO result = characterMapper.characterEntity2DTO(entity.get(), true);// CONSULTAR COMO AGREGAR EL LOADPELICULAS FALSE
            return result;
        }

        public void delete(Long id) {
            Optional<CharacterEntity> entity = characterRepository.findById(id);
            if (!entity.isPresent()) {
                //throw new ParamNotFound(ErrorsEnum.IDCHARACTERNOTFOUND.getMessage());
            }
            characterRepository.delete(entity.get());
        }

    }
