package Prioritize;

import Ticket.*;

import java.time.LocalDateTime;

public class Prioritization {
    private Priority priority;
    private LocalDateTime resolutionEndTime;

    public Prioritization(Ticket ticket) {
            this.priority = PriorityCalc(ticket);
            this.resolutionEndTime = resolutionEndTimeCalc(priority, ticket);
        }

        public void reCalc(Ticket ticket){
            this.priority = PriorityCalc(ticket);
            this.resolutionEndTime = resolutionEndTimeCalc(priority, ticket);
        }

    // Tijd word berekend op basis van de start tijd van de ticket.
    private LocalDateTime resolutionEndTimeCalc(Priority priority, Ticket ticket) {
        if (priority == Priority.CRITICAL) {
            LocalDateTime nextTime = ticket.getReportTime().plusHours(1);
            return nextTime;
        } else if (priority == Priority.HIGH) {
            LocalDateTime nextTime = ticket.getReportTime().plusHours(4);
            return nextTime;
        } else if (priority == Priority.MEDIUM) {
            LocalDateTime nextTime = ticket.getReportTime().plusHours(48);
            return nextTime;
        } else if (priority == Priority.LOW) {
            LocalDateTime nextTime = ticket.getReportTime().plusHours(168);
            return nextTime;
        } else if (priority == Priority.PLAN) {
            LocalDateTime nextTime = ticket.getReportTime().plusHours(336);
            return nextTime;
        }else {
            return ticket.getReportTime().plusHours(336);
        }
    }

    //Op basis van impact en urgentie word de prio berekend. impact en urgentie word ook beinvloed door de applicatie.
    private Priority PriorityCalc(Ticket ticket) {
        if (ticket.getImpact() == PriorityLevel.LOW && ticket.getUrgency() == PriorityLevel.LOW) {
            return Priority.PLAN;
        } else if (ticket.getImpact() == PriorityLevel.LOW && ticket.getUrgency() == PriorityLevel.MEDIUM || ticket.getImpact() == PriorityLevel.MEDIUM && ticket.getUrgency() == PriorityLevel.LOW) {
            return Priority.LOW;
        } else if (ticket.getImpact() == PriorityLevel.MEDIUM && ticket.getUrgency() == PriorityLevel.MEDIUM || ticket.getImpact() == PriorityLevel.LOW && ticket.getUrgency() == PriorityLevel.HIGH || ticket.getImpact() == PriorityLevel.HIGH && ticket.getUrgency() == PriorityLevel.LOW) {
            return Priority.MEDIUM;
        } else if (ticket.getImpact() == PriorityLevel.HIGH && ticket.getUrgency() == PriorityLevel.MEDIUM || ticket.getImpact() == PriorityLevel.MEDIUM && ticket.getUrgency() == PriorityLevel.HIGH) {
            return Priority.HIGH;
        } else if (ticket.getImpact() == PriorityLevel.HIGH && ticket.getUrgency() == PriorityLevel.HIGH) {
            return Priority.CRITICAL;
        }else {
            return Priority.PLAN;
        }
    }

    public Priority getPriority() {
        return priority;
    }

    public LocalDateTime getresolutionEndTime() {
        return resolutionEndTime;
    }

}
