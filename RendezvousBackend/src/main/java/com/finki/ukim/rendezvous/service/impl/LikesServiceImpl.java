package com.finki.ukim.rendezvous.service.impl;

import com.finki.ukim.rendezvous.model.Likes;
import com.finki.ukim.rendezvous.repository.LikesRepository;
import com.finki.ukim.rendezvous.service.KorisnikService;
import com.finki.ukim.rendezvous.service.LikesService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class LikesServiceImpl implements LikesService {
    private final LikesRepository likesRepository;

    public LikesServiceImpl(LikesRepository likesRepository) {
        this.likesRepository = likesRepository;
    }

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

    @Override
    public Likes userLikesUser(long mainId, long likesId) {
        Likes likes = new Likes(mainId, likesId, true, false);
        return this.likesRepository.save(likes);
    }

    @Override
    public Likes userPlusUltraLikesUser(long mainId, long likesId) {
        Likes likes = new Likes(mainId, likesId, true, true);
        return this.likesRepository.save(likes);
    }

    @Override
    public Likes userDislikesUser(long mainId, long likesId) {
        Likes likes = new Likes(mainId, likesId, false, false);
        return this.likesRepository.save(likes);
    }

    @Override
    public List<Likes> findAllByIsLikedAndLikedUserId(boolean isLikes, long id) {
        return this.likesRepository.findAllByIsLikedAndLikedUserId(isLikes, id);
    }

}
