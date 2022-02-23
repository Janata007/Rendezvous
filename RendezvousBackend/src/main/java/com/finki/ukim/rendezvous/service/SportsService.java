package com.finki.ukim.rendezvous.service;

import com.finki.ukim.rendezvous.model.Korisnik;
import com.finki.ukim.rendezvous.model.Sports;
import com.finki.ukim.rendezvous.repository.SportsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportsService {
    @Autowired
    private SportsRepository sportsRepository;

    public List<Sports> findAll() {
        return this.sportsRepository.findAll();
    }

    public Optional<Sports> findByKorisnit(Korisnik korisnik) {
        return this.sportsRepository.findByKorisnik(korisnik);
    }

}
