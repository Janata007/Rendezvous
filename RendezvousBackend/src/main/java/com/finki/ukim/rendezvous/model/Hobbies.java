package com.finki.ukim.rendezvous.model;

import com.finki.ukim.rendezvous.model.enums.HobbyEnum;
import com.finki.ukim.rendezvous.service.KorisnikService;
import javax.persistence.CascadeType;
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

@Entity(name = "hobbies")
@AllArgsConstructor
@Data
@Getter
@NoArgsConstructor
public class Hobbies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "hobby")
    private HobbyEnum hobby;
//    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
//    @JoinColumn(name = "korisnik_id",  referencedColumnName = "id",nullable = false)
//    Korisnik korisnik;

    public Hobbies(HobbyEnum hobby) {
        this.hobby = hobby;
        //this.korisnik = korisnik;
    }
}
