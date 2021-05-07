package User;

import java.time.LocalDate;

public class User {
    private int id; //word door de database gegenereerd
    private FuctionRole fuctionRole;
    private final String firstname;
    private String surname;
    private final LocalDate dateOfBirth;
    private String phoneNumber;
    private String emailAddress;
    private String password;
    private boolean active;


    public User(FuctionRole fuctionRole, String firstname, String surname, LocalDate dateOfBirth, String phoneNumber, String emailAddress, String password) {
            this.fuctionRole = fuctionRole;
            this.firstname = firstname;
            this.surname = surname;
            this.dateOfBirth = dateOfBirth;
            this.phoneNumber = phoneNumber;
            this.emailAddress = emailAddress;
            this.password = password;
            this.active = true; //Bij het aanmaken van een gebruiker word deze standaard op true gezet en kan altijd door de beheerder op false gezet worden. Dit is om er makkelijk voor te zogen dat een gebruiker niet meer kan inloggen
        }

    public final boolean setFunctionRole(FuctionRole fuctionRole, User user) {
        //Kan allen worden aangepast door een IT-Medewerker
        if (user.getFunctionRole() != FuctionRole.ADMINISTRATOR) {
            return false;
        } else {
            this.fuctionRole = fuctionRole;
            return true;
        }
    }


    public final boolean setActive(boolean active, User user) {
        //Kan allen worden aangepast door een IT-Medewerker
        if (user.getFunctionRole() != FuctionRole.ADMINISTRATOR) {
            return false;
        } else {
            this.active = active;
            return true;
        }
    }

    // Methode om je wachtwoord te kunnen wijzigen
    public final boolean setPassword(String oldPassword, String newPassword1, String newPassword2) {
        //controle orginele wachtwoord
        if (oldPassword != password) {
            return false;
            //invoer van het nieuwe wachtwoord moet 2keer worden gedaan, als dit niet het zelfde is word het wachtwoord niet aangepast
        } else if (newPassword1 != newPassword2) {
            return false;
        } else {
            this.password = newPassword1;
            return true;
        }
    }

    //controle wachtwoord om in te loggen. Dit heb ik gedaan zodat er geen wachtwoord return hoeft gedaan te worden.
    public final boolean verifyPassword(String input) {
        if (input.equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public final void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public final void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public final FuctionRole getFunctionRole() {
        return fuctionRole;
    }

    public final String getFirstname() {
        return firstname;
    }

    public final String getSurname() {
        return surname;
    }

    public final LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public final String getPhoneNumber() {
        return phoneNumber;
    }

    public final String getEmailAddress() {
        return emailAddress;
    }

    public final int getId() {
        return id;
    }

    public boolean isActive() {
        return active;
    }
}
