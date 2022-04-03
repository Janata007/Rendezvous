package com.finki.ukim.rendezvous.controller;

import com.finki.ukim.rendezvous.model.Korisnik;
import com.finki.ukim.rendezvous.model.Sports;
import com.finki.ukim.rendezvous.service.impl.SportsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sportsApi")
public class SportsController {
    @Autowired
    private SportsServiceImpl sportsService;
    @GetMapping("/sports")
    public ResponseEntity<List<Sports>> getAllSports() {
        List<Sports> sports = new ArrayList<>();
        sports = sportsService.findAll();
        return new ResponseEntity<>(sports, HttpStatus.OK);
    }
    @GetMapping("/korisnikSports")
    public ResponseEntity<List<Sports>> getSportsbyKorisnik(@RequestBody Korisnik korisnik) {
        List<Sports> sportsData = sportsService.findByKorisnik(korisnik);
        if (!sportsData.isEmpty()) {
            return new ResponseEntity<List<Sports>>(sportsData, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/sports")
    public ResponseEntity<Sports> createSports(@RequestBody Sports sports) {
        try {
            Sports _sports = sportsService
                    .save(new Sports(sports.getSport(), sports.getKorisnik()));
            return new ResponseEntity<>(_sports, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/sports/{id}")
    public ResponseEntity<HttpStatus> deleteSport(@PathVariable("id") long id) {
        try {
            sportsService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/sports")
    public ResponseEntity<HttpStatus> deleteAllSports() {
        try {
            sportsService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
