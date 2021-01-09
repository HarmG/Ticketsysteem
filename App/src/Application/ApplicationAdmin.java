package Application;

import DataAdmin.ApplicationDataHandler;

import java.util.ArrayList;
import java.util.List;

public class ApplicationAdmin {
    private ArrayList<Application> applications = new ArrayList<>();
    private ApplicationDataHandler applicationDataHandler;

    public ApplicationAdmin(ApplicationDataHandler applicationDataHandler) {
        this.applicationDataHandler = applicationDataHandler;
    }
    public List<Application> getAllApplications(){
        return applicationDataHandler.retrieveData();
    }
    public void addApplication(Application application){
        applicationDataHandler.AddApplication(application);
    }
}
