package com.finki.ukim.rendezvous.service;

import com.finki.ukim.rendezvous.model.Hobbies;
import java.util.List;
import java.util.Optional;

public interface HobbiesService {
    public List<Hobbies> findAll();

    public Hobbies save(Hobbies h);

    public void deleteById(long id);

    public Optional<Hobbies> findById(long id);

    public void deleteAll();
}
