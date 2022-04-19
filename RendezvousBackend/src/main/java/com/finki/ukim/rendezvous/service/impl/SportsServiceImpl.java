package com.finki.ukim.rendezvous.service.impl;

import com.finki.ukim.rendezvous.model.Korisnik;
import com.finki.ukim.rendezvous.model.Sports;
import com.finki.ukim.rendezvous.repository.SportsRepository;
import com.finki.ukim.rendezvous.service.SportsService;
import java.util.Optional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportsServiceImpl implements SportsService {

    private final SportsRepository sportsRepository;

    public SportsServiceImpl(SportsRepository sportsRepository) {
        this.sportsRepository = sportsRepository;
    }

    public List<Sports> findAll() {
        return this.sportsRepository.findAll();
    }

    public Sports save(Sports s) {
        return this.sportsRepository.save(s);
    }

    public void deleteById(long id) {
        this.sportsRepository.deleteById(id);
    }

    @Override
    public Optional<Sports> findById(long id) {
        return this.sportsRepository.findById(id);
    }

    public void deleteAll() {
        this.sportsRepository.deleteAll();
    }

}
