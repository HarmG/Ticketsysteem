package DataAdmin;


import Ticket.Ticket;

import java.util.List;

public interface TicketDataHandler {
    public List<Ticket> retrieveData();
    public void AddTicket(Ticket ticket);
}
