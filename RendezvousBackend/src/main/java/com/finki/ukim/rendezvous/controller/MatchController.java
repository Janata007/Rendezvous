package com.finki.ukim.rendezvous.controller;

import com.finki.ukim.rendezvous.service.MatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/matchApi")
public class MatchController {
    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/{id1}/hobbiesPercent/{id2}")
    public ResponseEntity<String> getHobbiesMatchPercent(@PathVariable("id1") long id1, @PathVariable("id2") long id2) {
        String percent = this.matchService.hobbiesPercentMatch(id1, id2);
        return new ResponseEntity<String>(percent, HttpStatus.OK);
    }

    @GetMapping("/locationsPercent/")
    public ResponseEntity<String> getLocationsMatchPercent(@RequestParam("id1") long id1,
                                                           @RequestParam("id2") long id2) {
        String percent = this.matchService.locationsPercentMatch(id1, id2);
        return new ResponseEntity<String>(percent, HttpStatus.OK);
    }

    @GetMapping("/musicPercent/")
    public ResponseEntity<String> getMusicMatchPercent(@RequestParam("id1") long id1, @RequestParam("id2") long id2) {
        String percent = this.matchService.musicPercentMatch(id1, id2);
        return new ResponseEntity<String>(percent, HttpStatus.OK);
    }

    @GetMapping("/sportPercent/")
    public ResponseEntity<String> getSportMatchPercent(@RequestParam("id1") long id1, @RequestParam("id2") long id2) {
        String percent = this.matchService.sportPercentMatch(id1, id2);
        return new ResponseEntity<String>(percent, HttpStatus.OK);
    }

    @GetMapping("/percent/")
    public ResponseEntity<String> getFullMatchPercent(@RequestParam("id1") long id1, @RequestParam("id2") long id2) {
        String percent = this.matchService.matchPercent(id1, id2);
        return new ResponseEntity<String>(percent, HttpStatus.OK);
    }

    @GetMapping("/match/")
    public ResponseEntity<Boolean> getMatchBoolean(@RequestParam("id1") long id1, @RequestParam("id2") long id2) {
        Boolean match = this.matchService.doBothMatch(id1, id2);
        return new ResponseEntity<>(match, HttpStatus.OK);
    }
}
