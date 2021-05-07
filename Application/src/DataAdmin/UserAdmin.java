package DataAdmin;

import User.*;

import java.util.ArrayList;
import java.util.List;

public class UserAdmin {
    private ArrayList<User> users = new ArrayList<>();
    private UserdataHandler userdataHandler;

    public UserAdmin(UserdataHandler userdataHandler) {
        this.userdataHandler = userdataHandler;
    }

    public List<User> getAllUsers(){
        return userdataHandler.retrieveUsers();
    }

    public List<User> getAllActiveBasedUsers(boolean bool){
        users.clear();
        for (int i = 0; i < userdataHandler.retrieveUsers().size(); i++){
            if(userdataHandler.retrieveUsers().get(i).isActive() == bool){
                users.add(userdataHandler.retrieveUsers().get(i));
            }
        }
        return users;
    }

    public List<User> getUsersBasedOnRole(FuctionRole fuctionRole){
        users.clear();
        for (int i = 0; i < userdataHandler.retrieveUsers().size(); i++){
            if(userdataHandler.retrieveUsers().get(i).getFunctionRole() != fuctionRole){

            }else{
                users.add(userdataHandler.retrieveUsers().get(i));
            }
        }
        return users;
    }

    public void addUser(User user){
        userdataHandler.AddUser(user);
    }
}
