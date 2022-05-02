package com.finki.ukim.rendezvous.controller;

import com.finki.ukim.rendezvous.exceptions.HobbyNotFoundException;
import com.finki.ukim.rendezvous.exceptions.LocationNotFoundException;
import com.finki.ukim.rendezvous.exceptions.MusicGenreNotFoundException;
import com.finki.ukim.rendezvous.exceptions.SportNotFoundException;
import com.finki.ukim.rendezvous.exceptions.UserNotFoundException;
import com.finki.ukim.rendezvous.model.Hobbies;
import com.finki.ukim.rendezvous.model.Korisnik;
import com.finki.ukim.rendezvous.model.Likes;
import com.finki.ukim.rendezvous.model.Locations;
import com.finki.ukim.rendezvous.model.MusicGenres;
import com.finki.ukim.rendezvous.model.Sports;
import com.finki.ukim.rendezvous.service.HobbiesService;
import com.finki.ukim.rendezvous.service.KorisnikService;
import com.finki.ukim.rendezvous.service.LikesService;
import com.finki.ukim.rendezvous.service.LocationsService;
import com.finki.ukim.rendezvous.service.MusicGenreService;
import com.finki.ukim.rendezvous.service.SportsService;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
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
    private final SportsService sportsService;
    private final LocationsService locationsService;
    private final MusicGenreService musicGenreService;
    private final LikesService likesService;

    public KorisnikController(LikesService likesService, KorisnikService korisnikService,
                              MusicGenreService musicGenreService,
                              SportsService sportsService,
                              HobbiesService hobbiesService, LocationsService locationsService) {
        this.korisnikService = korisnikService;
        this.hobbiesService = hobbiesService;
        this.sportsService = sportsService;
        this.locationsService = locationsService;
        this.musicGenreService = musicGenreService;
        this.likesService = likesService;
    }

    @PutMapping("/{korisnikId}/sports/{sportId}")
    Korisnik addSportForUser(@PathVariable long sportId, @PathVariable long korisnikId) {
        Sports sport = this.sportsService.findById(sportId).orElseThrow(() -> new SportNotFoundException(sportId));
        Korisnik korisnik =
            this.korisnikService.findById(korisnikId).orElseThrow(() -> new UserNotFoundException(korisnikId));
        korisnik.addSport(sport);
        return this.korisnikService.save(korisnik);
    }

    @DeleteMapping("/{korisnikId}/sports/{sportId}")
    Korisnik deleteSportForUser(@PathVariable long sportId, @PathVariable long korisnikId) {
        Sports sport = this.sportsService.findById(sportId).orElseThrow(() -> new SportNotFoundException(sportId));
        Korisnik korisnik =
            this.korisnikService.findById(korisnikId).orElseThrow(() -> new UserNotFoundException(korisnikId));
        korisnik.deleteSport(sport);
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

    @DeleteMapping("/{korisnikId}/hobbies/{hobbyId}")
    Korisnik deleteHobbyForUser(@PathVariable long hobbyId, @PathVariable long korisnikId) {
        Hobbies hobby = this.hobbiesService.findById(hobbyId).orElseThrow(() -> new HobbyNotFoundException(hobbyId));
        Korisnik korisnik =
            this.korisnikService.findById(korisnikId).orElseThrow(() -> new UserNotFoundException(korisnikId));
        korisnik.deleteHobby(hobby);
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

    @DeleteMapping("/{korisnikId}/locations/{locationId}")
    Korisnik deleteLocationForUser(@PathVariable long locationId, @PathVariable long korisnikId) {
        Locations location =
            this.locationsService.findById(locationId).orElseThrow(() -> new LocationNotFoundException(locationId));
        Korisnik korisnik =
            this.korisnikService.findById(korisnikId).orElseThrow(() -> new UserNotFoundException(korisnikId));
        korisnik.deleteLocation(location);
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

    @DeleteMapping("/{korisnikId}/music/{musicId}")
    Korisnik deleteMusicForUser(@PathVariable long musicId, @PathVariable long korisnikId) {
        MusicGenres musicGenre =
            this.musicGenreService.findById(musicId).orElseThrow(() -> new MusicGenreNotFoundException(musicId));
        Korisnik korisnik =
            this.korisnikService.findById(korisnikId).orElseThrow(() -> new UserNotFoundException(korisnikId));
        korisnik.deleteMusicGenre(musicGenre);
        return this.korisnikService.save(korisnik);
    }

    @GetMapping("/users")
    public ResponseEntity<List<Korisnik>> getAllKorisnici() {
        List<Korisnik> korisnici = new ArrayList<>();
        korisnici = this.korisnikService.findAll();
        return new ResponseEntity<>(korisnici, HttpStatus.OK);
    }

    @GetMapping("/users/{id}/search")
    public ResponseEntity<List<Korisnik>> getKorisniciForLoggedInUser(@PathVariable long id) {
        List<Korisnik> korisnici = new ArrayList<>();
        korisnici = this.korisnikService.findAll();
        Korisnik loggedIn = this.korisnikService.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        korisnici.remove(loggedIn);
        List<Likes> korisnikLikes = this.likesService.findAllByMainUserId(id);
        for (Likes like : korisnikLikes) {
            for (Korisnik k : korisnici) {
                if (like.getLikedUserId() == k.getId()) {
                    korisnici.remove(k);
                }
            }
        }

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

    @PutMapping("/updateKorisnik/{id}")
    public ResponseEntity<Korisnik> edit(@PathVariable Long id, @RequestBody Korisnik korisnik) {
        try {
            Korisnik korisnik1 = this.korisnikService.edit(id, korisnik);
            return new ResponseEntity<>(korisnik1, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
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
                .save(new Korisnik( korisnik.getName(), korisnik.getSurname(), korisnik.getUsername(), korisnik.getPassword(),
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

    @GetMapping("/geoIP")
    public String getLocation(HttpServletRequest request
    ) throws IOException, GeoIp2Exception {
        String ipAddress = korisnikService.getClientIp(request);
        //String ipAddress = "217.110.78.71";
        return korisnikService.getIpLocation(ipAddress, request);
    }
}
