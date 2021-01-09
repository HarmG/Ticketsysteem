package Actions;

import Application.*;
import Prioritize.*;
import User.*;
import Ticket.*;

import java.util.Scanner;

public class CreateTicket {
    private User user;
    private TicketAdmin ticketAdmin;
    private ApplicationAdmin applicationAdmin;
    Scanner scanner = new Scanner(System.in);


    public CreateTicket(User user, TicketAdmin ticketAdmin, ApplicationAdmin applicationAdmin) {
        this.ticketAdmin = ticketAdmin;
        this.applicationAdmin = applicationAdmin;
        this.user = user;
    }

    // Todo: afhankelijk van de functierol kan de gebruiker apart worden ingevoerd.
    public void create(TypeTicket typeTicket) {
        System.out.println("Indiener: " + user.getFirstname() + " " + user.getSurname());

        System.out.println("Om welke applicatie gaat het?");
        for (int i = 0; i < applicationAdmin.getAllApplications().size(); i++) {
            System.out.println(i + " " + applicationAdmin.getAllApplications().get(i).getName());
        }
        int applicatieindex = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Omschrijf het probleem waar je tegen aanloopt");
        String omschrijving = scanner.nextLine();
        System.out.println(omschrijving);

        PriorityLevel impact = PriorityLevel.LOW;
        System.out.println("Wie hebben er allemaal last van dit probleem?");
        System.out.println("1. Alleen ik.");
        System.out.println("2. Ik en mijn afdeling.");
        System.out.println("3. De gehele organisatie.");
        int i = scanner.nextInt();
        switch (i) {
            case 1:
                impact = PriorityLevel.LOW;
                System.out.println("De impact is op laag gezet");
                break;
            case 2:
                impact = PriorityLevel.Medium;
                System.out.println("De impact is op gemiddeld gezet");
                break;
            case 3:
                impact = PriorityLevel.HIGH;
                System.out.println("De impact is op hoog gezet");
                break;
            default:
                System.out.println("De impact is op laag gezet.");
        }


        PriorityLevel urgentie = PriorityLevel.LOW;
        System.out.println("In hoeverre kan je je werk uitvoeren?");
        System.out.println("1. Ik kan nog mijn werkzaamheden uitvoeren.");
        System.out.println("2. Ik kan een gedeelte van mijn werk niet uitvoeren.");
        System.out.println("3. Ik kan volledig mijn werk niet uitvoeren.");
        int x = scanner.nextInt();
        switch (x) {
            case 1:
                urgentie = PriorityLevel.LOW;
                System.out.println("De urgentie is op laag gezet");
                break;
            case 2:
                urgentie = PriorityLevel.Medium;
                System.out.println("De urgentie is op gemiddeld gezet");
                break;
            case 3:
                urgentie = PriorityLevel.HIGH;
                System.out.println("De urgentie is op hoog gezet");
                break;
            default:
                System.out.println("De urgentie is op laag gezet.");
        }
        Ticket ticket = new Ticket(user, omschrijving, applicationAdmin.getAllApplications().get(applicatieindex), impact, urgentie, typeTicket);
        ticketAdmin.safeTicket(ticket);

    }

}
