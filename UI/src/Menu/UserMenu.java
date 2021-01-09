package Menu;

import Actions.CreateTicket;
import Actions.PrintTicket;
import Application.ApplicationAdmin;
import Ticket.TicketAdmin;
import Ticket.TypeTicket;
import User.User;

import java.util.Scanner;

public class UserMenu {
    Scanner scanner = new Scanner(System.in);
    private TicketAdmin ticketAdmin;
    private ApplicationAdmin applicationAdmin;
    private User user;
    private CreateTicket createTicket;
    private PrintTicket printTicket;

    public UserMenu(TicketAdmin ticketAdmin, ApplicationAdmin applicationAdmin, User user) {
        this.ticketAdmin = ticketAdmin;
        this.applicationAdmin = applicationAdmin;
        this.user = user;
        createTicket = new CreateTicket(user, ticketAdmin, applicationAdmin);
        printTicket = new PrintTicket();
    }


    public void userMenu() {
        for (int i = 1; i > 0; ) {
            System.out.println("Maak een keuze.");
            System.out.println("1. Meld een incident");
            System.out.println("2. Stel een vraag");
            System.out.println("3. Bekijk persoonlijke tickets");
            System.out.println("0. Afsluiten");
            i = scanner.nextInt();
            switch (i) {
                case 0:
                    System.out.println("Afsluiten...");
                    break;
                case 1:
                    System.out.println("Incident melden");
                    createTicket.create(TypeTicket.INCIDENT);
                    break;
                //Todo: Ticket aan maken
                case 2:
                    System.out.println("Vraag Stellen");
                    createTicket.create(TypeTicket.QUESTION);
                case 3:
                    System.out.println("Tickets inzien");
                    for (i = 0; i < ticketAdmin.getPersonalTickets(user).size(); i++){
                        printTicket.printTicketFull(ticketAdmin.getPersonalTickets(user).get(i));
                    }
                    break;
                //Todo: tickets inzien
                default:
                    System.out.println("Deze optie is niet beschikbaar");
                    break;
            }
        }
    }
}
