package com.finki.ukim.rendezvous.repository;

import com.finki.ukim.rendezvous.model.Likes;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesRepository extends JpaRepository<Likes, Long> {
    List<Likes> findAll();
    List<Likes> findAllByMainUserId(long id);
    List<Likes> findAllByIsLikedAndMainUserId(boolean isLiked, long id);
    List<Likes> findAllByIsPlusUltraLikedAndMainUserId(boolean isLiked,long id);
}
