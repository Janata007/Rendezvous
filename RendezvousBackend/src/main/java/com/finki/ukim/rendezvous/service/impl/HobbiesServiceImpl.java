package com.finki.ukim.rendezvous.service.impl;

import com.finki.ukim.rendezvous.model.Hobbies;
import com.finki.ukim.rendezvous.repository.HobbiesRepository;
import com.finki.ukim.rendezvous.service.HobbiesService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class HobbiesServiceImpl implements HobbiesService {

    private final HobbiesRepository hobbiesRepository;

    public HobbiesServiceImpl(HobbiesRepository hobbiesRepository) {
        this.hobbiesRepository = hobbiesRepository;
    }

    public List<Hobbies> findAll() {
        return this.hobbiesRepository.findAll();
    }

    public Optional<Hobbies> findById(long id) {
        return this.hobbiesRepository.findById(id);
    }

    public Hobbies save(Hobbies h) {
        return this.hobbiesRepository.save(h);
    }

    public void deleteById(long id) {
        this.hobbiesRepository.deleteById(id);
    }

    public void deleteAll() {
        this.hobbiesRepository.deleteAll();
    }
}
