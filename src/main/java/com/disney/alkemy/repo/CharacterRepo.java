package com.disney.alkemy.repo;

import java.util.List;

import com.disney.alkemy.entity.CharacterEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepo extends JpaRepository<CharacterEntity, Long>{

    List<CharacterEntity> findAll(Specification<CharacterEntity> spec);

}