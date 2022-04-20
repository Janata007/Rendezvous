package com.finki.ukim.rendezvous.controller;

import com.finki.ukim.rendezvous.exceptions.*;
import com.finki.ukim.rendezvous.model.*;
import com.finki.ukim.rendezvous.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/korisniciApi")
public class KorisnikController {
    private final KorisnikService korisnikService;
    private final HobbiesService hobbiesService;
    private final SportsService sportsService;
    private final LocationsService locationsService;
    private final MusicGenreService musicGenreService;

    public KorisnikController(KorisnikService korisnikService, MusicGenreService musicGenreService,
                              SportsService sportsService,
                              HobbiesService hobbiesService, LocationsService locationsService) {
        this.korisnikService = korisnikService;
        this.hobbiesService = hobbiesService;
        this.sportsService = sportsService;
        this.locationsService = locationsService;
        this.musicGenreService = musicGenreService;
    }

    @PutMapping("/{korisnikId}/sports/{sportId}")
    Korisnik addSportForUser(@PathVariable long sportId, @PathVariable long korisnikId) {
        Sports sport = this.sportsService.findById(sportId).orElseThrow(() -> new SportNotFoundException(sportId));
        Korisnik korisnik =
                this.korisnikService.findById(korisnikId).orElseThrow(() -> new UserNotFoundException(korisnikId));
        korisnik.addSport(sport);
        return this.korisnikService.save(korisnik);
    }

    @PutMapping("/{korisnikId}/hobbies/{hobbyId}")
    Korisnik addHobbyForUser(@PathVariable long hobbyId, @PathVariable long korisnikId) {
        Hobbies hobby = this.hobbiesService.findById(hobbyId).orElseThrow(() -> new HobbyNotFoundException(hobbyId));
        Korisnik korisnik =
                this.korisnikService.findById(korisnikId).orElseThrow(() -> new UserNotFoundException(korisnikId));
        korisnik.addHobby(hobby);
        return this.korisnikService.save(korisnik);
    }

    @PutMapping("/{korisnikId}/locations/{locationId}")
    Korisnik addLocationForUser(@PathVariable long locationId, @PathVariable long korisnikId) {
        Locations location =
                this.locationsService.findById(locationId).orElseThrow(() -> new LocationNotFoundException(locationId));
        Korisnik korisnik =
                this.korisnikService.findById(korisnikId).orElseThrow(() -> new UserNotFoundException(korisnikId));
        korisnik.addLocation(location);
        return this.korisnikService.save(korisnik);
    }

    @PutMapping("/{korisnikId}/music/{musicId}")
    Korisnik addMusicForUser(@PathVariable long musicId, @PathVariable long korisnikId) {
        MusicGenres musicGenre =
                this.musicGenreService.findById(musicId).orElseThrow(() -> new MusicGenreNotFoundException(musicId));
        Korisnik korisnik =
                this.korisnikService.findById(korisnikId).orElseThrow(() -> new UserNotFoundException(korisnikId));
        korisnik.addMusicGenre(musicGenre);
        return this.korisnikService.save(korisnik);
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

    @GetMapping("/users/{id}/sports")
    public ResponseEntity<Set<Sports>> getSportsForKorisnikById(@PathVariable("id") long id) {
        Optional<Korisnik> korisnikData = this.korisnikService.findById(id);
        if (korisnikData.isPresent()) {
            return new ResponseEntity<Set<Sports>>(korisnikData.get().getSports(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/users/username/{username}")
    public ResponseEntity<Korisnik> getUserByUsername(@PathVariable("username") String username) {
        Optional<Korisnik> korisnikData = this.korisnikService.findByUsername(username);
        if (korisnikData.isPresent()) {
            return new ResponseEntity<Korisnik>(korisnikData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<Korisnik> createKorisnik(@RequestBody Korisnik korisnik) {
        try {
            List<Korisnik> allCurrentKorisnici = this.korisnikService.findAll();
            for (Korisnik k : allCurrentKorisnici) {
                if (korisnik.getUsername().equals(k.getUsername())) {
                    return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
                }
            }
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
            Set<Hobbies> currentHobbies = korisnikData.get().getHobbies();
            for (Hobbies h : korisnik.getHobbies()) {
                for (Hobbies h2 : currentHobbies) {
                    if (!h2.getHobby().equals(h.getHobby())) {
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
