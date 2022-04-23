package com.finki.ukim.rendezvous.service;

import com.finki.ukim.rendezvous.model.Korisnik;
import com.maxmind.geoip2.exception.GeoIp2Exception;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface KorisnikService {
    public List<Korisnik> findAll();
    public Optional<Korisnik> findById(long id);
    public Korisnik save(Korisnik k);
    public void deleteById(long id);
    public void deleteAll();
    public Optional<Korisnik> findByUsername(String username);
    String getClientIp(HttpServletRequest request);

    String getIpLocation(String ip, HttpServletRequest request) throws IOException, GeoIp2Exception;
}
