package com.finki.ukim.rendezvous.service.impl;

import com.finki.ukim.rendezvous.model.Likes;
import com.finki.ukim.rendezvous.repository.LikesRepository;
import java.util.List;

import com.finki.ukim.rendezvous.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikesServiceImpl implements LikesService {
    @Autowired
    private LikesRepository likesRepository;

    public List<Likes> findAll() {
        return this.likesRepository.findAll();
    }

    public List<Likes> findAllByMainUserId(long id) {
        return this.likesRepository.findAllByMainUserId(id);
    }

    public List<Likes> findAllLiked(long id) {
        return this.likesRepository.findAllByIsLikedAndMainUserId(true, id);
    }

    public List<Likes> findAllDisiked(long id) {
        return this.likesRepository.findAllByIsLikedAndIsPlusUltraLikedAndMainUserId(false, false, id);
    }

    public List<Likes> findAllPlusUltraLiked(long id) {
        return this.likesRepository.findAllByIsPlusUltraLikedAndMainUserId(true, id);
    }

    public List<Likes> findAllByIsLikedAndLikedUserId(long id) {
        return this.likesRepository.findAllByIsLikedAndLikedUserId(true, id);
    }

    public List<Likes> findAllByIsPlusUltraLikedAndLikedUserId(long id) {
        return this.likesRepository.findAllByIsPlusUltraLikedAndLikedUserId(true, id);
    }
}
