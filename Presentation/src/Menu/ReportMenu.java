package Menu;

import Actions.PrintTicket;
import Actions.Select;
import Application.Application;
import DataAdmin.ApplicationAdmin;
import Ticket.State;
import DataAdmin.TicketAdmin;
import User.*;
import DataAdmin.UserAdmin;

import java.util.Scanner;

public class ReportMenu {
    private TicketAdmin ticketAdmin;
    private UserAdmin userAdmin;
    private ApplicationAdmin applicationAdmin;
    private User user;
    private Scanner scanner;
    private PrintTicket printTicket;
    private Select select;

    public ReportMenu(TicketAdmin ticketAdmin, UserAdmin userAdmin, ApplicationAdmin applicationAdmin, User user) {
        this.ticketAdmin = ticketAdmin;
        this.userAdmin = userAdmin;
        this.applicationAdmin = applicationAdmin;
        this.user = user;
        this.scanner = new Scanner(System.in);
        this.printTicket = new PrintTicket(ticketAdmin, applicationAdmin);
        this.select = new Select(userAdmin, applicationAdmin, ticketAdmin);
    }

    public void reportMenu() {

        if (user.getFunctionRole().equals(FuctionRole.ADMINISTRATOR)) {
            for (int menu = 1; menu > 0; ) {
                System.out.println("Wat wil je doen? ");
                System.out.println("1. Alle tickets voorbij de oplostijd.");
                System.out.println("2. Incidenten per applicatie");
                System.out.println("3. Tickets toegewezen per gebruiker");
                System.out.println("4. Tickets opgelost per gebruiker");
                System.out.println("5. Tickets per status");
                System.out.println("0. Terug naar hoofdmenu.");
                menu = scanner.nextInt();
                scanner.nextLine();
                switch (menu) {
                    case 0:
                        System.out.println("Terug naar hoofdmenu");
                        break;
                    case 1:
                        printTicket.printOvervieuw(ticketAdmin.getTicketsPastResolutiontime());
                        break;
                    case 2:
                        Application application = select.selectApplication(applicationAdmin.getAllApplications());
                        printTicket.printOvervieuw(ticketAdmin.getTicketsByApplication(application));
                        break;
                    case 3:
                        printTicket.printOvervieuw(ticketAdmin.getTicketsAssignedTo(user));
//                        User admin = select.selectUser(userAdmin.getUsersBasedOnRole(FuctionRole.ADMINISTRATOR));
//                        if(ticketAdmin.getTicketsAssignedTo(admin).size() == 0){
//                            System.out.println("Geen tickets gevonden");
//                        }else {
//                            printTicket.printOvervieuw(ticketAdmin.getTicketsAssignedTo(admin));
//                        }
                        break;
                    case 4:
                        System.out.println(ticketAdmin.getTicketsResolvedBy(user));
                        //printTicket.printOvervieuw();
                        break;
                    case 5:
                        System.out.println("Met welke status wil je de tickets laten zien?");
                        System.out.println("1. New");
                        System.out.println("2. Assigned");
                        System.out.println("3. Resolved");
                        int state = scanner.nextInt();
                        if (state == 1) {
                            System.out.println(ticketAdmin.getTicketsBasedOnState(State.NEW));
                        }else if (state == 2){
                            System.out.println(ticketAdmin.getTicketsBasedOnState(State.ASSIGNED));
                        }else if (state == 3){
                            System.out.println(ticketAdmin.getTicketsBasedOnState(State.RESOLVED));
                        }else {
                            System.out.println("Geen status gevonden");
                        }
                        break;
                }
            }
        }
    }
}
