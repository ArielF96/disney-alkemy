package com.disney.alkemy.repo;

import java.util.List;

import com.disney.alkemy.entity.MovieEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepo extends JpaRepository<MovieEntity, Long>{

    List<MovieEntity> findAll(Specification<MovieEntity> spec);

}
