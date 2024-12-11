package mk.finki.ukim.mk.lab.repository.jpa;

import mk.finki.ukim.mk.lab.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}





























//  List<Location> locationstlist = null;// hoverv sponra klassay alisin ikisi iicnda sonra yazayn adini
//
//    @PostConstruct//fucnijadna evvel her zaman direk inizcijaliira olsun//
//    public void init() {
//
//        locationstlist = new ArrayList<>();
//        locationstlist.add(new Location((long)3245,"DRZAVA", "USA", "10000", "OKEY"));
//        locationstlist.add(new Location((long)1234,"Netaville", "Nikola Tesla", "150", "ITHub"));
//        locationstlist.add(new Location((long)4456,"CITY Mall", "Karposh 4", "1000", "Shopping centre"));
//        locationstlist.add(new Location((long)1000,"FINKI   ", "Nikola Tesal", "8000", "Faculty"));
//        locationstlist.add(new Location((long)9800,"Komercijalna Banka", "Cair", "100", "Bank"));
//
//    }
   // public List<Location> findAll(){return locationstlist;}

//    public Location findById(Long id){
//        return locationstlist.stream().filter(l-> l.getId().equals(id)).findFirst().get();
//    }

