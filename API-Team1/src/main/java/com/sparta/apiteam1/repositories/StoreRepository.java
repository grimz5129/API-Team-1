package com.sparta.apiteam1.repositories;

import com.sparta.apiteam1.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StoreRepository extends JpaRepository<Store, Integer> {
}