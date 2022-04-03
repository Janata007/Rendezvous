package com.finki.ukim.rendezvous.service;

import com.finki.ukim.rendezvous.model.Korisnik;
import com.finki.ukim.rendezvous.model.Locations;

import java.util.List;

public interface LocationsService {
    public List<Locations> findAll();
    public List<Locations> findByKorisnik(Korisnik korisnik);
    public Locations save(Locations l);
    public void deleteById(long id);
    public void deleteAll();

}
