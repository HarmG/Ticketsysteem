package DataAdmin;

import Application.Application;

import java.util.List;

public interface ApplicationDataHandler {
    public List<Application> retrieveData();
    public void AddApplication(Application application);
}
