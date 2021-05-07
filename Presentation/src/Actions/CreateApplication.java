package Actions;

import Application.Application;
import DataAdmin.ApplicationAdmin;
import DataAdmin.TicketAdmin;
import DataAdmin.UserAdmin;
import User.*;

import java.util.Scanner;

public class CreateApplication {

    private ApplicationAdmin applicationAdmin;
    private UserAdmin userAdmin;
    private User admin;
    private PrintUsers printUsers;
    private Scanner scanner;
    private Select select;

    public CreateApplication(ApplicationAdmin applicationAdmin, UserAdmin userAdmin, User admin, TicketAdmin ticketAdmin) {
        this.applicationAdmin = applicationAdmin;
        this.userAdmin = userAdmin;
        this.admin = admin;
        this.scanner = new Scanner(System.in);
        this.printUsers = new PrintUsers(userAdmin);
        this.select = new Select(userAdmin, applicationAdmin, ticketAdmin);
    }

    public void createApplication(){
        System.out.println("Voer de naam van de applicatie in: ");
        String name = scanner.nextLine();
        User administrator = select.selectUser(userAdmin.getUsersBasedOnRole(FuctionRole.ADMINISTRATOR), true);
        scanner.nextLine();
        boolean critical = false;

        int input = 0;
        boolean choisemade = false;
        while (choisemade == true) {
            System.out.println("Is de Applicatie kritich?");
            System.out.println("1. Ja");
            System.out.println("2. Nee");
            input = scanner.nextInt();
            scanner.nextLine();
            if (input == 1) {
                critical = true;
                System.out.println("Applicatie is op kritisch gezet.");
                choisemade = true;
            } else {
                System.out.println("Applicatie is op niet kritisch gezet.");
                choisemade = true;
            }
        }
        applicationAdmin.addApplication(new Application(name,admin, critical,administrator));

    }
}
