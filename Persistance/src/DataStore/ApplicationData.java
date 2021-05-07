package DataStore;

import Application.Application;
import DataAdmin.ApplicationDataHandler;

import java.util.ArrayList;

public class ApplicationData implements ApplicationDataHandler {

    ArrayList<Application> applications = new ArrayList<>();
    private UserData gebruiker = new UserData();

    public ApplicationData() {
        applications.add(new Application("Office",gebruiker.retrieveUsers().get(0), false, gebruiker.retrieveUsers().get(0)));
        applications.add(new Application("IntelliJ IDEA",gebruiker.retrieveUsers().get(0), true, gebruiker.retrieveUsers().get(0)));
        applications.add(new Application("Netflix",gebruiker.retrieveUsers().get(0), false, gebruiker.retrieveUsers().get(0)));
        applications.add(new Application("Rekenmachine",gebruiker.retrieveUsers().get(0), false, gebruiker.retrieveUsers().get(0)));
        applications.add(new Application("Bookshelf",gebruiker.retrieveUsers().get(1), false, gebruiker.retrieveUsers().get(1)));
        applications.add(new Application("Spotify",gebruiker.retrieveUsers().get(1), false, gebruiker.retrieveUsers().get(1)));
        applications.add(new Application("Keepass",gebruiker.retrieveUsers().get(1), true, gebruiker.retrieveUsers().get(1)));
        applications.get(1).setIntakeVragen("Hoe start je de applicatie precies op?", gebruiker.retrieveUsers().get(0));
    }

    @Override
    public ArrayList<Application> retrieveApplications() {
        return applications;
    }


    @Override
    public void AddApplication(Application application) {

    }
}
