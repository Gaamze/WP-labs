package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Event;//event clastan evetni import edey


import java.util.List;//import dey listi
import java.util.Optional;


public interface EventService {
    List<Event> listAll();//retrun list of all events
    List<Event> searchEvents(String text, int score);

    Event getEventById(Long id);
//    void saveEvent(String eventname, String description, Double popularityScore, Long id);

    void editEvent(String eventname, String description, double popularityScore, Long eventId,Long locationId);

    void saveEvent(String eventname, String description, double popularityScore, Long id);

    public Optional<Event> findById(long id);
    void deleteById(Long id);


   }
