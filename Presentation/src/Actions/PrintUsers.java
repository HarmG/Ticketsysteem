package Actions;

import DataAdmin.UserAdmin;
import User.*;

import java.util.List;

public class PrintUsers {
    private UserAdmin userAdmin;

    public PrintUsers(UserAdmin userAdmin) {
        this.userAdmin = userAdmin;
    }

    public void printUserOvervieuw(List<User> users){
        for (int i = 0; i < users.size(); i++) {
                printUserShort(users.get(i));
        }
    }
    public void printUserShort(User user){
        System.out.println(userAdmin.getAllUsers().indexOf(user)+" "+ user.getFirstname()+" "+user.getSurname());
    }
    public void printUserFull(User user){
        System.out.println("Voornaam: "+user.getFirstname());
        System.out.println("Achternaam: "+user.getSurname());
        System.out.println("Geboortedatum: "+user.getDateOfBirth());
        System.out.println("Functierol: "+user.getFunctionRole());
        System.out.println("Contact gegevens:");
        System.out.println("E-mail: "+user.getEmailAddress());
        System.out.println("Telefoonnummer: "+user.getPhoneNumber());
    }
}
