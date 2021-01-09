package Ticket;


import DataAdmin.TicketDataHandler;
import User.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TicketAdmin{
    //Todo: uitzoeken of hier een array moet staan of alleen de datahandeler

    private TicketDataHandler ticketDataHandler;
    List<Ticket> tickets = new ArrayList<>();
    public TicketAdmin(TicketDataHandler ticketDataHandler) {
       this.ticketDataHandler = ticketDataHandler;
    }

    public List<Ticket> getAllTickets() {
        return ticketDataHandler.retrieveData();
    }


    public List<Ticket> getOpenTickets(){
        //Todo: is hier een slimmere manier voor?
        tickets.clear();
        for(int i = 0; i < ticketDataHandler.retrieveData().size(); i++ ){
            if(ticketDataHandler.retrieveData().get(i).getState().equals(State.ASSIGNED) || ticketDataHandler.retrieveData().get(i).getState().equals(State.NEW)){
                tickets.add(ticketDataHandler.retrieveData().get(i));
            }else {
            }
        }
        tickets.sort(new TicketResolutiontimeSorter());
        return tickets;
    }

    public List<Ticket> getPersonalTickets(User user) {
        //Todo: hier is een makkelijkere manier voor (dubbele code)
        tickets.clear();
            for (int i = 0; i < ticketDataHandler.retrieveData().size(); i++) {
                if (ticketDataHandler.retrieveData().get(i).getCaller().getEmailAddress().equals(user.getEmailAddress())) {
                    tickets.add(ticketDataHandler.retrieveData().get(i));
                }
            }
        return tickets;
    }

    public void safeTicket(Ticket ticket){
        ticketDataHandler.AddTicket(ticket);
    }

}
