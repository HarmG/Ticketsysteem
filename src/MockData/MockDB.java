package MockData;

import Application.Application;
import DataAdmin.ApplicationDataHandler;
import DataAdmin.TicketDataHandler;
import DataAdmin.UserdataHandler;
import Ticket.Ticket;
import User.User;

import java.util.ArrayList;
import java.util.List;

public class MockDB implements TicketDataHandler, UserdataHandler, ApplicationDataHandler {
    List<Ticket> tickets = new ArrayList<>();
    List<Application> applications = new ArrayList<>();
    List<User> users = new ArrayList<>();


    public void clearAll(){
        tickets.clear();
        users.clear();
        applications.clear();
    }
    @Override
    public List<Application> retrieveApplications() {
        return applications;
    }

    @Override
    public void AddApplication(Application application) {
        applications.add(application);
    }

    @Override
    public List<Ticket> retrieveTickets() {
        return tickets;
    }

    @Override
    public void AddTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    @Override
    public List<User> retrieveUsers() {
        return users;
    }

    @Override
    public void AddUser(User user) {
        users.add(user);
    }
}
