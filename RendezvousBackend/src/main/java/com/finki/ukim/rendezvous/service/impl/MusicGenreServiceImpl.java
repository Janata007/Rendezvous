package com.finki.ukim.rendezvous.service.impl;

import com.finki.ukim.rendezvous.model.Korisnik;
import com.finki.ukim.rendezvous.model.MusicGenres;
import com.finki.ukim.rendezvous.repository.MusicGenresRepository;
import com.finki.ukim.rendezvous.service.MusicGenreService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MusicGenreServiceImpl implements MusicGenreService {

    private final  MusicGenresRepository musicGenresRepository;

    public MusicGenreServiceImpl(MusicGenresRepository musicGenresRepository) {
        this.musicGenresRepository = musicGenresRepository;
    }

    @Override
    public List<MusicGenres> findAll() {
        return this.musicGenresRepository.findAll();
    }

    @Override
    public List<MusicGenres> findByKorisnik(Korisnik korisnik) {
        return this.musicGenresRepository.findByKorisnik(korisnik);
    }
}
