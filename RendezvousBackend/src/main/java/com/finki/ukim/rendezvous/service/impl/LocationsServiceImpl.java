package com.finki.ukim.rendezvous.service.impl;

import com.finki.ukim.rendezvous.model.Korisnik;
import com.finki.ukim.rendezvous.model.Locations;
import com.finki.ukim.rendezvous.repository.LocationsRepository;
import java.util.List;

import com.finki.ukim.rendezvous.service.LocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationsServiceImpl implements LocationsService {

    private final  LocationsRepository locationsRepository;

    public LocationsServiceImpl(LocationsRepository locationsRepository) {
        this.locationsRepository = locationsRepository;
    }

    public List<Locations> findAll() {
        return locationsRepository.findAll();
    }

    public List<Locations> findByKorisnik(Korisnik korisnik) {
        return this.locationsRepository.findByKorisnik(korisnik);
    }
    public Locations save(Locations l) {
        return this.locationsRepository.save(l);
    }

    public void deleteById(long id) {
        this.locationsRepository.deleteById(id);
    }

    public void deleteAll() {
        this.locationsRepository.deleteAll();
    }
}
