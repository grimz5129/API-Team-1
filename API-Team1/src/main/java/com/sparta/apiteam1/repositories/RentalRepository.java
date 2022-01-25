package com.sparta.apiteam1.repositories;

import com.sparta.apiteam1.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
    public void deleteByInventoryId(Integer id);
}
