package mk.finki.ukim.mk.lab.model;// classsin nerde located odlugunu suley


import jakarta.persistence.*;
import lombok.*;
import lombok.Data;
import lombok.Generated;

import java.util.concurrent.atomic.AtomicLong;

@Data//importira etemk icin getter setter he sey
// generiri aconsturktor?
@NoArgsConstructor
@Entity
public class Event {
    //private static final AtomicLong ID_GENERATOR = new AtomicLong(1);  // Auto-increment ID generator
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    String name;
    String description;
    Double popularityScore;
    @ManyToOne
    private Location location;


    public Event(String name, String description, Double popularityScore, Location location) {
//        this.id = ID_GENERATOR.getAndIncrement();  // Automatically assign a unique ID
        this.name = name;
        this.description = description;
        this.popularityScore = popularityScore;
        this.location = location;
    }



}
// data anatocija ile gerek kalmay yazasin getter setterler bununle arka pllanda hazir oli getter steerrler
