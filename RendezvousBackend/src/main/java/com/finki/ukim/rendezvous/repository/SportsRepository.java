package com.finki.ukim.rendezvous.repository;

import com.finki.ukim.rendezvous.model.Korisnik;
import com.finki.ukim.rendezvous.model.Sports;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportsRepository extends JpaRepository<Sports, Long> {
    List<Sports> findAll();

    List<Sports> findByKorisnik(Korisnik korisnik);
}
