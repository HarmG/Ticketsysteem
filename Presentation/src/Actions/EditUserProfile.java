package Actions;

import DataAdmin.ApplicationAdmin;
import DataAdmin.TicketAdmin;
import DataAdmin.UserAdmin;
import User.*;

import java.util.Scanner;


public class EditUserProfile {
    private UserAdmin userAdmin;
    private TicketAdmin ticketAdmin;
    private ApplicationAdmin applicationAdmin;
    private Select select;
    private Scanner scanner;
    private User admin;
    private int userIndex;
    private PrintUsers printUsers;

    public EditUserProfile(UserAdmin userAdmin,ApplicationAdmin applicationAdmin, TicketAdmin ticketAdmin, User admin) {
        this.userAdmin = userAdmin;
        this.applicationAdmin = applicationAdmin;
        this.ticketAdmin = ticketAdmin;
        this.admin = admin;
        select = new Select(userAdmin, applicationAdmin, ticketAdmin);
        scanner = new Scanner(System.in);
        printUsers = new PrintUsers(userAdmin);
    }

    public void EditUserProfile() {
        //todo: lijst maken van active en niet active users
       userIndex = userAdmin.getAllUsers().indexOf(select.selectUser(userAdmin.getAllUsers(),true));
        for (int i = 1; i > 0; ) {
            printUsers.printUserFull(userAdmin.getAllUsers().get(userIndex));
            System.out.println("Wat wil je aanpassen?");
            System.out.println("1. Functierol");
            System.out.println("2. Achternaam");
            System.out.println("3. Telefoonnummer");
            System.out.println("4. E-mail adres");
            System.out.println("5. Zet profiel aan/uit");
            System.out.println("0. Annuleren");
            i = scanner.nextInt();
            scanner.nextLine();
            switch (i){
                case 0:
                    System.out.println("U word terug geleid naar het hoofdmenu.");
                    break;
                case 1:
                    System.out.println("Fuctierol aanpassen");
                    System.out.println("Huidige fuctierol: "+userAdmin.getAllUsers().get(userIndex).getFunctionRole());
                    System.out.println("Wat moet de fuctierol worden?");
                    System.out.println("1. Gebruiker");
                    System.out.println("2. Manager");
                    System.out.println("3. Admin");
                    int functierol = scanner.nextInt();
                    scanner.nextLine();
                    while (functierol != 0) {
                        if (functierol == 1) {
                            userAdmin.getAllUsers().get(userIndex).setFunctionRole(FuctionRole.User, admin);
                            functierol = 0;
                        } else if (functierol == 2) {
                            userAdmin.getAllUsers().get(userIndex).setFunctionRole(FuctionRole.MANAGER, admin);
                            functierol = 0;
                        } else if (functierol == 3) {
                            userAdmin.getAllUsers().get(userIndex).setFunctionRole(FuctionRole.ADMINISTRATOR, admin);
                            functierol = 0;
                        } else {
                            System.out.println("Maar een van de aangegeven keuzes.");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Achternaam aanpassen.");
                    System.out.println("Huidige achternaam: "+userAdmin.getAllUsers().get(userIndex).getSurname());
                    System.out.println("Nieuwe achternaam: ");
                    String achternaam = scanner.nextLine();
                    userAdmin.getAllUsers().get(userIndex).setSurname(achternaam);
                    System.out.println("Achtenaam is aangepast naar: "+userAdmin.getAllUsers().get(userIndex).getSurname());
                    break;
                case 3:
                    System.out.println("Telefoonnummer aanpassen.");
                    System.out.println("Huidige telefoonnummer: "+userAdmin.getAllUsers().get(userIndex).getPhoneNumber());
                    System.out.println("Nieuwe telefoonnummer: ");
                    String telefoonnummer = scanner.nextLine();
                    userAdmin.getAllUsers().get(userIndex).setPhoneNumber(telefoonnummer);
                    System.out.println("Achtenaam is aangepast naar: "+userAdmin.getAllUsers().get(userIndex).getPhoneNumber());
                    break;
                case 4:
                    System.out.println("E-mail adres aanpassen.");
                    System.out.println("Huidige e-mail adres: "+userAdmin.getAllUsers().get(userIndex).getEmailAddress());
                    System.out.println("Nieuwe e-mail adres: ");
                    String mail = scanner.nextLine();
                    userAdmin.getAllUsers().get(userIndex).setEmailAddress(mail);
                    System.out.println("E-mail adres is aangepast naar: "+userAdmin.getAllUsers().get(userIndex).getEmailAddress());
                    break;
                case 5:
                    boolean active = false;
                    if(userAdmin.getAllUsers().get(userIndex).isActive()==true) {
                        System.out.println("Wilt u het profiel op niet actief zetten?");
                        active = false;
                    }else if(userAdmin.getAllUsers().get(userIndex).isActive()==false){
                        System.out.println("Wilt u het profiel op actief zetten?");
                        active = true;
                    }
                        boolean a = true;
                        while (a == true) {
                            System.out.println("1. Ja");
                            System.out.println("2. nee");
                            int scan = scanner.nextInt();
                            if (scan == 1) {
                                userAdmin.getAllUsers().get(userIndex).setActive(active, admin);
                                a = false;
                            } else if (scan == 2) {
                                a = false;
                            } else {
                                System.out.println("Kies een van de aangegeven opties.");
                            }
                        }
                    break;
                default:
                    System.out.println("De optie die u heeft gekozen is niet geldig.");
                    break;
            }
        }
    }
}
