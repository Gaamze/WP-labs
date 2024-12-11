package mk.finki.ukim.mk.lab.web;

//yaratiri servlet ve httplei handle req em resposnlari kullanili
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab.service.EventBookingService;
import mk.finki.ukim.mk.lab.service.EventService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;
            //okuy html file gibi cesileri em procesira edey yarariri final htmli
import java.io.IOException;

@WebServlet(name = "EventBookingServlet", urlPatterns ={ "/event-booking"})// url pattrerbii veriisin  urda
public class EventBookingServlet  extends HttpServlet{

    private final EventService eventService;
    private final SpringTemplateEngine springTemplateEngine;
    private final EventBookingService eventBookingService;


    public EventBookingServlet(EventService eventService, SpringTemplateEngine springTemplateEngine, EventBookingService eventBookingService) {
        this.eventService = eventService;
        this.springTemplateEngine = springTemplateEngine;
        this.eventBookingService = eventBookingService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(request, response);             //thmleafe req em resosne gunderienilmek icin
        WebContext webContext = new WebContext(webExchange);                                                             //variable koyabilmek icin
        String eventName = request.getParameter("eventName");
        String attendeeName = request.getParameter("attendeeName");
        String attendeeAddress = request.getParameter("attendeeAddress");
        int numberOfTickets = Integer.parseInt(request.getParameter("numberOfTickets"));                               // gidey url ya bakay em koyay dataya


        webContext.setVariable("eventName", eventName);
        webContext.setVariable("attendeeName", attendeeName);
        webContext.setVariable("attendeeAddress", attendeeAddress);
        webContext.setVariable("numberOfTickets", numberOfTickets);


        springTemplateEngine.process("bookingConfirmation.html", webContext, response.getWriter());              //ali htmlden em response yapay html bicimde


        //inptu name
        //submit url ya ve posta gururi post=reqest, em redirect kullanisn\
        //confirm page icin alisn url kismi ? isartinde dir url ?=paaarmetr
        //urldan sonra yapays obj alsin urldan


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String eventname= request.getParameter("rad");                                                                // inputaki name burda lazm yazasn aynisni
        int numtickets= Integer.parseInt(request.getParameter("numTickets"));
        String name= request.getParameter("name");
        String address= request.getParameter("address");

        eventBookingService.placeBooking(eventname, name,address, numtickets);

        response.sendRedirect("/event-booking?eventName=" + eventname +
                "&attendeeName=" + name +
                "&attendeeAddress="+ address +
                "&numberOfTickets="+ numtickets);
    }

}
