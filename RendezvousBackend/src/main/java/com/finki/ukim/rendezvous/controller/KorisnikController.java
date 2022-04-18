package com.finki.ukim.rendezvous.controller;

import com.finki.ukim.rendezvous.model.Hobbies;
import com.finki.ukim.rendezvous.model.Korisnik;
import com.finki.ukim.rendezvous.service.HobbiesService;
import com.finki.ukim.rendezvous.service.KorisnikService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/korisniciApi")
public class KorisnikController {
    private final KorisnikService korisnikService;
    private final HobbiesService hobbiesService;

    public KorisnikController(KorisnikService korisnikService, HobbiesService hobbiesService) {
        this.korisnikService = korisnikService;
        this.hobbiesService = hobbiesService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<Korisnik>> getAllKorisnici() {
        List<Korisnik> korisnici = new ArrayList<>();
        korisnici = this.korisnikService.findAll();
        return new ResponseEntity<>(korisnici, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Korisnik> getKorisnikById(@PathVariable("id") long id) {
        Optional<Korisnik> korisnikData = this.korisnikService.findById(id);
        if (korisnikData.isPresent()) {
            return new ResponseEntity<>(korisnikData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<Korisnik> createKorisnik(@RequestBody Korisnik korisnik) {
        try {
            Korisnik _korisnik = this.korisnikService
                .save(new Korisnik(korisnik.getPassword(), korisnik.getUsername(), korisnik.getName(),
                    korisnik.getEmail(), korisnik.getSurname(), korisnik.getDateOfBirth(),
                    korisnik.getAppUserRole()));
            return new ResponseEntity<>(_korisnik, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/users/hobbies/{id}")
    public ResponseEntity<Korisnik> updateHobbiesKorisnik(@PathVariable("id") long id, @RequestBody Korisnik korisnik) {
        Optional<Korisnik> korisnikData = this.korisnikService.findById(id);
        if (korisnikData.isPresent()) {
            Korisnik _korisnik = korisnikData.get();
           List<Hobbies> currentHobbies = korisnikData.get().getHobbies();
            for(Hobbies h : korisnik.getHobbies()){
             for(Hobbies h2 : currentHobbies){
                 if(!h2.getHobby().equals(h.getHobby())){
                     System.out.println("HOBBIES: " + hobbiesService.findAll());
                 }
             }
            }
            _korisnik.setHobbies(korisnik.getHobbies());
            return new ResponseEntity<>(korisnikService.save(_korisnik), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteKorisnik(@PathVariable("id") long id) {
        try {
            this.korisnikService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/users")
    public ResponseEntity<HttpStatus> deleteAllKorisnici() {
        try {
            this.korisnikService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
