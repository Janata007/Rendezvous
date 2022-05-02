package com.finki.ukim.rendezvous.controller;

import com.finki.ukim.rendezvous.exceptions.UserNotFoundException;
import com.finki.ukim.rendezvous.model.Likes;
import com.finki.ukim.rendezvous.service.KorisnikService;
import com.finki.ukim.rendezvous.service.LikesService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/likesApi")
public class LikesController {
    private final LikesService likesService;
    private final KorisnikService korisnikService;

    public LikesController(LikesService likesService, KorisnikService korisnikService) {
        this.likesService = likesService;
        this.korisnikService = korisnikService;
    }

    @GetMapping("/allLikeTypes/{id}")
    public ResponseEntity<List<Likes>> getAllLikeTypesForUser(@PathVariable("id") long id) {
        this.korisnikService.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        List<Likes> userLikes = new ArrayList<>();
        userLikes = this.likesService.findAllByMainUserId(id);
        return new ResponseEntity<List<Likes>>(userLikes, HttpStatus.OK);
    }

    @GetMapping("/allLikes/{id}")
    public ResponseEntity<List<Likes>> getAllLikesForUser(@PathVariable("id") long id) {
        this.korisnikService.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        List<Likes> userLikes = new ArrayList<>();
        userLikes = this.likesService.findAllLiked(id);
        return new ResponseEntity<List<Likes>>(userLikes, HttpStatus.OK);
    }

    @GetMapping("/allDisLikes/{id}")
    public ResponseEntity<List<Likes>> getAllDislikesForUser(@PathVariable("id") long id) {
        this.korisnikService.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        List<Likes> userLikes = new ArrayList<>();
        userLikes = this.likesService.findAllDisiked(id);
        return new ResponseEntity<List<Likes>>(userLikes, HttpStatus.OK);
    }

    @GetMapping("/allPlusUltraLikes/{id}")
    public ResponseEntity<List<Likes>> getAllPlusUltraLikesForUser(@PathVariable("id") long id) {
        this.korisnikService.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        List<Likes> userLikes = new ArrayList<>();
        userLikes = this.likesService.findAllPlusUltraLiked(id);
        return new ResponseEntity<List<Likes>>(userLikes, HttpStatus.OK);
    }

    @PostMapping("/user/{mainId}/likes/{likesId}")
    public ResponseEntity<Likes> userLikesUser(@PathVariable long mainId, @PathVariable long likesId) {
        this.korisnikService.findById(mainId).orElseThrow(() -> new UserNotFoundException(mainId));
        this.korisnikService.findById(likesId).orElseThrow(() -> new UserNotFoundException(likesId));
        Likes likes = this.likesService.userLikesUser(mainId, likesId);
        return new ResponseEntity<Likes>(likes, HttpStatus.OK);
    }

    @PostMapping("/user/{mainId}/plusUltraLikes/{likesId}")
    public ResponseEntity<Likes> userPlusUltraLikesUser(@PathVariable long mainId, @PathVariable long likesId) {
        this.korisnikService.findById(mainId).orElseThrow(() -> new UserNotFoundException(mainId));
        this.korisnikService.findById(likesId).orElseThrow(() -> new UserNotFoundException(likesId));
        Likes likes = this.likesService.userPlusUltraLikesUser(mainId, likesId);
        return new ResponseEntity<Likes>(likes, HttpStatus.OK);
    }

    @PostMapping("/user/{mainId}/dislikes/{likesId}")
    public ResponseEntity<Likes> userDislikesUser(@PathVariable long mainId, @PathVariable long likesId) {
        this.korisnikService.findById(mainId).orElseThrow(() -> new UserNotFoundException(mainId));
        this.korisnikService.findById(likesId).orElseThrow(() -> new UserNotFoundException(likesId));
        Likes likes = this.likesService.userDislikesUser(mainId, likesId);
        return new ResponseEntity<Likes>(likes, HttpStatus.OK);
    }

    @GetMapping("/user/{id}/isLiked")
    public ResponseEntity<List<Likes>> getLikedUserLikes(@PathVariable long id) {
        this.korisnikService.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        List<Likes> likes = this.likesService.findAllByIsLikedAndLikedUserId(true, id);
        return new ResponseEntity<List<Likes>>(likes, HttpStatus.OK);
    }
}
