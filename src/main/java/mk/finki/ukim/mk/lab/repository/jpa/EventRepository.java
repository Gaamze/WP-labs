package mk.finki.ukim.mk.lab.repository.jpa;

import mk.finki.ukim.mk.lab.model.Event; //referriia edey event modele
import org.springframework.data.jpa.repository.JpaRepository;

//import org.springframework.stereotype.Repository;//anotacijaj kullanmak icin

import java.util.List;
import java.util.Optional;


//@Repository //repo repoyA depedensiy bir turli hallettri
public interface EventRepository extends JpaRepository<Event, Long> {

}























   // void deleteById( Long id);

  //  void editEvent(Event event);

  //  void addEvent(String eventname, String description, double popularityScore, Location location);


   // List<Event> findAllByLocation_id(Long location_id);
//
//    public default List<Event> findAll() {
//        return eventlist;//cevirisn sal duz lisay
//    }
//    //gunderi butu event listi
//    public default List<Event> searchEvents(String text, int score) {
//        if (text == null || text.isEmpty()) {
//            return eventlist;
//        }
//        return eventlist.stream()
//                .filter(e -> e.getName().equalsIgnoreCase(text) || e.getPopularityScore() >= score)
//                .toList();
//    }
//
//    public default void deleteById(Long id){
//        Event event = eventlist.stream().filter(e-> e.getId().equals(id)).findFirst().get();
//        eventlist.remove(event);
//    }

// srach by name yaysn burda

//    public default void addEvent(String eventname, String description, double popularityScore, Location location){
//        Event event = new Event(eventname,description,popularityScore,location);
//        eventlist.add(event);
//    }
//
//    public default Event getById(Long id){
//        return eventlist.stream().filter(e-> e.getId().equals(id)).findFirst().get();
//    }
//
//    public default void editEvent(Event event){
//        eventlist.add(event);
//    }
//
//    List<Event> findAllByNameLike(String text);
//    //        DataHolder.products.removeIf(i -> i.getName().equals(name));


//in memeo= runda iken incilra olacak vrednostlarin

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