package com.finki.ukim.rendezvous.repository;

import com.finki.ukim.rendezvous.model.Hobbies;
import com.finki.ukim.rendezvous.model.Korisnik;
import com.finki.ukim.rendezvous.model.Sports;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbiesRepository extends JpaRepository<Hobbies, Long> {
    List<Hobbies> findAll();
    Sports findByKorisnik(Korisnik korisnik);
}
