package Ticket;

import Application.Application;
import Prioritize.Prioritization;
import User.User;

public class Request extends Ticket{

    public Request(User caller, String description, Application application, PriorityLevel impact, PriorityLevel urgency) {
        super(caller, description, application, impact, urgency);
        if (impact != PriorityLevel.MEDIUM && urgency != PriorityLevel.MEDIUM){
            this.impact = PriorityLevel.MEDIUM;
            this.impact = PriorityLevel.MEDIUM;
        }
        this.prioritization = new Prioritization(this);
    }
}
