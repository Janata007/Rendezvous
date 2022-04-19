package com.finki.ukim.rendezvous.service.impl;

import com.finki.ukim.rendezvous.model.MusicGenres;
import com.finki.ukim.rendezvous.repository.MusicGenresRepository;
import com.finki.ukim.rendezvous.service.MusicGenreService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class MusicGenreServiceImpl implements MusicGenreService {

    private final MusicGenresRepository musicGenresRepository;

    public MusicGenreServiceImpl(MusicGenresRepository musicGenresRepository) {
        this.musicGenresRepository = musicGenresRepository;
    }

    @Override
    public List<MusicGenres> findAll() {
        return this.musicGenresRepository.findAll();
    }

    @Override
    public Optional<MusicGenres> findById(long id) {
        return this.musicGenresRepository.findById(id);
    }

    @Override
    public MusicGenres save(MusicGenres s) {
        return this.musicGenresRepository.save(s);
    }

}
