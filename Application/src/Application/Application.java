package Application;

import Note.Note;
import User.User;
import User.FuctionRole;

import java.util.ArrayList;

public class Application {
    private int id; //Word gegenereed door de database
    private String name;
    private User admin;
    private boolean criticalApp;
    private Note intakeQuestion;
    private ArrayList<Note> intakeIntakeQuestions = new ArrayList<>();

    public Application(String name, User admin, boolean criticalApp, User user) {
        //Een applicatie mag alleen door een IT medewerker worden aangemaakt.
        if (user.getFunctionRole() != FuctionRole.ADMINISTRATOR) {
        } else {
            this.name = name;
            this.admin = admin;
            this.criticalApp = criticalApp;
        }
    }


    public final boolean setBeheerder(User beheerder, User user) {
        //Mag alleen door een IT-Medewerker worden aangepast.
        if (user.getFunctionRole() != FuctionRole.ADMINISTRATOR) {
            return false;
        } else {
            this.admin = beheerder;
            return true;
        }
    }

    public final boolean setNaam(String naam, User user) {
        //Mag alleen door een IT-Medewerker worden aangepast.
        if (user.getFunctionRole() != FuctionRole.ADMINISTRATOR) {
            return false;
        } else {
            this.name = naam;
            return true;
        }
    }

    public final boolean setKritischeApp(boolean kritischeApp, User user) {
        //Mag alleen door een IT-Medewerker worden aangepast.
        if (user.getFunctionRole() != FuctionRole.ADMINISTRATOR) {
            return false;
        } else {
            this.criticalApp = kritischeApp;
            return true;
        }
    }

    public final boolean setIntakeVragen(String intakevraag, User user) {
        intakeQuestion = new Note(intakevraag, user);
        //Mag alleen door een IT-Medewerker worden aangepast.
        if (user.getFunctionRole() != FuctionRole.ADMINISTRATOR) {
            return false;
        } else {
            intakeIntakeQuestions.add(intakeQuestion);
            return true;
        }
    }

    public final int getId() {
        return id;
    }

    public final User getAdmin() {
        return admin;
    }

    public final String getName() {
        return name;
    }

    public final boolean getCriticalApp() {
        return criticalApp;
    }

    public final ArrayList<Note> getIntakeQuestions() {
        return intakeIntakeQuestions;
    }
}
