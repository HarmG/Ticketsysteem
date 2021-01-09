package Ticket;

import java.util.Comparator;

public class TicketResolutiontimeSorter implements Comparator<Ticket> {

    @Override
    public int compare(Ticket o1, Ticket o2) {
        return o1.getPriority().getresolutionEndTime().compareTo(o2.getPriority().getresolutionEndTime());
    }
}
