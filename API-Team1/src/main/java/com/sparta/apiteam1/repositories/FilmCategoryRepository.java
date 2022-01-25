package com.sparta.apiteam1.repositories;

import com.sparta.apiteam1.entities.FilmCategory;
import com.sparta.apiteam1.entities.FilmCategoryId;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface FilmCategoryRepository extends JpaRepository<FilmCategory, FilmCategoryId> {
    public void deleteByIdFilmId(Integer id);
}
