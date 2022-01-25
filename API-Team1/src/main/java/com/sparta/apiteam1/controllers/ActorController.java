package com.sparta.apiteam1.controllers;

import com.sparta.apiteam1.entities.Actor;
import com.sparta.apiteam1.repositories.ActorRepository;
import com.sparta.apiteam1.repositories.FilmActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
public class ActorController {
    @Autowired
    private ActorRepository actorRepo;
    @Autowired
    private FilmActorRepository filmActorRepo;

    @GetMapping(value = "/sakila/actors")
    public List<Actor> getActors(){
        return actorRepo.findAll();
    }
    @GetMapping(value = "/sakila/actor")
    public Actor getActor(@RequestParam Integer id){
        Optional<Actor> result = actorRepo.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        else{
            return null;
        }
    }
    @PutMapping(value = "/sakila/actor/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Actor updateActor(@RequestBody Actor newState){
        Optional<Actor> oldState = actorRepo.findById(newState.getId());
        if(oldState.isEmpty()) return null;
        actorRepo.save(newState);
        return newState;
    }

    @Transactional
    @DeleteMapping(value = "/sakila/actor/delete")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteActor(@RequestParam Integer id){
        filmActorRepo.deleteByIdActorId(id);
        actorRepo.deleteById(id);
    }

    @PostMapping(value = "/sakila/actor/add")
    public Actor insertActor(@RequestBody Actor newActor){
        actorRepo.save(newActor);
        return newActor;
    }
    @GetMapping(value = "/example")
    public ResponseEntity<String> getResponse(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .header("content-type", "whatever")
                .body("Thos os my return value");
    }
}