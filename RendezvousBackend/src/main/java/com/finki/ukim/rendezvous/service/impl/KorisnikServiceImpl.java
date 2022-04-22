package com.finki.ukim.rendezvous.service.impl;

import com.finki.ukim.rendezvous.model.Korisnik;
import com.finki.ukim.rendezvous.repository.KorisnikRepository;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;
import java.util.Optional;

import com.finki.ukim.rendezvous.service.KorisnikService;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import org.springframework.stereotype.Service;
import ua_parser.Client;
import ua_parser.Parser;

import javax.servlet.http.HttpServletRequest;

import static java.util.Objects.nonNull;

@Service
public class KorisnikServiceImpl implements KorisnikService {

    private final KorisnikRepository korisnikRepository;
    private final DatabaseReader databaseReader;
    private static final String UNKNOWN = "UNKNOWN";

    public KorisnikServiceImpl(KorisnikRepository korisnikRepository, DatabaseReader databaseReader) {

        this.korisnikRepository = korisnikRepository;
        this.databaseReader = databaseReader;

    }

    public List<Korisnik> findAll() {
        return this.korisnikRepository.findAll();
    }

    public Optional<Korisnik> findById(long id) {
        return this.korisnikRepository.findById(id);
    }

    public Korisnik save(Korisnik k) {
        return this.korisnikRepository.save(k);
    }

    public void deleteById(long id) {
        this.korisnikRepository.deleteById(id);
    }

    public void deleteAll() {
        this.korisnikRepository.deleteAll();
    }



    @Override
    public Optional<Korisnik> findByUsername(String username) {
        return this.korisnikRepository.findByUsername(username);
    }

    private String getDeviceDetails( String userAgent) throws IOException{
        String deviceDetails = UNKNOWN;
        Parser parser = new Parser();
        Client client = parser.parse(userAgent);
        if (nonNull(client)) {
            deviceDetails = client.userAgent.family + " " + client.userAgent.major + "." + client.userAgent.minor +
                    " - " + client.os.family + " " + client.os.major + "." + client.os.minor;
        }

        return deviceDetails;
    }
    @Override
    public Korisnik getIpLocation(String ip, HttpServletRequest request) throws IOException, GeoIp2Exception {
        Korisnik position = new Korisnik();
        String location;
        InetAddress ipAddress = InetAddress.getByName(ip);

        CityResponse cityResponse = databaseReader.city(ipAddress);
        if (nonNull(cityResponse) && nonNull(cityResponse.getCity())) {
            position.setCity(cityResponse.getCity().getName());
        }
        return position;
    }


}
