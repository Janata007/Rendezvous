package com.finki.ukim.rendezvous.service.impl;

import com.finki.ukim.rendezvous.model.Korisnik;
import com.finki.ukim.rendezvous.repository.KorisnikRepository;
import java.util.List;
import java.util.Optional;

import com.finki.ukim.rendezvous.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KorisnikServiceImpl implements KorisnikService {

    private final KorisnikRepository korisnikRepository;

    public KorisnikServiceImpl(KorisnikRepository korisnikRepository) {
        this.korisnikRepository = korisnikRepository;
    }

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
