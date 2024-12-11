package mk.finki.ukim.mk.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
//import ch.qos.logback.core.model.Model;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.service.EventService;
import mk.finki.ukim.mk.lab.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EventController {

    private final EventService eventService;
    private final LocationService locationService;

    public EventController(EventService eventService, LocationService locationService) {
        this.eventService = eventService;
        this.locationService = locationService;
    }

    @GetMapping("/events")
    public String getEventsPage(Model model, HttpServletRequest req)
    {
        model.addAttribute("events", eventService.listAll());
//        String username = req.getRemoteUser();  //imported httpservlerrequest so we can have access to user info

        return "listEvents";
    }

    @GetMapping("/events/add")
    public String getAddEventPage(Model model){
        model.addAttribute("locations", locationService.findAll());

        return "event-form";
    }

    @PostMapping("/events/add")
    public String saveEvent( @RequestParam String eventname,
                             @RequestParam String description,
                             @RequestParam double popularityScore,
                             @RequestParam Long locationId){

        eventService.saveEvent(eventname, description, popularityScore,locationId);
        return "redirect:/events";

    }

    @GetMapping("/events/edit/{id}")
    public String getEditEvent(@PathVariable Long id, Model model){
        Event event = eventService.getEventById(id);
        model.addAttribute("event", event);
        model.addAttribute("locations", locationService.findAll());
        return "event-form";
    }


    @PostMapping("/events/edit/{id}")
    public String editEvent(@PathVariable Long id,
                            @RequestParam String eventname,
                            @RequestParam String description,
                            @RequestParam double popularityScore,
                            @RequestParam Long locationId)
    {
        eventService.editEvent(eventname, description, popularityScore,id, locationId);
        return "redirect:/events";
    }


    @PostMapping("/events/delete/{id}")
    public String deleteEvent(@PathVariable Long id)
    {
        System.out.println(id);
        eventService.deleteById(id);
        return "redirect:/events";
    }

}
