package mk.finki.ukim.mk.lab.repository.inmemory;

import mk.finki.ukim.mk.lab.model.Location;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryLocationRepository {
    List<Location> locationstlist ;// hoverv sponra klassay alisin ikisi iicnda sonra yazayn adini
    public InMemoryLocationRepository()
    {
        locationstlist = new ArrayList<>();
        locationstlist.add(new Location((long)3245,"DRZAVA", "USA", "10000", "OKEY"));
        locationstlist.add(new Location((long)1234,"Netaville", "Nikola Tesla", "150", "ITHub"));
        locationstlist.add(new Location((long)4456,"CITY Mall", "Karposh 4", "1000", "Shopping centre"));
        locationstlist.add(new Location((long)1000,"FINKI   ", "Nikola Tesal", "8000", "Faculty"));
        locationstlist.add(new Location((long)9800,"Komercijalna Banka", "Cair", "100", "Bank"));
    }


     public List<Location> findAll(){return locationstlist;}

    public Location findById(Long id) {
        return locationstlist.stream().filter(l -> l.getId().equals(id)).findFirst().get();
    }

}
