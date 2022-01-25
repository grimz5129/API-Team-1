package com.sparta.apiteam1.controllers;

import com.sparta.apiteam1.entities.*;
import com.sparta.apiteam1.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
public class FilmController {
    @Autowired
    private FilmRepository filmRepo;
    @Autowired
    private FilmActorRepository filmActorRepo;
    @Autowired
    private FilmCategoryRepository filmCategoryRepo;
    @Autowired
    private InventoryRepository inventoryRepo;
    @Autowired
    private RentalRepository rentalRepo;

    // Get-All
    @GetMapping(value = "/sakila/films")
    public List<Film> getFilms() { return filmRepo.findAll(); }

    // Get by ID
    @GetMapping(value = "/sakila/film")
    public Film getFilm(@RequestParam Integer id) {
        Optional<Film> result = filmRepo.findById(id);
        if(result.isPresent()){
            return result.get();
        } else {
            return null;
        }
    }

    // Update film
    @PutMapping(value = "/sakila/film/update")
    public Film updateFilm(@RequestBody Film newState) {
        Optional<Film> oldState = filmRepo.findById(newState.getId());
        if(oldState.isEmpty()) return null;

        filmRepo.save(newState);
        return newState;
    }

    // Insert Film
    @PostMapping(value = "/sakila/film/add")
    public Film insertActor(@RequestBody Film newFilm){
        filmRepo.save(newFilm);
        return newFilm;
    }

    // Delete Film by ID
    @Transactional
    @DeleteMapping(value = "/sakila/film/delete")
    public void deleteFilm(@RequestParam Integer id){
        filmActorRepo.deleteByIdFilmId(id);
        filmCategoryRepo.deleteByIdFilmId(id);
        List<Inventory> inventories = inventoryRepo.findByFilmId(id);
        for (Inventory inventory: inventories) {
            rentalRepo.deleteByInventoryId(inventory.getId());
        }
        inventoryRepo.deleteByFilmId(id);
        filmRepo.deleteById(id);
    }
}
