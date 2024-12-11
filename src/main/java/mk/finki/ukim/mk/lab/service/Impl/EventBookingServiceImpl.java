package mk.finki.ukim.mk.lab.service.Impl;

import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.service.EventBookingService;
import org.springframework.stereotype.Service;// anotacija iicn


@Service// servis yapmasin aardimci oli  omrubi surdurebilmek iicn
public class EventBookingServiceImpl implements EventBookingService {

    @Override
    public EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, int numberOfTickets) {
        return new EventBooking(eventName,attendeeName,attendeeAddress, (long) numberOfTickets);
    }
    //yapay ve gunderi yeni  objekt detallerle
}
