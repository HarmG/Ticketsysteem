package Menu;

import Actions.PrintTicket;
import Application.ApplicationAdmin;
import Ticket.TicketAdmin;
import User.UserAdmin;

import java.util.Scanner;

public class AdminMenu {
    Scanner scanner = new Scanner(System.in);
    private TicketAdmin ticketAdmin;
    private UserAdmin userAdmin;
    private ApplicationAdmin applicationAdmin;
    private PrintTicket printTicket;

    public AdminMenu(TicketAdmin ticketAdmin, UserAdmin userAdmin, ApplicationAdmin applicationAdmin) {
        this.ticketAdmin = ticketAdmin;
        this.userAdmin = userAdmin;
        this.applicationAdmin = applicationAdmin;
        this.printTicket = new PrintTicket();
    }

    public void adminMenu() {
        for (int i = 1; i > 0; ) {
            System.out.println("Maak een keuze.");
            System.out.println("1. Ticket aanmaken.");
            System.out.println("2. Tickets beheren.");
            System.out.println("3. Gebruikersprofielen beheren.");
            System.out.println("4. Rapportages inzien ");
            System.out.println("0. Afsluiten");
            i = scanner.nextInt();
            switch (i) {
                case 0:
                    System.out.println("Afsluiten...");
                    break;
                case 1:
                    System.out.println("Ticket aanmaken");
                    break;
                //Todo: Ticket aan maken (voor IT-medewerkers).
                case 2:
                    System.out.println("Ticket behandelen");
                    printTicket.printOvervieuw(ticketAdmin.getOpenTickets());
                    break;
                //Todo: Tickets behandelen.
                case 3:
                    System.out.println("Gebruikersprofiel beheren");
                    break;
                //Todo: Gebruikersprofielen beheren.
                case 4:
                    System.out.println("Rapportage inzien");
                    break;
                //Todo: Rapportages inzien.
                default:
                    System.out.println("Deze optie is niet beschikbaar");
                    break;
            }
        }
    }
}
