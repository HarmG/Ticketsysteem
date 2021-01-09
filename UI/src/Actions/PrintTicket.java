package Actions;

import Ticket.Ticket;

import java.util.List;


public class PrintTicket {

    public PrintTicket() {

    }

    public void printTicketFull(Ticket ticket){
        System.out.println("_________________________________________________________________________________________");
        System.out.println("Caller: "+ticket.getCaller().getFirstname()+" "+ticket.getCaller().getSurname());
        System.out.println("Applicatie: "+ticket.getApplication().getName());
        System.out.println("Omschrijving: "+ticket.getDescription());
        System.out.println("Prioriteit: "+ticket.getPriority().getPriority());
        System.out.println("Status: "+ticket.getState());
        System.out.println("Type Ticket: "+ticket.getTicketType());
        System.out.println("Moment van melden: "+ticket.getReportTime());
        System.out.println("Uiterlijk opgelost op: "+" "+ticket.getPriority().getresolutionEndTime());
        System.out.println("_________________________________________________________________________________________");
    }

    public void printTicketShort(int i, Ticket ticket){
        System.out.println(i+" Type ticket: "+ticket.getTicketType()+" Pioriteit: "+ticket.getPriority().getPriority()+" SLA: "+ticket.getPriority().getresolutionEndTime()+" 2Status: "+ticket.getState());
        System.out.println("_________________________________________________________________________________________");
    }

    public void printOvervieuw(List<Ticket> tickets){
        for(int i = 0; i < tickets.size(); i++){
            printTicketShort(i, tickets.get(i));
        }
    }
}


