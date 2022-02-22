package com.finki.ukim.rendezvous.service;

import com.finki.ukim.rendezvous.model.Locations;
import com.finki.ukim.rendezvous.repository.LocationsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class LocationsService {
    @Autowired
    private LocationsRepository locationsRepository;

    public List<Locations> findAll() {
        return locationsRepository.findAll();
    }
}
