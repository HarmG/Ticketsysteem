package DataAdmin;

import Application.Application;

import java.util.List;

public interface ApplicationDataHandler {
    public List<Application> retrieveApplications();
    public void AddApplication(Application application);
}
