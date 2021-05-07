package DataAdmin;


import Ticket.Ticket;

import java.util.List;

public interface TicketDataHandler {
    public List<Ticket> retrieveTickets();
    public void AddTicket(Ticket ticket);
}
