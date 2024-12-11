package mk.finki.ukim.mk.lab.web;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.service.EventService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "/events", urlPatterns = "/events") //mapiranje bule yapili
public class EventListSevlet extends HttpServlet {
    private final EventService eventService;
    //evenleti geri almak icin
    private final SpringTemplateEngine springTemplateEngine;
    //html sayfasin islemek icin
    public EventListSevlet(EventService eventService, SpringTemplateEngine springTemplateEngine) {
        this.eventService = eventService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(request, response);
        WebContext webContext = new WebContext(webExchange);

        String text = request.getParameter("searchEvent");

        List<Event> allevents = eventService.listAll();
        List<Event> searchevents;

        if (text == null || text.isEmpty()) {
            // If search term is empty, use all events
            searchevents = allevents;
        } else {
            // Otherwise, search with the provided text and score
            searchevents = eventService.searchEvents(text, 0);
        }

        webContext.setVariable("events", searchevents.isEmpty() ? allevents : searchevents);

        springTemplateEngine.process("listEvents.html", webContext, response.getWriter());
    }

}
