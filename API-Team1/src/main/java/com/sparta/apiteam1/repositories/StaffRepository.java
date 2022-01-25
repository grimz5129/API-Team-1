package com.sparta.apiteam1.repositories;

import com.sparta.apiteam1.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
    public List<Staff> findByStoreId(Integer id);
}