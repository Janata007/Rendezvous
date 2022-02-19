package com.finki.ukim.rendezvous.model;

import com.finki.ukim.rendezvous.model.enums.SportEnum;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "korisnik")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Korisnik {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name="date_of_birth")
    private Date dateOfBirth;
    @Enumerated(EnumType.STRING)
    @Column(name="sport")
    private SportEnum sport;
    public Korisnik(String name, String surname, Date dateOfBirth, SportEnum sport) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this. sport = sport;
    }
}
