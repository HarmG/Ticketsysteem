package User;

import DataAdmin.UserdataHandler;

import java.util.ArrayList;
import java.util.List;

public class UserAdmin {
    private ArrayList<User> users = new ArrayList<>();
    private UserdataHandler userdataHandler;

    public UserAdmin(UserdataHandler userdataHandler) {
        this.userdataHandler = userdataHandler;
    }

    public List<User> getAllUsers(){
        return userdataHandler.retrieveData();
    }

    public void addUser(User user){
        userdataHandler.AddUser(user);
    }
}
