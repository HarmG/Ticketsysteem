package Ticket;

import Application.Application;
import Prioritize.Prioritization;
import User.User;

public class Incident extends Ticket {

    public Incident(User caller, String description, Application application, PriorityLevel impact, PriorityLevel urgency) {
        super(caller, description, application, impact, urgency);
        if (this.getApplication().getCriticalApp()) {
            this.impact = PriorityLevel.HIGH;
            this.urgency = PriorityLevel.HIGH;
        } else if (this.impact.equals(PriorityLevel.LOW) && this.urgency.equals(PriorityLevel.LOW)) {
            this.urgency = PriorityLevel.MEDIUM;
        }
        this.prioritization = new Prioritization(this);
    }

}
