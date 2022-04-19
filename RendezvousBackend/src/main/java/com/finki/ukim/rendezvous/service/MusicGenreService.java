package com.finki.ukim.rendezvous.service;

import com.finki.ukim.rendezvous.model.Korisnik;
import com.finki.ukim.rendezvous.model.MusicGenres;

import com.finki.ukim.rendezvous.model.Sports;
import java.util.List;
import java.util.Optional;

public interface MusicGenreService {
    List<MusicGenres> findAll();
    Optional<MusicGenres> findById(long id);
    MusicGenres save(MusicGenres s);

}
