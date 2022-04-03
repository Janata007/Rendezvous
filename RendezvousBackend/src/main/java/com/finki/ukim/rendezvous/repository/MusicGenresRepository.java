package com.finki.ukim.rendezvous.repository;

import com.finki.ukim.rendezvous.model.Korisnik;
import com.finki.ukim.rendezvous.model.MusicGenres;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusicGenresRepository extends JpaRepository<MusicGenres, Long> {
    List<MusicGenres> findByKorisnik(Korisnik korisnik);
}
