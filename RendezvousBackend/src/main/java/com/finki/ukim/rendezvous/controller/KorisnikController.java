package com.finki.ukim.rendezvous.controller;

import com.finki.ukim.rendezvous.model.Korisnik;
import com.finki.ukim.rendezvous.service.KorisnikService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/korisniciApi")
public class KorisnikController {
    @Autowired
    KorisnikService korisnikService;

    @GetMapping("/users")
    public ResponseEntity<List<Korisnik>> getAllKorisnici() {
        List<Korisnik> korisnici = new ArrayList<>();
        korisnici = korisnikService.findAll();
        return new ResponseEntity<>(korisnici, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Korisnik> getKorisnikById(@PathVariable("id") long id) {
        Optional<Korisnik> korisnikData = korisnikService.findById(id);
        if (korisnikData.isPresent()) {
            return new ResponseEntity<>(korisnikData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<Korisnik> createKorisnik(@RequestBody Korisnik korisnik) {
        try {
            Korisnik _korisnik = korisnikService
                .save(new Korisnik(korisnik.getName(), korisnik.getSurname(), korisnik.getDateOfBirth()));
            return new ResponseEntity<>(_korisnik, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Korisnik> updateTutorial(@PathVariable("id") long id, @RequestBody Korisnik korisnik) {
        Optional<Korisnik> korisnikData = korisnikService.findById(id);
        if (korisnikData.isPresent()) {
            Korisnik _korisnik = korisnikData.get();
            _korisnik.setName(korisnik.getName());
            _korisnik.setSurname(korisnik.getSurname());
            _korisnik.setDateOfBirth(korisnik.getDateOfBirth());
            _korisnik.setSports(korisnik.getSports());
            return new ResponseEntity<>(korisnikService.save(_korisnik), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteKorisnik(@PathVariable("id") long id) {
        try {
            korisnikService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/users")
    public ResponseEntity<HttpStatus> deleteAllKorisnici() {
        try {
            korisnikService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
