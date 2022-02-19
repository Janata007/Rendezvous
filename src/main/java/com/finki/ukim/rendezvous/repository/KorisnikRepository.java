package com.finki.ukim.rendezvous.repository;

import com.finki.ukim.rendezvous.model.Korisnik;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
    List<Korisnik> findAll();
    Optional<Korisnik> findById(long id);
    Korisnik save(Korisnik korisnik);
    void deleteById(long id);
    void deleteAll();
}
