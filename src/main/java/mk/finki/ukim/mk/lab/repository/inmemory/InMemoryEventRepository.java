package mk.finki.ukim.mk.lab.repository.inmemory;


import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryEventRepository {
    private final List<Event> eventlist;

    public InMemoryEventRepository(List<Event> eventlist, List<Location> locationstlist) {
        this.eventlist = eventlist;
        eventlist=new ArrayList<>();
        Location location= new Location((long)3245,"DRZAVA", "USA", "10000", "OKEY");
        eventlist.add(new Event("proba","proba",3.00,location));//yazaysn hepsini tekre tekr
        eventlist.add(new Event("proba1","proba1",4.00, location));
        eventlist.add(new Event("proba2","proba2",5.00,location));
        eventlist.add(new Event("proba3","proba3",6.00,location));
        eventlist.add(new Event("proba4","proba4",7.00,location));
        eventlist.add(new Event("proba5","proba5",8.00,location));
        eventlist.add(new Event("proba6","proba6",9.00,location));
        eventlist.add(new Event("proba7","proba7",1.00,location));
        eventlist.add(new Event("proba8","proba8",2.00,location));
        eventlist.add(new Event( "proba9","proba9",10.00,location));

    }


    public List<Event> findAll() {
        return eventlist;
    }

    public Optional<Event> findById(long id) {
        return eventlist.stream().filter(event -> event.getId().equals(id)).findFirst();
    }
    public List<Event> searchEvents(String text, int score) {
        if (text == null || text.isEmpty()) {
            return eventlist;
        }
        return eventlist.stream()
                .filter(e -> e.getName().equalsIgnoreCase(text) || e.getPopularityScore() >= score)
                .toList();
    }
    public  void addEvent(String eventname, String description, double popularityScore, Location location){
        Event event = new Event(eventname,description,popularityScore,location);
        eventlist.add(event);
    }

    public  Event getById(Long id){
        return eventlist.stream().filter(e-> e.getId().equals(id)).findFirst().get();
    }

    public  void editEvent(Event event){
        eventlist.add(event);
    }

    public  void deleteById(Long id){
        Event event = eventlist.stream().filter(e-> e.getId().equals(id)).findFirst().get();
        eventlist.remove(event);
    }















    //public   List<Event> findAllByLocation_id(Long location_id);



        //  List<Event>eventlist= null;// hoverv sponra klassay alisin ikisi iicnda sonra yazayn adini

        //    @PostConstruct//fucnijadna evvel her zaman direk inizcijaliira olsun
//    public void init()
//    {
//
//        eventlist=new ArrayList<>();
//        Location location= new Location((long)3245,"DRZAVA", "USA", "10000", "OKEY");
//        eventlist.add(new Event("proba","proba",3.00,location));//yazaysn hepsini tekre tekr
//        eventlist.add(new Event("proba1","proba1",4.00, location));
//        eventlist.add(new Event("proba2","proba2",5.00,location));
//        eventlist.add(new Event("proba3","proba3",6.00,location));
//        eventlist.add(new Event("proba4","proba4",7.00,location));
//        eventlist.add(new Event("proba5","proba5",8.00,location));
//        eventlist.add(new Event("proba6","proba6",9.00,location));
//        eventlist.add(new Event("proba7","proba7",1.00,location));
//        eventlist.add(new Event("proba8","proba8",2.00,location));
//        eventlist.add(new Event( "proba9","proba9",10.00,location));
//
//
//
//
//    }

        //gunderi butu event listi


       // List<Event> findAllByNameLike(String text);
        //        DataHolder.products.removeIf(i -> i.getName().equals(name));

    }
//in memeo= runda iken incilra olacak vrednostlarin


