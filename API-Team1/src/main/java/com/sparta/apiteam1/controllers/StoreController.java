package com.sparta.apiteam1.controllers;


import com.sparta.apiteam1.entities.Actor;
import com.sparta.apiteam1.entities.Film;

import com.sparta.apiteam1.entities.Staff;
import com.sparta.apiteam1.entities.Store;
import com.sparta.apiteam1.repositories.StaffRepository;
import com.sparta.apiteam1.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class StoreController {
    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private StaffRepository staffRepository;

    //CREATE
    @PostMapping(value = "/sakila/store/add")
    public Store insertStore(@RequestBody Store newStore){
        Optional<Store> staffExists = storeRepository.findById(newStore.getId());
        if(staffExists.isEmpty()){
            storeRepository.save(newStore);
            return newStore;
        }
        return null;
    }
    //UPDATE
    @PutMapping(value = "/sakila/store/update")
    public Store updateStore(@RequestBody Store newState){
        Optional<Store> oldState = storeRepository.findById(newState.getId());
        if(oldState.isEmpty()) return null;
        storeRepository.save(newState);
        return newState;
    }
    //READ
    @GetMapping(value = "/sakila/stores")
    public List<Store> getStores() { return storeRepository.findAll(); }
    @GetMapping(value = "/sakila/store")
    public Store getStore(@RequestParam Integer id){
        Optional<Store> result = storeRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        } else {
            return null;
        }
    }

    //DELETE
    @DeleteMapping(value = "/sakila/store/delete")
    public void deleteStore(@RequestParam Integer id){
        storeRepository.deleteById(id);
    }

    // GET STORE and STAFF
    @GetMapping(value = "/sakila/staff/store")
    public List<Object> getStoreAndStaff(@RequestParam Integer id) {
        List<Object> returnList = new ArrayList<>();
        Optional<Store> store = storeRepository.findById(id);
        List<Staff> staff = staffRepository.findByStoreId(id);
        if(store.isPresent() && !staff.isEmpty()) {
            returnList.add(store);
            returnList.add(staff);
        }
        return returnList;
    }
}