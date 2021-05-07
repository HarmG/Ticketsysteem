package DataStore;

import DataAdmin.UserdataHandler;
import User.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class UserData implements UserdataHandler {

    ArrayList<User> userList = new ArrayList<>();

    public UserData() {
        userList.add(new User(FuctionRole.ADMINISTRATOR, "IT-medewerker 1", "achternaam1", LocalDate.of(1990, 01, 01), "0612345678", "ITmedewerker1@mail.com", "ENTER"));
        userList.add(new User(FuctionRole.ADMINISTRATOR, "IT-medewerker 2", "achternaam2", LocalDate.of(1990, 01, 01), "0612345678", "ITmedewerker2@mail.com", "ENTER"));
        userList.add(new User(FuctionRole.MANAGER, "Directielid 1", "achternaam3", LocalDate.of(1990, 01, 01), "0612345678", "Directielid1@mail.com", "ENTER"));
        userList.add(new User(FuctionRole.MANAGER, "Directielid 2", "achternaam4", LocalDate.of(1990, 01, 01), "0612345678", "Directielid2@mail.com", "ENTER"));
        userList.add(new User(FuctionRole.User, "Gebruiker 1", "achternaam5", LocalDate.of(1990, 01, 01), "0612345678", "Gebruiker1@mail.com", "ENTER"));
        userList.add(new User(FuctionRole.User, "Gebruiker 2", "achternaam6", LocalDate.of(1990, 01, 01), "0612345678", "Gebruiker2@mail.com", "ENTER"));
//        userList.add(new User(FuctionRole.User, "Gebruiker 3", "achternaam7", LocalDate.of(1990, 01, 01), "0612345678", "Gebruiker3@mail.com", "ENTER"));
//        userList.add(new User(FuctionRole.User, "Gebruiker 4", "achternaam8", LocalDate.of(1990, 01, 01), "0612345678", "Gebruiker4@mail.com", "ENTER"));
//        userList.add(new User(FuctionRole.User, "Gebruiker 5", "achternaam9", LocalDate.of(1990, 01, 01), "0612345678", "Gebruiker5@mail.com", "ENTER"));
//        userList.add(new User(FuctionRole.User, "Gebruiker 6", "achternaam10", LocalDate.of(1990, 01, 01), "0612345678", "Gebruiker6@mail.com", "ENTER"));
//        userList.add(new User(FuctionRole.User, "Gebruiker 7", "achternaam11", LocalDate.of(1990, 01, 01), "0612345678", "Gebruiker7@mail.com", "ENTER"));
//        userList.add(new User(FuctionRole.User, "Gebruiker 8", "achternaam12", LocalDate.of(1990, 01, 01), "0612345678", "Gebruiker8@mail.com", "ENTER"));
//        userList.add(new User(FuctionRole.User, "Gebruiker 9", "achternaam13", LocalDate.of(1990, 01, 01), "0612345678", "Gebruiker9@mail.com", "ENTER"));
//        userList.add(new User(FuctionRole.User, "Gebruiker 10", "achternaam14", LocalDate.of(1990, 01, 01), "0612345678", "Gebruiker10@mail.com", "ENTER"));
//        userList.add(new User(FuctionRole.User, "Gebruiker 11", "achternaam15", LocalDate.of(1990, 01, 01), "0612345678", "Gebruiker11@mail.com", "ENTER"));
//        userList.add(new User(FuctionRole.User, "Gebruiker 12", "achternaam16", LocalDate.of(1990, 01, 01), "0612345678", "Gebruiker12@mail.com", "ENTER"));
    }

    @Override
    public ArrayList<User> retrieveUsers() {

        return userList;
    }

    @Override
    public void AddUser(User user) {
        userList.add(user);
    }

}
