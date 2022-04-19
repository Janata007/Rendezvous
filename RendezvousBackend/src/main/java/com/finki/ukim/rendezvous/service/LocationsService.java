package com.finki.ukim.rendezvous.service;

import com.finki.ukim.rendezvous.model.Hobbies;
import com.finki.ukim.rendezvous.model.Korisnik;
import com.finki.ukim.rendezvous.model.Locations;

import java.util.List;
import java.util.Optional;

public interface LocationsService {
    public List<Locations> findAll();

    public Optional<Locations> findById(long id);
    public Locations save(Locations l);
    public void deleteById(long id);
    public void deleteAll();

}
