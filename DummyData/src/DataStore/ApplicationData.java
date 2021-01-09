package DataStore;

import Application.Application;
import DataAdmin.ApplicationDataHandler;

import java.util.ArrayList;
import java.util.List;

public class ApplicationData implements ApplicationDataHandler {

    ArrayList<Application> applications = new ArrayList<>();
    private UserData gebruiker = new UserData();

    public ApplicationData() {
        applications.add(new Application("Office",gebruiker.retrieveData().get(0), false, gebruiker.retrieveData().get(0)));
        applications.add(new Application("IntelliJ IDEA",gebruiker.retrieveData().get(0), true, gebruiker.retrieveData().get(0)));
        applications.add(new Application("Netflix",gebruiker.retrieveData().get(0), false, gebruiker.retrieveData().get(0)));
        applications.add(new Application("Rekenmachine",gebruiker.retrieveData().get(0), false, gebruiker.retrieveData().get(0)));
        applications.add(new Application("Bookshelf",gebruiker.retrieveData().get(1), false, gebruiker.retrieveData().get(1)));
        applications.add(new Application("Spotify",gebruiker.retrieveData().get(1), false, gebruiker.retrieveData().get(1)));
        applications.add(new Application("Keepass",gebruiker.retrieveData().get(1), true, gebruiker.retrieveData().get(1)));
    }

    @Override
    public ArrayList<Application> retrieveData() {
        return applications;
    }


    @Override
    public void AddApplication(Application application) {

    }
}
