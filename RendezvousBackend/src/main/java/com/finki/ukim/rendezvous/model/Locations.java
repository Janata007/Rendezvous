package com.finki.ukim.rendezvous.model;

import com.finki.ukim.rendezvous.model.enums.LocationEnum;
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

@Entity(name = "locations")
@AllArgsConstructor
@Data
@Getter
@NoArgsConstructor
public class Locations {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "location")
    private LocationEnum location;
    public Locations(LocationEnum location) {
        this.location = location;
    }
}
