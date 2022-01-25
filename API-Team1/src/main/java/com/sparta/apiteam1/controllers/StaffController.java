package com.sparta.apiteam1.controllers;


import com.sparta.apiteam1.entities.Staff;
import com.sparta.apiteam1.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StaffController {

    @Autowired
    private StaffRepository theRepository;

    @GetMapping(value = "/sakila/staff")
    public List<Staff> getStaff(){
        return theRepository.findAll();
    }
    @GetMapping(value = "/sakila/staffByID")
    public Staff getStaffByID(@RequestParam Integer id){
        Optional<Staff> result = theRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        else{
            return null;
        }
    }

    @PostMapping(value = "/sakila/staff/add")
    public Staff storeStaff(@RequestBody Staff newStaff){
        Optional<Staff> staffExists = theRepository.findById(newStaff.getId());
        if(staffExists.isEmpty()){
            theRepository.save(newStaff);
            return newStaff;
        }
        return null;
    }


    @PutMapping(value = "/sakila/staff/update")
    public Staff updateStaff(@RequestBody Staff newState){
        Optional<Staff> oldState = theRepository.findById(newState.getId());
        if(oldState.isEmpty()) return null;
        theRepository.save(newState);
        return newState;
    }

    @DeleteMapping(value = "/sakila/staff/delete")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteStaff(@RequestParam Integer id){
        theRepository.deleteById(id);
    }
}