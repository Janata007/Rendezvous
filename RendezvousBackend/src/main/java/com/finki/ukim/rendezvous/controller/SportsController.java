package com.finki.ukim.rendezvous.controller;

import com.finki.ukim.rendezvous.model.Sports;
import com.finki.ukim.rendezvous.service.SportsService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/sportsApi")
public class SportsController {

    private final SportsService sportsService;

    public SportsController(SportsService sportsService) {
        this.sportsService = sportsService;
    }

    @GetMapping("/sports")
    public ResponseEntity<List<Sports>> getAllSports() {
        List<Sports> sports = new ArrayList<>();
        sports = this.sportsService.findAll();
        return new ResponseEntity<>(sports, HttpStatus.OK);
    }

    @PostMapping("/sports")
    public ResponseEntity<Sports> createSports(@RequestBody Sports sports) {
        try {
            Sports _sports = this.sportsService
                .save(new Sports(sports.getSport()));
            return new ResponseEntity<>(_sports, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/sports/{id}")
    public ResponseEntity<HttpStatus> deleteSport(@PathVariable("id") long id) {
        try {
            this.sportsService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/sports")
    public ResponseEntity<HttpStatus> deleteAllSports() {
        try {
            this.sportsService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
