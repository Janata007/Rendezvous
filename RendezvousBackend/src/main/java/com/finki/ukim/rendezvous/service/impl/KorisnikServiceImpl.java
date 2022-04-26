package com.finki.ukim.rendezvous.service.impl;

import static java.util.Objects.nonNull;

import com.finki.ukim.rendezvous.exceptions.UserNotFoundException;
import com.finki.ukim.rendezvous.model.Korisnik;
import com.finki.ukim.rendezvous.repository.KorisnikRepository;
import com.finki.ukim.rendezvous.service.KorisnikService;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ua_parser.Client;
import ua_parser.Parser;

@Service
public class KorisnikServiceImpl implements KorisnikService {

    private final KorisnikRepository korisnikRepository;
    private final DatabaseReader databaseReader;
    private static final String UNKNOWN = "UNKNOWN";
    private final String LOCALHOST_IPV4 = "127.0.0.1";
    private final String LOCALHOST_IPV6 = "0:0:0:0:0:0:0:1";

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

    @Override
    public Korisnik edit(Long id, Korisnik k) {
            Korisnik korisnik1 = this.korisnikRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
            korisnik1.setHobbies(k.getHobbies());
            korisnik1.setLocations(k.getLocations());
            korisnik1.setMusicGenres(k.getMusicGenres());
            korisnik1.setSports(k.getSports());
            korisnik1.setCity(k.getCity());
            korisnik1.setUsername(k.getUsername());
            korisnik1.setEmail(k.getEmail());
            korisnik1.setPassword(k.getPassword());
            korisnik1.setName(k.getName());
            korisnik1.setCity(k.getCity());
            korisnik1.setDateOfBirth(k.getDateOfBirth());
            korisnik1.setSurname(k.getSurname());
            return this.korisnikRepository.save(korisnik1);
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

    @Override
    public String getClientIp(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-Forwarded-For");
        if (StringUtils.isEmpty(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }

        if (StringUtils.isEmpty(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }

        if (StringUtils.isEmpty(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (LOCALHOST_IPV4.equals(ipAddress) || LOCALHOST_IPV6.equals(ipAddress)) {
                try {
                    InetAddress inetAddress = InetAddress.getLocalHost();
                    ipAddress = inetAddress.getHostAddress();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
            }
        }

        if (!StringUtils.isEmpty(ipAddress)
            && ipAddress.length() > 15
            && ipAddress.indexOf(",") > 0) {
            ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
        }

        return ipAddress;
    }

    private String getDeviceDetails(String userAgent) throws IOException {
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
    public String getIpLocation(String ip, HttpServletRequest request) throws IOException, GeoIp2Exception {
        String city = "UNKNOWN";
        InetAddress ipAddress = InetAddress.getByName(ip);

        try {
            CityResponse cityResponse = databaseReader.city(ipAddress);
            if (nonNull(cityResponse) && nonNull(cityResponse.getCity())) {
                city = cityResponse.getCity().getName();
            }
        } catch (Exception e) {
            return city;
        }
        return city;
    }


}
