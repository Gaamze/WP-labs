package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.EventBooking;//eetnboking cclasi importt edy modelden
import org.springframework.stereotype.Service; //service anotetion from spring to mark a classs as a service component?

public interface EventBookingService{
        EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, int numberOfTickets);
        //4 paramater ad,ad,adres int deger em ceviri eventbooking obj dunduri
}
