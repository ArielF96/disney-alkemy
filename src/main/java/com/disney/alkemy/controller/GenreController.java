package com.disney.alkemy.controller;

import com.disney.alkemy.dto.GenreDTO;
import com.disney.alkemy.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @PostMapping
    public ResponseEntity<GenreDTO> save (@RequestBody GenreDTO genre) {
        GenreDTO new_genre = genreService.save(genre);
        return ResponseEntity.status(HttpStatus.CREATED).body(new_genre);
    }

//    @GetMapping
//    public ResponseEntity<List<GenreDTO>> findAll() {
//        List<GenreDTO> genres = this.genreService.findAll();
//        return ResponseEntity.ok(genres);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreDTO> getDetailsById(@PathVariable Long id) {
        GenreDTO genre = this.genreService.getDetailsById(id);
        return ResponseEntity.ok(genre);
    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<GenreDTO> delete(@PathVariable Long id) {
//        this.genreService.delete(id);
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }
}
