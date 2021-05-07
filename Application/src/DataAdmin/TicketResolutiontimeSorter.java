package DataAdmin;

import Ticket.Ticket;

import java.util.Comparator;

public class TicketResolutiontimeSorter implements Comparator<Ticket> {

    @Override
    public int compare(Ticket o1, Ticket o2) {
        return o1.getPrioritization().getresolutionEndTime().compareTo(o2.getPrioritization().getresolutionEndTime());
    }
}
