package com.finki.ukim.rendezvous.repository;

import com.finki.ukim.rendezvous.model.Korisnik;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
    List<Korisnik> findAll();

    Optional<Korisnik> findById(long id);
    Optional<Korisnik> findByEmail(String email);

    Korisnik save(Korisnik korisnik);

    void deleteById(long id);

    void deleteAll();
}
