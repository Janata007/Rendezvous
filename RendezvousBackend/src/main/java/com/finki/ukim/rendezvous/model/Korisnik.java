package com.finki.ukim.rendezvous.model;

import com.finki.ukim.rendezvous.model.enums.AppUserRole;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Data
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "korisnici")
public class Korisnik implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String surname;

    private String username;

    private String email;

    private String password;

    private String city;

    private String ipAddress;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @ManyToMany
    @JoinTable(name = "korisnici_sports",
        joinColumns = @JoinColumn(name = "korisnik_id"),
        inverseJoinColumns = @JoinColumn(name = "sport_id"))
    private Set<Sports> sports;

    @ManyToMany
    @JoinTable(name = "korisnici_hobbies",
        joinColumns = @JoinColumn(name = "korisnik_id"),
        inverseJoinColumns = @JoinColumn(name = "hobby_id"))
    private Set<Hobbies> hobbies;

    @ManyToMany
    @JoinTable(name = "korisnici_locations",
        joinColumns = @JoinColumn(name = "korisnik_id"),
        inverseJoinColumns = @JoinColumn(name = "location_id"))
    private Set<Locations> locations;

    @ManyToMany
    @JoinTable(name = "korisnici_music_genres",
        joinColumns = @JoinColumn(name = "korisnik_id"),
        inverseJoinColumns = @JoinColumn(name = "music_genre_id"))
    private Set<MusicGenres> musicGenres;


    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private AppUserRole appUserRole;
    private Boolean locked;
    private Boolean enabled;


    public Korisnik(String password, String username, String name, String email, String surname, Date dateOfBirth,
                    AppUserRole appUserRole) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.surname = surname;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.appUserRole = appUserRole;
        this.locked = true;
        this.enabled = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void addSport(Sports sport) {
        sports.add(sport);
    }

    public void addHobby(Hobbies hobby) {
        hobbies.add(hobby);
    }

    public void addLocation(Locations location) {
        locations.add(location);
    }

    public void addMusicGenre(MusicGenres musicGenre) {
        musicGenres.add(musicGenre);
    }
}
