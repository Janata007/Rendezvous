package com.finki.ukim.rendezvous.controller;

import com.finki.ukim.rendezvous.model.MusicGenres;
import com.finki.ukim.rendezvous.service.MusicGenreService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/musicApi")
public class MusicGenresController {
    private final MusicGenreService musicGenreService;

    public MusicGenresController(MusicGenreService musicGenreService) {
        this.musicGenreService = musicGenreService;
    }

    @GetMapping("/genres")
    public ResponseEntity<List<MusicGenres>> getAllMusicGenres() {
        List<MusicGenres> genres = new ArrayList<>();
        genres = musicGenreService.findAll();
        return new ResponseEntity<>(genres, HttpStatus.OK);
    }

    @PostMapping("/genres")
    public ResponseEntity<MusicGenres> createMusicGenres(@RequestBody MusicGenres musicGenre) {
        try {
            MusicGenres _musicGenres = this.musicGenreService
                .save(new MusicGenres(musicGenre.getMusicGenre()));
            return new ResponseEntity<MusicGenres>(_musicGenres, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
