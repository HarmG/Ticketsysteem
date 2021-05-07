package Ticket;

import Application.*;
import Prioritize.*;
import User.*;

public class Question extends Ticket {
    public Question(User caller, String description, Application application, PriorityLevel impact, PriorityLevel urgency) {
        super(caller, description, application, impact, urgency);
        this.urgency = PriorityLevel.LOW;
        this.impact = PriorityLevel.LOW;
        if (caller.getFunctionRole().equals(FuctionRole.MANAGER)){
            this.urgency = PriorityLevel.MEDIUM;
        }
        this.prioritization = new Prioritization(this);
    }
}
