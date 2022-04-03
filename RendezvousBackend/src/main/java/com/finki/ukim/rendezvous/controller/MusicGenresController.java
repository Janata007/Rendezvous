package com.finki.ukim.rendezvous.controller;

import com.finki.ukim.rendezvous.model.MusicGenres;
import com.finki.ukim.rendezvous.service.MusicGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
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

}
