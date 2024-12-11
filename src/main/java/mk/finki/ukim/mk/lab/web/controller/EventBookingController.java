package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.service.EventBookingService;
import mk.finki.ukim.mk.lab.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EventBookingController {

    private final EventService eventService;
    private final EventBookingService eventBookingService;

    public EventBookingController(EventService eventService, EventBookingService eventBookingService) {
        this.eventService = eventService;
        this.eventBookingService = eventBookingService;
    }

    @GetMapping("/event-booking")
    public String getBookingConfirmationPage(@RequestParam String eventName,               //  annotations extract query parameters from the URL
                                             @RequestParam String attendeeName,
                                             @RequestParam String attendeeAddress,
                                             @RequestParam int numberOfTickets,
                                             Model model) {

        model.addAttribute("eventName", eventName);
        model.addAttribute("attendeeName", attendeeName);
        model.addAttribute("attendeeAddress", attendeeAddress);
        model.addAttribute("numberOfTickets", numberOfTickets);

        return "bookingConfirmation";                                   // equivalent to bookingConfirmation.html
    }

    @PostMapping("/event-booking")                         //This ensures the user can see a confirmation of their booking.
    public String placeBooking(@RequestParam String eventName,
                               @RequestParam String name,
                               @RequestParam String address,
                               @RequestParam int numTickets) {

        eventBookingService.placeBooking(eventName, name, address, numTickets);

        return "redirect:/event-booking?eventName=" + eventName +
                "&attendeeName=" + name +
                "&attendeeAddress=" + address +
                "&numberOfTickets=" + numTickets;
    }
}

