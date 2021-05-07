package Menu;

import Actions.*;
import DataAdmin.ApplicationAdmin;
import DataAdmin.TicketAdmin;
import DataAdmin.UserAdmin;
import User.*;

import java.util.Scanner;

public class AdminMenu {
    Scanner scanner = new Scanner(System.in);
    private TicketAdmin ticketAdmin;
    private UserAdmin userAdmin;
    private ApplicationAdmin applicationAdmin;
    private CreateTicket createTicket;
    private EditTicket editTicket;
    private CreateUserprofile createUserprofile;
    private EditUserProfile editUserProfile;
    private CreateApplication createApplication;
    private ReportMenu reportMenu;
    private User user;

    public AdminMenu(TicketAdmin ticketAdmin, UserAdmin userAdmin, ApplicationAdmin applicationAdmin, User user) {
        this.ticketAdmin = ticketAdmin;
        this.userAdmin = userAdmin;
        this.applicationAdmin = applicationAdmin;
        this.user = user;
        this.createTicket = new CreateTicket(user, ticketAdmin, applicationAdmin, userAdmin);
        this.editTicket = new EditTicket(ticketAdmin, userAdmin, applicationAdmin);
        createUserprofile = new CreateUserprofile(userAdmin);
        editUserProfile = new EditUserProfile(userAdmin, applicationAdmin, ticketAdmin, user);
        createApplication = new CreateApplication(applicationAdmin, userAdmin, user, ticketAdmin);
        reportMenu = new ReportMenu(ticketAdmin, userAdmin, applicationAdmin, user);
    }

    public void adminMenu() {
        for (int i = 1; i > 0; ) {
            System.out.println("Maak een keuze.");
            System.out.println("1. Ticket aanmaken.");
            System.out.println("2. Tickets beheren.");
            System.out.println("3. Gebruikersprofiel aanmaken");
            System.out.println("4. Gebruikersprofielen beheren.");
            System.out.println("5. Applicatie aanmaken");
            System.out.println("6. Applicatie Beheren");
            System.out.println("7. Rapportages inzien ");
            System.out.println("0. Uitloggen");
            i = scanner.nextInt();
            switch (i) {
                case 0:
                    System.out.println("Uitloggen...");
                    break;
                case 1:
                    System.out.println("Ticket aanmaken");
                    createTicket.create();
                    break;
                case 2:
                    System.out.println("Ticket behandelen");
                    editTicket.EditTicket(user);
                    break;
                case 3:
                    System.out.println("Gebruiker aanmaken");
                    createUserprofile.createNewUser();
                    break;
                case 4:
                    System.out.println("Gebruikersprofielen beheren");
                    editUserProfile.EditUserProfile();
                    break;
                case 5:
                    System.out.println("Applicatie aanmaken");
                    createApplication.createApplication();
                    break;
                case 6:
                    System.out.println("Applicatie beheren");
                    break;
                case 7:
                    System.out.println("Rapportage inzien");
                    reportMenu.reportMenu();
                    break;
                //Todo: Rapportages inzien.
                default:
                    System.out.println("Deze optie is niet beschikbaar");
                    break;
            }
        }
    }
}
