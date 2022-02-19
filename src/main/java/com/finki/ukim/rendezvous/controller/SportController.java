package com.finki.ukim.rendezvous.controller;

import com.finki.ukim.rendezvous.model.Sport;
import com.finki.ukim.rendezvous.repository.SportRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SportController {
    @Autowired
    SportRepository sportRepository;
    @GetMapping("/allSports")
    public ResponseEntity<List<Sport>> getAllSports(){
        List<Sport> sports = new ArrayList<>();
        sports = sportRepository.findAll();
        return new ResponseEntity<>(sports, HttpStatus.OK);
    }
}
