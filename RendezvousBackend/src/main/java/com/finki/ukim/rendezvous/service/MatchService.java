package com.finki.ukim.rendezvous.service;

import com.finki.ukim.rendezvous.exceptions.UserNotFoundException;
import com.finki.ukim.rendezvous.model.Korisnik;
import org.springframework.stereotype.Service;

@Service
public class MatchService {
    private LikesService likesService;
    private KorisnikService korisnikService;

    public MatchService(LikesService likesService, KorisnikService korisnikService) {
        this.likesService = likesService;
        this.korisnikService = korisnikService;
    }

    public String percentMatch(long id1, long id2) {
        Korisnik korisnik1 = this.korisnikService.findById(id1).orElseThrow(() -> new UserNotFoundException(id1));
        Korisnik korisnik2 = this.korisnikService.findById(id2).orElseThrow(() -> new UserNotFoundException(id2));
        //TO DO: implement algorithm for matching
        Double percent = 0.0;
        return percent.toString();
    }
}
