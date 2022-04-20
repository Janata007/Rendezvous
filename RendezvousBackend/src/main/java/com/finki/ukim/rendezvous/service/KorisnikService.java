package com.finki.ukim.rendezvous.service;

import com.finki.ukim.rendezvous.model.Korisnik;

import java.util.List;
import java.util.Optional;

public interface KorisnikService {
    public List<Korisnik> findAll();
    public Optional<Korisnik> findById(long id);
    public Korisnik save(Korisnik k);
    public void deleteById(long id);
    public void deleteAll();
    public Optional<Korisnik> findByUsername(String username);
}
