//package mk.finki.ukim.mk.lab.bootstrap;
//
//import jakarta.annotation.PostConstruct;
//import mk.finki.ukim.mk.lab.model.Event;
//import mk.finki.ukim.mk.lab.model.Location;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class DataHolder {
//
//    public static List<Event> eventlist = new ArrayList<>();
//    public static List<Location> locationstlist = new ArrayList<>();
//
//
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
//        locationstlist = new ArrayList<>();
//        locationstlist.add(new Location((long)3245,"DRZAVA", "USA", "10000", "OKEY"));
//        locationstlist.add(new Location((long)1234,"Netaville", "Nikola Tesla", "150", "ITHub"));
//        locationstlist.add(new Location((long)4456,"CITY Mall", "Karposh 4", "1000", "Shopping centre"));
//        locationstlist.add(new Location((long)1000,"FINKI   ", "Nikola Tesal", "8000", "Faculty"));
//        locationstlist.add(new Location((long)9800,"Komercijalna Banka", "Cair", "100", "Bank"));
//
//
//
//    }
//}