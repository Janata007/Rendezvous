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

    public MusicGenres(MusicGenreEnum musicGenre) {
        this.musicGenre = musicGenre;
    }
}
