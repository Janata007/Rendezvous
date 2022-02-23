package com.finki.ukim.rendezvous.repository;

import com.finki.ukim.rendezvous.model.Hobbies;
import com.finki.ukim.rendezvous.model.Korisnik;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbiesRepository extends JpaRepository<Hobbies, Long> {
    List<Hobbies> findAll();

    Optional<Hobbies> findByKorisnik(Korisnik korisnik);
}