package Menu;

import Application.ApplicationAdmin;
import Login.Login;
import Ticket.TicketAdmin;
import User.*;

public class MainMenu {
    private User user;
    private TicketAdmin ticketAdmin;
    private UserAdmin userAdmin;
    private ApplicationAdmin applicationAdmin;
    private Login login;

    public MainMenu(TicketAdmin ticketAdmin, UserAdmin userAdmin, ApplicationAdmin applicationAdmin) {
        this.ticketAdmin = ticketAdmin;
        this.userAdmin = userAdmin;
        this.applicationAdmin = applicationAdmin;
        login = new Login(userAdmin);
        this.user = login.login();
    }

    public void Keuzedmenu() {
        System.out.println("Hallo " + user.getFirstname());
        if (user.getFunctionRole().equals(FuctionRole.User)) {
            UserMenu userMenu = new UserMenu(ticketAdmin, applicationAdmin, user);
            userMenu.userMenu();
        } else if (user.getFunctionRole().equals(FuctionRole.ADMINISTRATOR)) {
            AdminMenu adminMenu = new AdminMenu(ticketAdmin, userAdmin, applicationAdmin);
            adminMenu.adminMenu();
        }else if (user.getFunctionRole().equals(FuctionRole.MANAGER)){
            ManagerMenu managerMenu = new ManagerMenu();
            managerMenu.managerMenu();
        }else {
            System.out.println("Het lijkt er op dat je nog een functierol hebt toegewezen gekregen. Neem telefonisch contact op met je IT-beheerder.");
        }

    }
}
