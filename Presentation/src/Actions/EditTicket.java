package Actions;

import DataAdmin.ApplicationAdmin;
import DataAdmin.TicketAdmin;
import Ticket.PriorityLevel;
import Ticket.*;
import User.User;
import DataAdmin.UserAdmin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EditTicket {
    private Scanner scanner = new Scanner(System.in);
    private TicketAdmin ticketAdmin;
    private UserAdmin userAdmin;
    private ApplicationAdmin applicationAdmin;
    private PrintTicket printTicket;
    private Select select;
    private int ticketIndex;
    private List<Ticket> tickets = new ArrayList<>();

    public EditTicket(TicketAdmin ticketAdmin, UserAdmin userAdmin, ApplicationAdmin applicationAdmin) {
        this.ticketAdmin = ticketAdmin;
        this.userAdmin = userAdmin;
        this.applicationAdmin = applicationAdmin;
        this.printTicket = new PrintTicket(ticketAdmin, applicationAdmin);
        select = new Select(userAdmin, applicationAdmin, ticketAdmin);

    }

    public void EditTicket(User admin) {
        tickets.addAll(ticketAdmin.getTicketsBasedOnState(State.NEW));
        tickets.addAll(ticketAdmin.getTicketsBasedOnState(State.ASSIGNED));
        if (tickets.size() < 1) {
            System.out.println("Er zijn geen openstaande tickets om te behandelen");
        } else {
            Ticket ticket = select.selectTicket(tickets);
            ticketIndex = ticketAdmin.getAllTickets().indexOf(ticket);
            for (int i = 1; i > 0; ) {
                printTicket.printTicketFull(ticketAdmin.getAllTickets().get(ticketIndex), admin);
                System.out.println("Wat wil je aanpassen?");
                System.out.println("1. Applicatie");
                System.out.println("2. Prioriteit");
                System.out.println("3. Type ticket");
                System.out.println("4. opmerking toevoegen");
                System.out.println("5. werk notitie toevoegen");
                System.out.println("6. Ticket afsluiten");
                System.out.println("0. Update ticket");
                i = scanner.nextInt();
                scanner.nextLine();
                switch (i) {
                    case 0:
                        System.out.println("Updating ticket....");
                        break;
                    case 1:
                        //Aanpassen van applicatie.
                        System.out.println("Huidige applicatie: " + ticketAdmin.getAllTickets().get(ticketIndex).getApplication());
                        System.out.println("Kies een niewe applicatie: ");
                        for (int a = 0; a < applicationAdmin.getAllApplications().size(); a++) {
                            System.out.println(a + " " + applicationAdmin.getAllApplications().get(a).getName());
                            System.out.println("Applicatie is veranderd naar " + ticketAdmin.getAllTickets().get(ticketIndex).getApplication());
                        }
                        int appIndex = scanner.nextInt();
                        scanner.nextLine();
                        ticketAdmin.getAllTickets().get(ticketIndex).setApplication(applicationAdmin.getAllApplications().get(appIndex), admin);
                        break;
                    case 2:
                        //Prio aan passen
                        System.out.println("Huidige Prio: " + ticketAdmin.getAllTickets().get(ticketIndex).getPrioritization().getPriority());
                        System.out.println("Kritische applicatie = " + ticketAdmin.getAllTickets().get(ticketIndex).getApplication().getCriticalApp());
                        System.out.println("Waar wil je de urgentie naar veranderen?");
                        System.out.println("1. Laag");
                        System.out.println("2. Gemiddeld");
                        System.out.println("3. Hoog");
                        int urgency = scanner.nextInt();
                        scanner.nextLine();
                        switch (urgency) {
                            case 1:
                                ticketAdmin.getAllTickets().get(ticketIndex).setUrgency(PriorityLevel.LOW);
                                break;
                            case 2:
                                ticketAdmin.getAllTickets().get(ticketIndex).setUrgency(PriorityLevel.MEDIUM);
                                break;
                            case 3:
                                ticketAdmin.getAllTickets().get(ticketIndex).setUrgency(PriorityLevel.HIGH);
                                break;
                        }
                        System.out.println("Waar wil je de Prioriteit naar veranderen?");
                        System.out.println("1. Laag");
                        System.out.println("2. Gemiddeld");
                        System.out.println("3. Hoog");
                        int impact = scanner.nextInt();
                        scanner.nextLine();
                        switch (impact) {
                            case 1:
                                ticketAdmin.getAllTickets().get(ticketIndex).setImpact(PriorityLevel.LOW);
                                break;
                            case 2:
                                ticketAdmin.getAllTickets().get(ticketIndex).setImpact(PriorityLevel.MEDIUM);
                                break;
                            case 3:
                                ticketAdmin.getAllTickets().get(ticketIndex).setImpact(PriorityLevel.HIGH);
                                break;
                        }
                        System.out.println("Prioriteit is aangepast naar: " + ticketAdmin.getAllTickets().get(ticketIndex).getPrioritization().getPriority());
                        System.out.println("Nieuwe eindtijd is: " + ticketAdmin.getAllTickets().get(ticketIndex).getPrioritization().getresolutionEndTime());
                        break;
                    case 3:
                        System.out.println("Deze functie is nog niet beschikbaar");
                        break;
                    case 4:
                        //opmerking toevoegen
                        System.out.println("Voeg een opmerking toe: ");
                        String remark = scanner.nextLine();
                        ticketAdmin.getAllTickets().get(ticketIndex).addUserVisibleNote(remark, admin);
                        System.out.println("Opmerking is toegevoegd");
                        break;
                    case 5:
                        //werknotitie toevoegen
                        System.out.println("Voeg een werknotitie toe: ");
                        String worknote = scanner.nextLine();
                        ticketAdmin.getAllTickets().get(ticketIndex).addWorkNote(worknote, admin);
                        System.out.println("werknotitie is toegevoegd");
                        break;
                    case 6:
                        //Ticket afsluiten
                        System.out.println("Weet je zeker dat je de ticket wil afsluiten?");
                        System.out.println("1. Ja");
                        System.out.println("2. Nee");
                        int answer = scanner.nextInt();
                        scanner.nextLine();
                        if (answer == 1) {
                            System.out.println("Afsluitende tekst:");
                            String closenote = scanner.nextLine();
                            ticketAdmin.getAllTickets().get(ticketIndex).resolveTicket(admin, closenote);
                            i = 0;
                        }
                        break;
                }
            }
        }
    }
}

