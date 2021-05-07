package Menu;

import DataAdmin.ApplicationAdmin;
import DataAdmin.UserAdmin;
import Login.Login;
import DataAdmin.TicketAdmin;
import User.*;

import java.util.Scanner;

public class MainMenu {
    private User user;
    private TicketAdmin ticketAdmin;
    private UserAdmin userAdmin;
    private ApplicationAdmin applicationAdmin;
    private Login login;
    private Scanner scanner;

    public MainMenu(TicketAdmin ticketAdmin, UserAdmin userAdmin, ApplicationAdmin applicationAdmin) {
        this.ticketAdmin = ticketAdmin;
        this.userAdmin = userAdmin;
        this.applicationAdmin = applicationAdmin;
        login = new Login(userAdmin);
        scanner = new Scanner(System.in);
    }

    public void mainMenu() {
        int i = 1;
        while (i != 0) {
            System.out.println("1. Inloggen");
            System.out.println("2. Afsluiten");
            int check = scanner.nextInt();
            if (check == 1) {
                this.user = login.login();
                System.out.println("Hallo " + user.getFirstname());
                if (user.getFunctionRole().equals(FuctionRole.User)) {
                    UserMenu userMenu = new UserMenu(ticketAdmin, applicationAdmin, userAdmin, user);
                    userMenu.userMenu();
                } else if (user.getFunctionRole().equals(FuctionRole.ADMINISTRATOR)) {
                    AdminMenu adminMenu = new AdminMenu(ticketAdmin, userAdmin, applicationAdmin, user);
                    adminMenu.adminMenu();
                } else if (user.getFunctionRole().equals(FuctionRole.MANAGER)) {
                    ManagerMenu managerMenu = new ManagerMenu();
                    managerMenu.managerMenu();
                } else {
                    System.out.println("Het lijkt er op dat je nog een functierol hebt toegewezen gekregen. Neem telefonisch contact op met je IT-beheerder.");
                }

            }else if(check == 2){
                System.out.println("Afsluiten....");
                i = 0;
        }
        }
    }
}
