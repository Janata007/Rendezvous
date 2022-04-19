package com.finki.ukim.rendezvous.controller;

import com.finki.ukim.rendezvous.exceptions.UserNotFoundException;
import com.finki.ukim.rendezvous.model.Likes;
import com.finki.ukim.rendezvous.service.KorisnikService;
import com.finki.ukim.rendezvous.service.LikesService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
    public ResponseEntity<String> userLikesUser(@PathVariable long mainId, @PathVariable long likesId) {
        this.korisnikService.findById(mainId).orElseThrow(() -> new UserNotFoundException(mainId));
        this.korisnikService.findById(likesId).orElseThrow(() -> new UserNotFoundException(likesId));
        this.likesService.userLikesUser(mainId, likesId);
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }

    @PostMapping("/user/{mainId}/plusUltraLikes/{likesId}")
    public ResponseEntity<String> userPlusUltraLikesUser(@PathVariable long mainId, @PathVariable long likesId) {
        this.korisnikService.findById(mainId).orElseThrow(() -> new UserNotFoundException(mainId));
        this.korisnikService.findById(likesId).orElseThrow(() -> new UserNotFoundException(likesId));
        this.likesService.userPlusUltraLikesUser(mainId, likesId);
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }

    @PostMapping("/user/{mainId}/dislikes/{likesId}")
    public ResponseEntity<String> userDislikesUser(@PathVariable long mainId, @PathVariable long likesId) {
        this.korisnikService.findById(mainId).orElseThrow(() -> new UserNotFoundException(mainId));
        this.korisnikService.findById(likesId).orElseThrow(() -> new UserNotFoundException(likesId));
        this.likesService.userDislikesUser(mainId, likesId);
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }
}
