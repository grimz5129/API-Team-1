package com.sparta.apiteam1.repositories;

import com.sparta.apiteam1.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Integer> {
}
