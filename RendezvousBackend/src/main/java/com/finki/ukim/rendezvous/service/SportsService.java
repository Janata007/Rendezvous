package com.finki.ukim.rendezvous.service;

import com.finki.ukim.rendezvous.model.Korisnik;
import com.finki.ukim.rendezvous.model.Sports;

import java.util.List;
import java.util.Optional;

public interface SportsService {
    public List<Sports> findAll();
    public Sports save(Sports s);
    public void deleteById(long id);
    public Optional<Sports> findById(long id);
    public void deleteAll();
}
