package com.disney.alkemy.controller;

import com.disney.alkemy.dto.CharacterBasicDTO;
import com.disney.alkemy.dto.CharacterDTO;
import com.disney.alkemy.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @PostMapping
    public ResponseEntity<CharacterDTO> save (@RequestBody CharacterDTO character) {
        CharacterDTO result = characterService.save(character);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

//    @GetMapping
//    public ResponseEntity<List<CharacterBasicDTO>> getByFilters (
//            @RequestParam(required = false) String name,
//            @RequestParam(required = false) Long age,
//            @RequestParam(required = false) Float weight,
//            @RequestParam(required = false) List<Long> moviesId,
//            @RequestParam(required = false, defaultValue = "ASC") String order
//    ) {
//        List<CharacterBasicDTO> characters = characterService.getByFilters(name, age, moviesId, order);
//        return ResponseEntity.ok().body(characters);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterDTO>getById(@PathVariable Long id) {
        CharacterDTO character = characterService.getById(id);
        return ResponseEntity.ok(character);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CharacterDTO> update (@PathVariable Long id, @RequestBody CharacterDTO genre) {
        CharacterDTO result = characterService.update(id, genre);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        characterService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
