package com.sparta.apiteam1.repositories;

import com.sparta.apiteam1.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;


public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    public List<Inventory> findByFilmId(Integer id);
    public void deleteByFilmId(Integer id);
}
