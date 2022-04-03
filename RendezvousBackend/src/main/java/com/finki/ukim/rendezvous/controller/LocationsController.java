package com.finki.ukim.rendezvous.controller;

import com.finki.ukim.rendezvous.model.Korisnik;
import com.finki.ukim.rendezvous.model.Locations;
import com.finki.ukim.rendezvous.service.LocationsService;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locationsApi")
public class LocationsController {
    private final LocationsService locationsService;

    public LocationsController(LocationsService locationsService) {
        this.locationsService = locationsService;
    }

    @GetMapping("/locations")
    public ResponseEntity<List<Locations>> getAllLocations() {
        List<Locations> locations = new ArrayList<>();
        locations = this.locationsService.findAll();
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    @GetMapping("/korisnikLocations")
    public ResponseEntity<List<Locations>> getLocationsByKorisnik(@RequestBody Korisnik korisnik) {
        List<Locations> locationsData = locationsService.findByKorisnik(korisnik);
        if (!locationsData.isEmpty()) {
            return new ResponseEntity<List<Locations>>(locationsData, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/locations")
    public ResponseEntity<Locations> createLocations(@RequestBody Locations locations) {
        try {
            Locations _locations = this.locationsService
                .save(new Locations(locations.getLocation(), locations.getKorisnik()));
            return new ResponseEntity<>(_locations, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/locations/{id}")
    public ResponseEntity<HttpStatus> deleteLocations(@PathVariable("id") long id) {
        try {
            this.locationsService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/locations")
    public ResponseEntity<HttpStatus> deleteAllLocations() {
        try {
            this.locationsService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
