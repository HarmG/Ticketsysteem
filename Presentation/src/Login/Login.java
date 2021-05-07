package Login;

import User.User;
import DataAdmin.UserAdmin;

import java.util.Scanner;

public class Login {
    private Scanner scanner = new Scanner(System.in);
    private UserAdmin userAdmin;
    private User user;


    public Login(UserAdmin userAdmin) {
        this.userAdmin = userAdmin;
    }

    public User login(){
        boolean LOGGING = false;
        while (LOGGING == false) {
            System.out.println("Login");
            System.out.println("Voer je email in. (ITmedewerker2@mail.com Directielid1@mail.com Gebruiker2@mail.com)");
            String Email = scanner.nextLine();
            System.out.println("Voer je wachtwoord in. (ENTER)");
            String wachtwoord = scanner.nextLine();

            for (int i = 0; i < userAdmin.getAllActiveBasedUsers(true).size(); i++) {
                if (userAdmin.getAllActiveBasedUsers(true).get(i).verifyPassword(wachtwoord) == true && userAdmin.getAllActiveBasedUsers(true).get(i).getEmailAddress().equals(Email)) {
                    LOGGING = true;
                    user = userAdmin.getAllActiveBasedUsers(true).get(i);
                    break;
                }else{

                }
            }
            System.out.println("Gebruikersnaam en wachtwoord komen niet overeen. Probeer het opnieuw");
        }
        return user;
    }
}
