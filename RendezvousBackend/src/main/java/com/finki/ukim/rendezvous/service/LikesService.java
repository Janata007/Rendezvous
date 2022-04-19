package com.finki.ukim.rendezvous.service;

import com.finki.ukim.rendezvous.model.Likes;

import java.util.List;

public interface LikesService {
    public List<Likes> findAll();
    public List<Likes> findAllByMainUserId(long id);
    public List<Likes> findAllLiked(long id);
    public List<Likes> findAllDisiked(long id);
    public List<Likes> findAllPlusUltraLiked(long id);
    public Likes userLikesUser(long mainId, long likesId);
    public Likes userPlusUltraLikesUser(long mainId, long likesId);
    public Likes userDislikesUser(long mainId, long likesId);
    public List<Likes> findAllByIsLikedAndLikedUserId(boolean isLikes, long id);

}
