package Actions;

import DataAdmin.UserAdmin;
import User.*;


import java.time.LocalDate;
import java.util.Scanner;

public class CreateUserprofile {
    private UserAdmin userAdmin;
    private Scanner scanner;

    public CreateUserprofile(UserAdmin userAdmin) {
        this.userAdmin = userAdmin;
        this.scanner = new Scanner(System.in);
    }

    public void createNewUser() {
        System.out.println("Voer hier de gegevens van de nieuwe gebruiker in.");
        System.out.println("Voornaam: ");
        String voornaam = scanner.nextLine();
        System.out.println("Achternaam: ");
        String achternaam = scanner.nextLine();
        System.out.println("Functierol: ");
        System.out.println("1. Gebruiker");
        System.out.println("2. Manager");
        System.out.println("3. Admin");
        int functierol = scanner.nextInt();
        scanner.nextLine();
        FuctionRole fuctionRole = FuctionRole.User;
        while (functierol != 0) {
            if (functierol == 1) {
                functierol = 0;
            } else if (functierol == 2) {
                fuctionRole = FuctionRole.MANAGER;
                functierol = 0;
            } else if (functierol == 3) {
                fuctionRole = FuctionRole.ADMINISTRATOR;
                functierol = 0;
            } else {
                System.out.println("Maar een van de aangegeven keuzes.");
            }
        }
        System.out.println("Geboortedarum: ");
        System.out.println("Dag: ");
        int dag = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Maand: ");
        int maand = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Jaar: ");
        int jaar = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Telefoonnummer: ");
        String telefoonnummer = scanner.nextLine();
        System.out.println("E-mail: ");
        String email = scanner.nextLine();
        System.out.println("Tijdelijk wachtwoord: ");
        String wachtwoord = scanner.nextLine();

        userAdmin.addUser(new User(fuctionRole, voornaam, achternaam, LocalDate.of(jaar, maand, dag), telefoonnummer, email, wachtwoord));
    }
}
