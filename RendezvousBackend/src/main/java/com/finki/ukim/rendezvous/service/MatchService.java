package com.finki.ukim.rendezvous.service;

import com.finki.ukim.rendezvous.exceptions.UserNotFoundException;
import com.finki.ukim.rendezvous.model.Hobbies;
import com.finki.ukim.rendezvous.model.Korisnik;
import com.finki.ukim.rendezvous.model.Locations;
import com.finki.ukim.rendezvous.model.MusicGenres;
import com.finki.ukim.rendezvous.model.Sports;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class MatchService {
    private LikesService likesService;
    private KorisnikService korisnikService;
    private LocationsService locationsService;
    private HobbiesService hobbiesService;
    private MusicGenreService musicGenreService;
    private SportsService sportsService;

    public MatchService(LikesService likesService, SportsService sportsService, KorisnikService korisnikService, MusicGenreService musicGenreService, HobbiesService hobbiesService, LocationsService locationsService) {
        this.likesService = likesService;
        this.korisnikService = korisnikService;
        this.locationsService = locationsService;
        this. hobbiesService = hobbiesService;
        this.musicGenreService = musicGenreService;
        this.sportsService = sportsService;
    }

    public String hobbiesPercentMatch(long id1, long id2) {
        Double percent = 0.0;
        Korisnik korisnik1 = this.korisnikService.findById(id1).orElseThrow(() -> new UserNotFoundException(id1));
        Korisnik korisnik2 = this.korisnikService.findById(id2).orElseThrow(() -> new UserNotFoundException(id2));
        Set<Hobbies> korisnik1Hobbies = korisnik1.getHobbies();
        Set<Hobbies> korisnik2Hobbies = korisnik2.getHobbies();
        for(Hobbies hobby1 : korisnik1Hobbies){
            for(Hobbies hobby2 : korisnik2Hobbies){
                if(hobby2.equals(hobby1)){
                    percent+= 5.5;
                }
            }
        }
        return percent.toString();
    }
    public String locationsPercentMatch(long id1, long id2) {
        Double percent = 0.0;
        Korisnik korisnik1 = this.korisnikService.findById(id1).orElseThrow(() -> new UserNotFoundException(id1));
        Korisnik korisnik2 = this.korisnikService.findById(id2).orElseThrow(() -> new UserNotFoundException(id2));
        Set<Locations> korisnik1Locations = korisnik1.getLocations();
        Set<Locations> korisnik2Locations = korisnik2.getLocations();
        for(Locations location1 : korisnik1Locations){
            for(Locations location2 : korisnik2Locations){
                if(location2.equals(location1)){
                    percent+= 5.8;
                }
            }
        }
        return percent.toString();
    }
    public String musicPercentMatch(long id1, long id2) {
        Double percent = 0.0;
        Korisnik korisnik1 = this.korisnikService.findById(id1).orElseThrow(() -> new UserNotFoundException(id1));
        Korisnik korisnik2 = this.korisnikService.findById(id2).orElseThrow(() -> new UserNotFoundException(id2));
        Set<MusicGenres> korisnik1Music = korisnik1.getMusicGenres();
        Set<MusicGenres> korisnik2Music = korisnik2.getMusicGenres();
        for(MusicGenres music1 : korisnik1Music){
            for(MusicGenres music2 : korisnik2Music){
                if(music2.equals(music1)){
                    percent+= 5.0;
                }
            }
        }
        return percent.toString();
    }
    public String sportPercentMatch(long id1, long id2) {
        Double percent = 0.0;
        Korisnik korisnik1 = this.korisnikService.findById(id1).orElseThrow(() -> new UserNotFoundException(id1));
        Korisnik korisnik2 = this.korisnikService.findById(id2).orElseThrow(() -> new UserNotFoundException(id2));
        Set<Sports> korisnik1Sport = korisnik1.getSports();
        Set<Sports> korisnik2Sport = korisnik2.getSports();
        for(Sports sport1 : korisnik1Sport){
            for(Sports sport2 : korisnik2Sport){
                if(sport2.equals(sport1)){
                    percent+= 7.68;
                }
            }
        }
        return percent.toString();
    }
    public String matchPercent (long id1, long id2){
        Double percent = 0.0;
        Korisnik korisnik1 = this.korisnikService.findById(id1).orElseThrow(() -> new UserNotFoundException(id1));
        Korisnik korisnik2 = this.korisnikService.findById(id2).orElseThrow(() -> new UserNotFoundException(id2));
        Double hobbiesP = Double.parseDouble(this.hobbiesPercentMatch(id1, id2));
        Double locationP = Double.parseDouble(this.locationsPercentMatch(id1, id2));
        Double musicP = Double.parseDouble(this.musicPercentMatch(id1, id2));
        Double sportP = Double.parseDouble(this.sportPercentMatch(id1, id2));
        percent = (hobbiesP + locationP + musicP + sportP)/4;

        return percent.toString();
    }
}
