package Login;

import User.User;
import User.UserAdmin;

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
            System.out.println("Voer je email in. (ITmedewerker2@mail.com Directielid1@mail.com Gebruiker6@mail.com)");
            String Email = "ITmedewerker2@mail.com"; //Todo: Scanner van maken
            System.out.println("Voer je wachtwoord in. (ENTER)");
            String wachtwoord = "ENTER"; //Todo: Scanner van maken

            for (int i = 0; i < userAdmin.getAllUsers().size(); i++) {
                if (userAdmin.getAllUsers().get(i).verifyPassword(wachtwoord) == true && userAdmin.getAllUsers().get(i).getEmailAddress().equals(Email)) {
                    LOGGING = true;
                    user = userAdmin.getAllUsers().get(i);
                    break;
                }
            }
        }
        return user;
    }
}
