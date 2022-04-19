package com.finki.ukim.rendezvous.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finki.ukim.rendezvous.model.enums.SportEnum;
import java.util.HashSet;
import java.util.Set;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

    public Sports(SportEnum sport) {
        this.sport = sport;
    }
}
