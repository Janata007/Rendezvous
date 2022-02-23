package com.finki.ukim.rendezvous.controller;

import com.finki.ukim.rendezvous.model.Hobbies;
import com.finki.ukim.rendezvous.model.Korisnik;
import com.finki.ukim.rendezvous.service.HobbiesService;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HobbiesController {
    @Autowired
    private HobbiesService hobbiesService;

    @GetMapping("/hobbies")
    public ResponseEntity<List<Hobbies>> getAllHobbies() {
        List<Hobbies> hobbies = new ArrayList<>();
        hobbies = hobbiesService.findAll();
        return new ResponseEntity<>(hobbies, HttpStatus.OK);
    }

    @GetMapping("/hobbies")
    public ResponseEntity<Hobbies> getHobbieByKorisnik(@RequestBody Korisnik korisnik) {
        Optional<Hobbies> hobbiesData = hobbiesService.findByKorisnik(korisnik);
        if (hobbiesData.isPresent()) {
            return new ResponseEntity<>(hobbiesData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/hobbies")
    public ResponseEntity<Hobbies> createHobbies(@RequestBody Hobbies hobbies) {
        try {
            Hobbies _hobbies = hobbiesService
                .save(new Hobbies(hobbies.getHobby(), hobbies.getKorisnik()));
            return new ResponseEntity<>(_hobbies, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/hobbies/{id}")
    public ResponseEntity<HttpStatus> deleteHobby(@PathVariable("id") long id) {
        try {
            hobbiesService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/hobbies")
    public ResponseEntity<HttpStatus> deleteAllHobbies() {
        try {
            hobbiesService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
