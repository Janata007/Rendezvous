package com.finki.ukim.rendezvous.controller;

import com.finki.ukim.rendezvous.model.Korisnik;
import com.finki.ukim.rendezvous.repository.KorisnikRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class KorisnikController {
    @Autowired
    KorisnikRepository korisnikRepository;

    @GetMapping("/users")
    public ResponseEntity<List<Korisnik>> getAllSports() {
        List<Korisnik> korisnici = new ArrayList<>();
        korisnici = korisnikRepository.findAll();
        return new ResponseEntity<>(korisnici, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Korisnik> getKorisnikById(@PathVariable("id") long id) {
        Optional<Korisnik> korisnikData = korisnikRepository.findById(id);
        if (korisnikData.isPresent()) {
            return new ResponseEntity<>(korisnikData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<Korisnik> createKorisnik(@RequestBody Korisnik korisnik) {
        try {
            Korisnik _korisnik = korisnikRepository
                .save(new Korisnik(korisnik.getName(), korisnik.getSurname(), korisnik.getDateOfBirth(),
                    korisnik.getSport()));
            return new ResponseEntity<>(_korisnik, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Korisnik> updateTutorial(@PathVariable("id") long id, @RequestBody Korisnik korisnik) {
        Optional<Korisnik> korisnikData = korisnikRepository.findById(id);
        if (korisnikData.isPresent()) {
            Korisnik _korisnik = korisnikData.get();
            _korisnik.setName(korisnik.getName());
            _korisnik.setSurname(korisnik.getSurname());
            _korisnik.setDateOfBirth(korisnik.getDateOfBirth());
            _korisnik.setSport(korisnik.getSport());
            return new ResponseEntity<>(korisnikRepository.save(_korisnik), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        try {
            korisnikRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/users")
    public ResponseEntity<HttpStatus> deleteAllKorisniks() {
        try {
            korisnikRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
