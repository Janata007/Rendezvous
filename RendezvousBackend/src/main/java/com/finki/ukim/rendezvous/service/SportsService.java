package com.finki.ukim.rendezvous.service;

import com.finki.ukim.rendezvous.model.Korisnik;
import com.finki.ukim.rendezvous.model.Sports;

import java.util.List;

public interface SportsService {
    public List<Sports> findAll();
    public List<Sports> findByKorisnik(Korisnik korisnik);
    public Sports save(Sports s);
    public void deleteById(long id);
    public void deleteAll();
}
