package com.finki.ukim.rendezvous.service;

import com.finki.ukim.rendezvous.model.Hobbies;
import com.finki.ukim.rendezvous.model.Korisnik;
import com.finki.ukim.rendezvous.repository.HobbiesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HobbiesService {

    @Autowired
    HobbiesRepository hobbiesRepository;

    public List<Hobbies> findAll() {
        return this.hobbiesRepository.findAll();
    }

    public Optional<Hobbies> findByKorisnik(Korisnik korisnik) {
        return this.hobbiesRepository.findByKorisnik(korisnik);
    }

    public Hobbies save(Hobbies h) {
        return this.hobbiesRepository.save(h);
    }

    public void deleteById(long id) {
        this.hobbiesRepository.deleteById(id);
    }

    public void deleteAll() {
        this.hobbiesRepository.deleteAll();
    }
}
