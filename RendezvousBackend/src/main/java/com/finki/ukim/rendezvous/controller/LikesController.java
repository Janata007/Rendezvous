package com.finki.ukim.rendezvous.controller;

import com.finki.ukim.rendezvous.model.Likes;
import com.finki.ukim.rendezvous.service.impl.LikesServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/likesApi")
public class LikesController {
    @Autowired
    private LikesServiceImpl likesService;

    @GetMapping("/allLikeTypes/{id}")
    public ResponseEntity<List<Likes>> getAllLikeTypesForUser(@PathVariable("id") long id) {
        List<Likes> userLikes = new ArrayList<>();
        userLikes = likesService.findAllByMainUserId(id);
        return new ResponseEntity<List<Likes>>(userLikes, HttpStatus.OK);
    }

    @GetMapping("/allLikes/{id}")
    public ResponseEntity<List<Likes>> getAllLikesForUser(@PathVariable("id") long id) {
        List<Likes> userLikes = new ArrayList<>();
        userLikes = likesService.findAllLiked(id);
        return new ResponseEntity<List<Likes>>(userLikes, HttpStatus.OK);
    }

    @GetMapping("/allDisLikes/{id}")
    public ResponseEntity<List<Likes>> getAllDislikesForUser(@PathVariable("id") long id) {
        List<Likes> userLikes = new ArrayList<>();
        userLikes = likesService.findAllDisiked(id);
        return new ResponseEntity<List<Likes>>(userLikes, HttpStatus.OK);
    }

    @GetMapping("/allPlusUltraLikes/{id}")
    public ResponseEntity<List<Likes>> getAllPlusUltraLikesForUser(@PathVariable("id") long id) {
        List<Likes> userLikes = new ArrayList<>();
        userLikes = likesService.findAllPlusUltraLiked(id);
        return new ResponseEntity<List<Likes>>(userLikes, HttpStatus.OK);
    }

    @GetMapping("/allWhoLikesUser/{id}")
    public ResponseEntity<List<Likes>> getAllWhoLikesUser(@PathVariable("id") long id) {
        List<Likes> userLikes = new ArrayList<>();
        userLikes = likesService.findAllByIsLikedAndLikedUserId(id);
        return new ResponseEntity<List<Likes>>(userLikes, HttpStatus.OK);
    }

    @GetMapping("/allWhoPlusUltraLikesUser/{id}")
    public ResponseEntity<List<Likes>> getAllWhoPlusUltraLikesUser(@PathVariable("id") long id) {
        List<Likes> userLikes = new ArrayList<>();
        userLikes = likesService.findAllByIsPlusUltraLikedAndLikedUserId(id);
        return new ResponseEntity<List<Likes>>(userLikes, HttpStatus.OK);
    }
}
