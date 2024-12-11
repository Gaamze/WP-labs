
package mk.finki.ukim.mk.lab.service.Impl;

import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.repository.jpa.EventRepository;
import mk.finki.ukim.mk.lab.repository.jpa.LocationRepository;
import mk.finki.ukim.mk.lab.repository.inmemory.InMemoryEventRepository;
import mk.finki.ukim.mk.lab.repository.inmemory.InMemoryLocationRepository;
import mk.finki.ukim.mk.lab.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final LocationRepository locationRepository;

    public EventServiceImpl(EventRepository eventRepository, LocationRepository locationRepository) {
        this.eventRepository = eventRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }

        @Override
        public void saveEvent(String eventName, String description, double popularityScore, Long id) {
        Location location = locationRepository.findById(id).get();
        eventRepository.save(new Event(eventName, description, popularityScore, location));
    }
    @Override
    public Optional<Event> findById(long id) {
        return eventRepository.findById(id);
    }
    @Override
    public List<Event> searchEvents(String text, int score) {
        return eventRepository.findAll().stream()
                .filter(event -> (event.getName().toLowerCase().contains(text.toLowerCase()) ||
                        event.getDescription().toLowerCase().contains(text.toLowerCase())) &&
                        event.getPopularityScore() >= score)
                .collect(Collectors.toList());
    }

    @Override
    public Event getEventById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Event with id " + id + " not found"));
    }

        @Override
         public void editEvent(String eventname, String description, double popularityScore, Long eventId, Long locationId) {
        Event event = eventRepository.findById(eventId).get();
        Location location = locationRepository.findById(locationId).get();
        event.setName(eventname);
        event.setDescription(description);
        event.setPopularityScore(popularityScore);
        event.setLocation(location);

        eventRepository.save(event);
    }

        @Override
        public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }
}










//package mk.finki.ukim.mk.lab.service.Impl;
//
//import jakarta.transaction.Transactional;
//import mk.finki.ukim.mk.lab.model.Event;
//import mk.finki.ukim.mk.lab.model.Location;
//import mk.finki.ukim.mk.lab.repository.inmemory.InMemoryLocationRepository;
//import mk.finki.ukim.mk.lab.repository.jpa.EventRepository;
//import mk.finki.ukim.mk.lab.repository.jpa.LocationRepository;
//import mk.finki.ukim.mk.lab.service.EventService;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class EventServiceImpl implements EventService {
//    private final EventRepository eventRepository;
//    private final LocationRepository locationRepository;
//
//    public EventServiceImpl(EventRepository eventRepository, LocationRepository locationRepository) {
//        this.eventRepository = eventRepository;
//        this.locationRepository = locationRepository;
//    }
//
//    @Override
//    public List<Event> listAll() {
//        return eventRepository.findAll();
//    }
//
//    @Override
//    public void saveEvent(String eventname, String description, double popularityScore, Long id) {
//        Location location = locationRepository.findById(id) .orElseThrow(() -> new IllegalArgumentException("Location with id " + id + " not found"));
//        eventRepository.addEvent(eventname,description,popularityScore, location);
//    }
//
//    @Override
//    public List<Event> searchEvents(String text, int score) {
//        // return eventRepository.searchEvents(text, score);
//        return eventRepository.findAll().stream()
//                .filter(event -> event.getName().toLowerCase().contains(text.toLowerCase()) || event.getDescription().toLowerCase().contains(text.toLowerCase()))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public Event getEventById(Long id) {
//        return eventRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Event with id " + id + " not found"));
//    }
//    @Override
//    public void editEvent(String eventname, String description, double popularityScore, Long eventId, Long locationId) {
//        Event event = eventRepository.getById(eventId);
//        Location location = locationRepository.findById(locationId)  .orElseThrow(() -> new IllegalArgumentException("Location with id " + locationId + " not found"));
//
//        event.setName(eventname);
//        event.setDescription(description);
//        event.setPopularityScore(popularityScore);
//        event.setLocation(location);
//
//        eventRepository.editEvent(event);
//    }
//    //        Event event = eventRepository.findById(eventId)
////                .orElseThrow(() -> new IllegalArgumentException("Event with id " + eventId + " not found"));
////        Location location = locationRepository.findById(locationId)
////                .orElseThrow(() -> new IllegalArgumentException("Location with id " + locationId + " not found")).getLocation();
////
////        event.setName(eventName);
////        event.setDescription(description);
////        event.setPopularityScore(popularityScore);
////        event.setLocation(location);
////        eventRepository.save(event);
//
//    @Override
//
//    public void deleteById(Long id) {
//        if (!eventRepository.existsById(id)) {
//            throw new IllegalArgumentException("Event with id " + id + " not found");
//        }
//        eventRepository.deleteById(id);
//    }
//
//
//
//}
//
////
////@Service
////public class EventServiceImpl implements EventService {
////    private final EventRepository eventRepository;                      //reference yapay burda
////    //inicijalizira olacak sadece 1 kez oda consturcotr sayesinde
////    private final LocationRepository repository;
////
////    public EventServiceImpl(EventRepository eventRepository, LocationRepository repository) {
////        this.eventRepository = eventRepository;
////        this.repository = repository;
////    }
////    //konsturkor injection insatnca ali em incijalizira edey
////    @Override
////    public List<Event> listAll() {
////        return eventRepository.findAll();
////    }
////    @Override
////    public void saveEvent(String eventname, String description, double popularityScore, Long id) {
////        Location location = repository.findById(id);
////        eventRepository.addEvent(eventname,description,popularityScore, location);
////    }
////    @Override
////    public List<Event> searchEvents(String text,  int score) {
////        return eventRepository.searchEvents(text, score);
////    }
////
////    @Override
////    public Event getEventById(Long id) {
////        return eventRepository.getById(id);
////    }
////
////    @Override
////    public void editEvent(String eventname, String description, double popularityScore, Long eventId, Long locationId) {
////        Event event = eventRepository.getById(eventId);
////        Location location = repository.findById(locationId);
////        event.setName(eventname);
////        event.setDescription(description);
////        event.setPopularityScore(popularityScore);
////        event.setLocation(location);
////
////        eventRepository.editEvent(event);
////    }
////
////    @Override
////    public void deleteById(Long id) {
////        eventRepository.deleteById(id);
////    }
////
////}
