package com.sparta.apiteam1.repositories;

import com.sparta.apiteam1.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
}