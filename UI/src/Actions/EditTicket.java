package Actions;

import Application.Application;
import Application.ApplicationAdmin;
import Ticket.*;
import User.User;
import User.UserAdmin;

import java.util.Scanner;

public class EditTicket {
    private Scanner scanner = new Scanner(System.in);
    private TicketAdmin ticketAdmin;
    private UserAdmin userAdmin;
    private ApplicationAdmin applicationAdmin;
    private User admin;
    private Ticket ticket;
    private PrintTicket printTicket;

    public EditTicket(TicketAdmin ticketAdmin, UserAdmin userAdmin, ApplicationAdmin applicationAdmin, Ticket ticket, User admin) {
        this.ticketAdmin = ticketAdmin;
        this.userAdmin = userAdmin;
        this.applicationAdmin = applicationAdmin;
        this.admin = admin;
        this.ticket = ticket;
        this.printTicket = new PrintTicket();
    }

    public void EditTicket(Ticket ticket) {
        for (int i = 1; i > 0; ) {
            printTicket.printTicketFull(ticket);
            System.out.println("Wat wil je aanpassen?");
            System.out.println("1. Applicatie");
            System.out.println("2. Prioriteit");
            System.out.println("3. Type ticket");
            System.out.println("4. opmerking toevoegen");
            System.out.println("5. werk notitie toevoegen");
            System.out.println("6. Ticket afsluiten");
            System.out.println("0. Annuleren");
            i = scanner.nextInt();
            switch (i) {
                case 0:
                    System.out.println("Annuleren....");
                    break;
                case 1:
                    //Aanpassen van applicatie.
                    System.out.println("Huidige applicatie: "+ticket.getApplication());
                    System.out.println("Kies een niewe applicatie: ");
                    for (int a = 0; a < applicationAdmin.getAllApplications().size(); a++){
                        System.out.println(a+" "+applicationAdmin.getAllApplications().get(a).getName());
                        System.out.println("Applicatie is veranderd naar "+ticket.getApplication());
                    }
                    int appIndex = scanner.nextInt();
                    ticket.setApplication(applicationAdmin.getAllApplications().get(appIndex), admin);
                    break;
                case 2:
                    //Prio aan passen
                    System.out.println();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
            }
        }
    }
}
