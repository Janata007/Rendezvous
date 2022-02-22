package com.finki.ukim.rendezvous.service;

import com.finki.ukim.rendezvous.model.Korisnik;
import com.finki.ukim.rendezvous.repository.KorisnikRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KorisnikService {
    @Autowired
    KorisnikRepository korisnikRepository;

    public List<Korisnik> findAll() {
        return this.korisnikRepository.findAll();
    }

    public Optional<Korisnik> findById(long id) {
        return this.korisnikRepository.findById(id);
    }

    public Korisnik save(Korisnik k) {
        return this.korisnikRepository.save(k);
    }

    public void deleteById(long id) {
        this.korisnikRepository.deleteById(id);
    }

    public void deleteAll() {
        this.korisnikRepository.deleteAll();
    }
}
