package Actions;

import Application.*;
import DataAdmin.ApplicationAdmin;
import DataAdmin.TicketAdmin;
import DataAdmin.UserAdmin;
import Ticket.*;
import User.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Select {
    private UserAdmin userAdmin;
    private ApplicationAdmin applicationAdmin;
    private TicketAdmin ticketAdmin;
    private Scanner scanner;
    private PrintUsers printUsers;
    private PrintTicket printTicket;
    private PrintApplicatie printApplicatie;
    private int userIndex;
    private int ticketIndex;
    private int applicationIndex;

    public Select(UserAdmin userAdmin, ApplicationAdmin applicationAdmin, TicketAdmin ticketAdmin) {
        this.userAdmin = userAdmin;
        this.applicationAdmin = applicationAdmin;
        this.ticketAdmin = ticketAdmin;
        scanner = new Scanner(System.in);
        printTicket = new PrintTicket(ticketAdmin, applicationAdmin);
        printUsers = new PrintUsers(userAdmin);
        printApplicatie = new PrintApplicatie(applicationAdmin);
    }

    public User selectUser(List<User> users, boolean activeUser){
        User user = null;
        if (users == null){
            return null;
        }else {
            List<User> activeUsers = new ArrayList<>();
            for (int active = 0; active < users.size(); active++){
                if (users.get(active).isActive() == activeUser){
                    activeUsers.add(users.get(active));
                }
            }
            printUsers.printUserOvervieuw(activeUsers);
            System.out.println("Selecteer een gebruiker:");
            this.userIndex = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < users.size(); i++) {
                if (userAdmin.getAllUsers().indexOf(users.get(i)) == userIndex) {
                    user = users.get(i);
                    break;
                }
            }
        }
        return user;
    }

    public Ticket selectTicket(List<Ticket> tickets){
        Ticket ticket = null;
        if (tickets == null){
            return null;
        }else {
            printTicket.printOvervieuw(tickets);
            System.out.println("Selecteer een Ticket:");
            this.ticketIndex = scanner.nextInt();
            for (int i = 0; i < tickets.size(); i++) {
                if (ticketAdmin.getAllTickets().indexOf(tickets.get(i)) == ticketIndex) {
                    ticket = tickets.get(i);
                    break;
                }
            }
        }
        return ticket;
    }

    public Application selectApplication(List<Application> applications){
        Application application = null;
        if (applications == null){
            return null;
        }else {
            printApplicatie.printOvervieuw(applications);
            System.out.println("Selecteer een applicatie:");
            this.applicationIndex = scanner.nextInt();
            for (int i = 0; i < applications.size(); i++) {
                if (applicationAdmin.getAllApplications().indexOf(applications.get(i)) == applicationIndex) {
                    application = applications.get(i);
                    break;
                }
            }
        }
        return application;
    }

}