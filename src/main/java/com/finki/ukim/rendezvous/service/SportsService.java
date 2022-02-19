package com.finki.ukim.rendezvous.service;

import com.finki.ukim.rendezvous.model.Korisnik;
import com.finki.ukim.rendezvous.model.Sports;
import com.finki.ukim.rendezvous.repository.SportsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class SportsService {
    @Autowired
    SportsRepository sportsRepository;

    public List<Sports> findAll(){
        return this.sportsRepository.findAll();
    }
    public Sports findByKorisnit(Korisnik korisnik){
        return this.sportsRepository.findByKorisnik(korisnik);
    }

}
