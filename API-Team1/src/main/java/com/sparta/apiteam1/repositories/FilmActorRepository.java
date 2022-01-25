package com.sparta.apiteam1.repositories;

import com.sparta.apiteam1.entities.FilmActor;
import com.sparta.apiteam1.entities.FilmActorId;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface FilmActorRepository extends JpaRepository<FilmActor, FilmActorId> {
    public List<FilmActor> findByIdFilmId(Integer id);

    public void deleteByIdFilmId(Integer id);

    public void deleteByIdActorId(Integer id);
}
