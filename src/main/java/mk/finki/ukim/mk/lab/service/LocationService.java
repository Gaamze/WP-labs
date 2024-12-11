package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Location;

import java.util.List;
import java.util.Optional;

public interface LocationService {

    public List<Location> findAll();

    //public List<Event> findAll(){ return locationRepository.findAll(); }
    Optional<Location> findById(Long id);
}