package com.finki.ukim.rendezvous.service.impl;

import com.finki.ukim.rendezvous.model.Korisnik;
import com.finki.ukim.rendezvous.model.Sports;
import com.finki.ukim.rendezvous.repository.SportsRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportsServiceImpl {
    @Autowired
    private SportsRepository sportsRepository;

    public List<Sports> findAll() {
        return this.sportsRepository.findAll();
    }

    public List<Sports> findByKorisnik(Korisnik korisnik) {
        return this.sportsRepository.findByKorisnik(korisnik);
    }

    public Sports save(Sports s) {
        return this.sportsRepository.save(s);
    }

    public void deleteById(long id) {
        this.sportsRepository.deleteById(id);
    }

    public void deleteAll() {
        this.sportsRepository.deleteAll();
    }

}
