package com.finki.ukim.rendezvous.model;

import com.finki.ukim.rendezvous.model.enums.AppUserRole;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

@Entity
@Data
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

    private String email;

    private String password;

    private String city;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "korisnik")
    private Set<Sports> sports;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "korisnik")
    private Set<Hobbies> hobbies;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "korisnik")
    private Set<Locations> locations;
    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private AppUserRole appUserRole;
    private Boolean locked;
    private Boolean enabled;


    public Korisnik(String name, String surname, Date dateOfBirth, AppUserRole appUserRole, Boolean locked,
                    Boolean enabled) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.appUserRole = appUserRole;
        this.locked = locked;
        this.enabled = enabled;
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
        return getUsername();
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
}
