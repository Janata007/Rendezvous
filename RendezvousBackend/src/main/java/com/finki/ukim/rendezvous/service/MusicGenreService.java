package com.finki.ukim.rendezvous.service;

import com.finki.ukim.rendezvous.model.Korisnik;
import com.finki.ukim.rendezvous.model.MusicGenres;

import java.util.List;

public interface MusicGenreService {
    List<MusicGenres> findAll();
    List<MusicGenres> findByKorisnik(Korisnik korisnik);
}
