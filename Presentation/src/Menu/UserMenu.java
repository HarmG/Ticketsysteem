package Menu;

import Actions.CreateTicket;
import Actions.PrintTicket;
import Actions.Select;
import DataAdmin.ApplicationAdmin;
import DataAdmin.UserAdmin;
import Ticket.State;
import Ticket.Ticket;
import DataAdmin.TicketAdmin;
import User.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserMenu {
    Scanner scanner = new Scanner(System.in);
    private TicketAdmin ticketAdmin;
    private ApplicationAdmin applicationAdmin;
    private UserAdmin userAdmin;
    private User user;
    private CreateTicket createTicket;
    private PrintTicket printTicket;
    private Select select;

    public UserMenu(TicketAdmin ticketAdmin, ApplicationAdmin applicationAdmin, UserAdmin userAdmin, User user) {
        this.ticketAdmin = ticketAdmin;
        this.applicationAdmin = applicationAdmin;
        this.userAdmin = userAdmin;
        this.user = user;
        createTicket = new CreateTicket(user, ticketAdmin, applicationAdmin, userAdmin);
        printTicket = new PrintTicket(ticketAdmin, applicationAdmin);
        select = new Select(userAdmin, applicationAdmin, ticketAdmin);
    }


    public void userMenu() {
        for (int i = 1; i > 0; ) {
            System.out.println("Maak een keuze.");
            System.out.println("1. Maak een ticket");
            System.out.println("2. Bekijken je openstaande tickets");
            System.out.println("3. Bekijke je opgeloste tickets");
            System.out.println("0. Uitloggen");
            i = scanner.nextInt();
            switch (i) {
                case 0:
                    System.out.println("Afsluiten...");
                    break;
                case 1:
                    System.out.println("Ticket aanmaken");
                    createTicket.create();
                    break;
                case 2:
                    System.out.println("Open tickets inzien");
                    List<Ticket> personalTickets = new ArrayList<>();
                    personalTickets.addAll(ticketAdmin.getPersonalTickets(user, State.NEW));
                    personalTickets.addAll((ticketAdmin.getPersonalTickets(user, State.ASSIGNED)));
                    if (personalTickets.size() < 1){
                        System.out.println("er zijn geen openstaande tickts voor je aangemaakt");
                    }else {
                        printTicket.printTicketFull(select.selectTicket(personalTickets), user);
                    }
                    break;
                case 3:
                    System.out.println("Afgesloten tickets inzien");

                    printTicket.printTicketFull(select.selectTicket(ticketAdmin.getPersonalTickets(user, State.RESOLVED)),user);
                    break;
                //Todo: tickets inzien
                default:
                    System.out.println("Deze optie is niet beschikbaar");
                    break;
            }
        }
    }
}
