package com.finki.ukim.rendezvous.service;

import com.finki.ukim.rendezvous.model.Hobbies;
import com.finki.ukim.rendezvous.model.Korisnik;
import com.finki.ukim.rendezvous.model.Sports;
import com.finki.ukim.rendezvous.repository.HobbiesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class HobbiesService {

    @Autowired
    HobbiesRepository hobbiesRepository;

    public List<Hobbies> findAll() {
        return this.hobbiesRepository.findAll();
    }

    public Sports findByKorisnit(Korisnik korisnik) {
        return this.hobbiesRepository.findByKorisnik(korisnik);
    }
}
