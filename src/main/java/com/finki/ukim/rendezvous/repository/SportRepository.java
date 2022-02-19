package com.finki.ukim.rendezvous.repository;

import com.finki.ukim.rendezvous.model.Sport;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportRepository extends JpaRepository<Sport, Long> {
    List<Sport> findAll();
    List<Sport> findAllById(long id);
}
