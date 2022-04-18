package com.finki.ukim.rendezvous.model;

import com.finki.ukim.rendezvous.model.enums.MusicGenreEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "music_genres")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class MusicGenres {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    private MusicGenreEnum musicGenre;
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "korisnik_id", nullable = false)
    Korisnik korisnik;

    public MusicGenres(MusicGenreEnum musicGenre, Korisnik korisnik) {
        this.musicGenre = musicGenre;
        this.korisnik = korisnik;
    }
}
