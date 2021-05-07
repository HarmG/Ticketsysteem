package Actions;

import DataAdmin.ApplicationAdmin;
import DataAdmin.TicketAdmin;
import Ticket.*;
import User.*;

import java.util.List;


public class PrintTicket {

    private TicketAdmin ticketAdmin;
    private ApplicationAdmin applicationAdmin;
    private PrintApplicatie printApplicatie;

    public PrintTicket(TicketAdmin ticketAdmin, ApplicationAdmin applicationAdmin) {
        this.ticketAdmin = ticketAdmin;
        printApplicatie = new PrintApplicatie(applicationAdmin);
    }

    public void printTicketFull(Ticket ticket, User admin) {
        if (ticket == null) {
            System.out.println("Er is geen ticket gevonden om weer te geven");
        } else {
            System.out.println("_________________________________________________________________________________________");
            System.out.println("Caller: " + ticket.getCaller().getFirstname() + " " + ticket.getCaller().getSurname());
            System.out.println("Applicatie: " + ticket.getApplication().getName());
            System.out.println("Omschrijving: " + ticket.getDescription());
            System.out.println("Vraag en antwoord: ");
            printApplicatie.printQandA(ticket);
            System.out.println("Prioriteit: " + ticket.getPrioritization().getPriority());
            System.out.println("Urgentie: " + ticket.getUrgency());
            System.out.println("Impact: " + ticket.getImpact());
            System.out.println("Status: " + ticket.getState());
            if (ticket.getAssignedTo() != null) {
                System.out.println("Toegewezen aan: " + ticket.getAssignedTo().getFirstname() + " " + ticket.getAssignedTo().getSurname());
            }
            //System.out.println("Type Ticket: " + ticket.getTicketType());
            System.out.println("Moment van melden: " + ticket.getReportTime());
            System.out.println("Uiterlijk opgelost op: " + " " + ticket.getPrioritization().getresolutionEndTime());
            if (ticket.getEndTime() != null) {
                System.out.println("Ticket is afgesloten op: " + ticket.getEndTime());
                System.out.println("opgelost door: " + ticket.getResolvedBy().getFirstname() + " " + ticket.getResolvedBy().getSurname());
                System.out.println("Met afsluitende tekst: " + ticket.getCloseNote());
            }
            System.out.println("_________________________________________________________________________________________");
            System.out.println("Opmerkingen: ");
            for (int i = 0; i < ticket.getUserVisibleNote().size(); i++) {
                System.out.println(ticket.getUserVisibleNote().get(i).getUser().getFirstname() + " " + ticket.getUserVisibleNote().get(i).getUser().getSurname());
                System.out.println(ticket.getUserVisibleNote().get(i).getNote());
                System.out.println(ticket.getUserVisibleNote().get(i).getTimeOfNotation());
                System.out.println("_________________________________________________________________________________________");
            }
            if (admin.getFunctionRole().equals(FuctionRole.ADMINISTRATOR)) {
                System.out.println("Werknotities");
                for (int i = 0; i < ticket.getWorkNotes(admin).size(); i++) {
                    System.out.println(ticket.getWorkNotes(admin).get(i).getUser().getFirstname() + " " + ticket.getWorkNotes(admin).get(i).getUser().getSurname());
                    System.out.println(ticket.getWorkNotes(admin).get(i).getNote());
                    System.out.println(ticket.getWorkNotes(admin).get(i).getTimeOfNotation());
                    System.out.println("_________________________________________________________________________________________");
                }
            }
        }
    }

    public void printTicketShort(Ticket ticket) {
        System.out.println(ticketAdmin.getAllTickets().indexOf(ticket) + " Type ticket: " + " Pioriteit: " + ticket.getPrioritization().getPriority() + " SLA: " + ticket.getPrioritization().getresolutionEndTime() + " 2Status: " + ticket.getState());
        System.out.println("_________________________________________________________________________________________");
    }

    public void printOvervieuw(List<Ticket> tickets) {
            for (int i = 0; i < tickets.size(); i++) {
                printTicketShort(tickets.get(i));
            }
        }
}


