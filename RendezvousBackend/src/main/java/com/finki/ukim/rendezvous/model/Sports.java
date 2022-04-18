package com.finki.ukim.rendezvous.model;

import com.finki.ukim.rendezvous.model.enums.SportEnum;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "sports")
@AllArgsConstructor
@Data
@Getter
@NoArgsConstructor
public class Sports {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "sport")
    private SportEnum sport;
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "korisnik_id", nullable = false)
    Korisnik korisnik;

    public Sports(SportEnum sport, Korisnik korisnik) {
        this.sport = sport;
        this.korisnik = korisnik;
    }
}
