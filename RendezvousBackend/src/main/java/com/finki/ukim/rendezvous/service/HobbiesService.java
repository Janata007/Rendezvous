package com.finki.ukim.rendezvous.service;

import com.finki.ukim.rendezvous.model.Hobbies;
import java.util.List;

public interface HobbiesService {
    public List<Hobbies> findAll();

    //public List<Hobbies> findByKorisnik(Korisnik korisnik);

    public Hobbies save(Hobbies h);

    public void deleteById(long id);

    public void deleteAll();
}
