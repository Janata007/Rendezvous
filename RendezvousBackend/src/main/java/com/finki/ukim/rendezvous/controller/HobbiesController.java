package com.finki.ukim.rendezvous.controller;

import com.finki.ukim.rendezvous.model.Hobbies;
import com.finki.ukim.rendezvous.service.HobbiesService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hobbiesApi")
public class HobbiesController {
    private final HobbiesService hobbiesService;

    public HobbiesController(HobbiesService hobbiesService) {
        this.hobbiesService = hobbiesService;
    }

    @GetMapping("/hobbies")
    public ResponseEntity<List<Hobbies>> getAllHobbies() {
        List<Hobbies> hobbies = this.hobbiesService.findAll();
        // hobbies = this.hobbiesService.findAll();
        return new ResponseEntity<>(hobbies, HttpStatus.OK);
    }

    @PostMapping("/hobbies")
    public ResponseEntity<Hobbies> createHobbies(@RequestBody Hobbies hobbies) {
        try {
            Hobbies _hobbies = this.hobbiesService
                .save(new Hobbies(hobbies.getHobby()));
            return new ResponseEntity<>(_hobbies, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/hobbies/{id}")
    public ResponseEntity<HttpStatus> deleteHobby(@PathVariable("id") long id) {
        try {
            this.hobbiesService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/hobbies")
    public ResponseEntity<HttpStatus> deleteAllHobbies() {
        try {
            this.hobbiesService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
