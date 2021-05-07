package Main;

import DataAdmin.ApplicationAdmin;
import DataAdmin.TicketAdmin;
import DataAdmin.UserAdmin;
import DataStore.ApplicationData;
import DataStore.UserData;
import DataStore.TicketData;
import Menu.MainMenu;

public class Main {

    public static void main(String[] args) {

        TicketAdmin ticketAdmin = new TicketAdmin(new TicketData());
        UserAdmin userAdmin = new UserAdmin(new UserData());
        ApplicationAdmin applicationAdmin = new ApplicationAdmin(new ApplicationData());

        MainMenu mainMenu = new MainMenu(ticketAdmin, userAdmin, applicationAdmin);
        mainMenu.mainMenu();

    }
}
