package DataStore;

import DataAdmin.TicketDataHandler;
import Ticket.*;

import java.util.ArrayList;

public class TicketData implements TicketDataHandler {

    ArrayList<Ticket> tickets = new ArrayList<>();
    private ApplicationData applicatie = new ApplicationData();
    private UserData gebruiker = new UserData();

    public TicketData() {
//        tickets.add(new Incident(gebruiker.retrieveData().get(4), "Hoe kan ik de applicatie opstarten?", applicatie.retrieveData().get(0), PriorityLevel.LOW, PriorityLevel.LOW));
//        tickets.add(new Question(gebruiker.retrieveData().get(4), "De applicatie werkt niet naar behoren", applicatie.retrieveData().get(2), PriorityLevel.Medium, PriorityLevel.Medium));
//        tickets.add(new Question(gebruiker.retrieveData().get(5), "De applicatie werkt niet naar behoren", applicatie.retrieveData().get(6), PriorityLevel.HIGH, PriorityLevel.Medium));
//        tickets.add(new Incident(gebruiker.retrieveData().get(3), "De applicatie werkt niet naar behoren", applicatie.retrieveData().get(4), PriorityLevel.Medium, PriorityLevel.HIGH));
//        tickets.add(new Question(gebruiker.retrieveData().get(0), "De applicatie werkt niet naar behoren", applicatie.retrieveData().get(5), PriorityLevel.HIGH, PriorityLevel.HIGH));
//        tickets.add(new Incident(gebruiker.retrieveData().get(1), "Hoe kan ik de applicatie opstarten?", applicatie.retrieveData().get(0), PriorityLevel.LOW, PriorityLevel.Medium));
//        tickets.add(new Incident(gebruiker.retrieveData().get(5), "ODe applicatie werkt niet naar behoren", applicatie.retrieveData().get(0), PriorityLevel.Medium, PriorityLevel.LOW));
//        tickets.add(new Incident(gebruiker.retrieveData().get(5), "De applicatie werkt niet naar behoren", applicatie.retrieveData().get(3), PriorityLevel.LOW, PriorityLevel.Medium));
//        tickets.add(new Incident(gebruiker.retrieveData().get(0), "Hoe kan ik de applicatie opstarten?", applicatie.retrieveData().get(3), PriorityLevel.LOW, PriorityLevel.HIGH));
//        tickets.add(new Question(gebruiker.retrieveData().get(2), "Hoe kan ik de applicatie opstarten?", applicatie.retrieveData().get(3), PriorityLevel.HIGH, PriorityLevel.HIGH));
//        tickets.add(new Question(gebruiker.retrieveData().get(6), "De applicatie werkt niet naar behoren", applicatie.retrieveData().get(5), PriorityLevel.HIGH, PriorityLevel.LOW));
//        tickets.add(new Incident(gebruiker.retrieveData().get(4), "De applicatie werkt niet naar behoren", applicatie.retrieveData().get(2), PriorityLevel.LOW, PriorityLevel.HIGH));
//        tickets.add(new Incident(gebruiker.retrieveData().get(2), "De applicatie werkt niet naar behoren", applicatie.retrieveData().get(1), PriorityLevel.Medium, PriorityLevel.HIGH));
//        tickets.add(new Question(gebruiker.retrieveData().get(5), "De applicatie werkt niet naar behoren", applicatie.retrieveData().get(1), PriorityLevel.HIGH, PriorityLevel.LOW));
//        tickets.add(new Incident(gebruiker.retrieveData().get(3), "De applicatie werkt niet naar behoren", applicatie.retrieveData().get(0), PriorityLevel.HIGH, PriorityLevel.Medium));
//        tickets.add(new Incident(gebruiker.retrieveData().get(0), "De applicatie werkt niet naar behoren", applicatie.retrieveData().get(5), PriorityLevel.HIGH, PriorityLevel.HIGH));
//        tickets.add(new Question(gebruiker.retrieveData().get(1), "Hoe kan ik de applicatie opstarten?", applicatie.retrieveData().get(1), PriorityLevel.LOW, PriorityLevel.LOW));
//        tickets.add(new Question(gebruiker.retrieveData().get(1), "Hoe kan ik de applicatie opstarten?", applicatie.retrieveData().get(0), PriorityLevel.Medium, PriorityLevel.LOW));
//        tickets.add(new Incident(gebruiker.retrieveData().get(9), "De applicatie werkt niet naar behoren", applicatie.retrieveData().get(0), PriorityLevel.Medium, PriorityLevel.HIGH));
//        tickets.add(new Incident(gebruiker.retrieveData().get(0), "Hoe kan ik de applicatie opstarten?", applicatie.retrieveData().get(2), PriorityLevel.LOW, PriorityLevel.Medium));
//        tickets.add(new Incident(gebruiker.retrieveData().get(8), "De applicatie werkt niet naar behoren", applicatie.retrieveData().get(3), PriorityLevel.Medium, PriorityLevel.Medium));
//        tickets.add(new Question(gebruiker.retrieveData().get(6), "Hoe kan ik de applicatie opstarten?", applicatie.retrieveData().get(6), PriorityLevel.Medium, PriorityLevel.Medium));

    }

    @Override
    public ArrayList<Ticket> retrieveTickets() {
        return tickets;
    }


    @Override
    public void AddTicket(Ticket ticket) {
    tickets.add(ticket);
    }
}

