package DataAdmin;

import User.User;

import java.util.List;

public interface UserdataHandler {
    public List<User> retrieveUsers();
    public void AddUser(User user);
}
