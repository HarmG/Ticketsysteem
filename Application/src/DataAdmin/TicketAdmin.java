package DataAdmin;


import Application.Application;
import Ticket.*;
import User.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TicketAdmin{

    private TicketDataHandler ticketDataHandler;
    List<Ticket> tickets = new ArrayList<>();
    public TicketAdmin(TicketDataHandler ticketDataHandler) {
       this.ticketDataHandler = ticketDataHandler;
    }

    public List<Ticket> getAllTickets() {
        return ticketDataHandler.retrieveTickets();
    }


    public List<Ticket> getTicketsBasedOnState(State state){
        tickets.clear();
        for(int i = 0; i < ticketDataHandler.retrieveTickets().size(); i++ ){
            if(ticketDataHandler.retrieveTickets().get(i).getState().equals(state)){
                tickets.add(ticketDataHandler.retrieveTickets().get(i));
            }else {
            }
        }
        tickets.sort(new TicketResolutiontimeSorter());
        return tickets;
    }

    public List<Ticket> getPersonalTickets(User user, State state) {
        tickets.clear();
            for (int i = 0; i < ticketDataHandler.retrieveTickets().size(); i++) {
                if (ticketDataHandler.retrieveTickets().get(i).getCaller().getEmailAddress().equals(user.getEmailAddress()) && ticketDataHandler.retrieveTickets().get(i).getState().equals(state)) {
                    tickets.add(ticketDataHandler.retrieveTickets().get(i));
                }
            }
        return tickets;
    }

    public List<Ticket> getTicketsPastResolutiontime(){
        tickets.clear();
        for (int i = 0; i < ticketDataHandler.retrieveTickets().size(); i++){
            if (ticketDataHandler.retrieveTickets().get(i).getPrioritization().getresolutionEndTime().isBefore(LocalDateTime.now())){
                tickets.add(ticketDataHandler.retrieveTickets().get(i));
            }
        }
        return tickets;
    }

    public List<Ticket> getTicketsAssignedTo(User user) {
        tickets.clear();
        for (int i = 0; i < ticketDataHandler.retrieveTickets().size(); i++) {
            if (ticketDataHandler.retrieveTickets().get(i).getAssignedTo().getEmailAddress().equals(user.getEmailAddress())){
                tickets.add(ticketDataHandler.retrieveTickets().get(i));
            }
        }
        return tickets;
    }

    public List<Ticket> getTicketsResolvedBy(User user) {
        tickets.clear();
        for (int i = 0; i < ticketDataHandler.retrieveTickets().size(); i++) {
            if (ticketDataHandler.retrieveTickets().get(i).getResolvedBy().getEmailAddress().equals(user.getEmailAddress())){
                tickets.add(ticketDataHandler.retrieveTickets().get(i));
            }
        }
        return tickets;
    }

    public List<Ticket> getTicketsByApplication(Application application){
        tickets.clear();
        for (int i = 0; i < ticketDataHandler.retrieveTickets().size(); i++){
            if (ticketDataHandler.retrieveTickets().get(i).getApplication().getName().equals(application.getName())){
                tickets.add(ticketDataHandler.retrieveTickets().get(i));
            }
        }
        return tickets;
    }

    public void safeTicket(Ticket ticket){
        ticketDataHandler.AddTicket(ticket);
    }

}
