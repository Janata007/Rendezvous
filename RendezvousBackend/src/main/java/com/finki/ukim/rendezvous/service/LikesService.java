package com.finki.ukim.rendezvous.service;

import com.finki.ukim.rendezvous.model.Likes;
import com.finki.ukim.rendezvous.repository.LikesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikesService {
    @Autowired
    private LikesRepository likesRepository;

    public List<Likes> findAll(){
        return this.likesRepository.findAll();
    }

    public List<Likes> findAllByMainUserId(long id){
        return this.likesRepository.findAllByMainUserId(id);
    }

    public List<Likes> findAllLiked(long id){
        return this.likesRepository.findAllByIsLikedAndMainUserId(true, id);
    }
    public List<Likes> findAllDisiked(long id){
        return this.likesRepository.findAllByIsLikedAndMainUserId(false, id);
    }

    public List<Likes> findAllPlusUltraLiked(long id){
        return this.likesRepository.findAllByIsPlusUltraLikedAndMainUserId(true, id);
    }
}
