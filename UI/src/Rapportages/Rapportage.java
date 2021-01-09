package Rapportages;

import Ticket.*;
import User.User;

import java.util.List;

public class Rapportage {
    private final User user;

    public Rapportage(User user) {
        this.user = user;
    }

    public void getOpenTickets(List<Ticket> tickets){
        for(int i = 0; i < tickets.size(); i++){
            if(tickets.get(i).getState().equals(State.NEW) || tickets.get(i).getState().equals(State.ASSIGNED) ){
                System.out.println(tickets.get(i).getCaller().getFirstname());
            }
        }
    }
}
