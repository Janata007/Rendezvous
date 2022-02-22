package com.finki.ukim.rendezvous.repository;

import com.finki.ukim.rendezvous.model.Locations;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationsRepository extends JpaRepository<Locations, Long> {
    List<Locations> findAll();

    Optional<Locations> findById(long id);
}
