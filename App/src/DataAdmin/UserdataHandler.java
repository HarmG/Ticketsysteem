package DataAdmin;

import User.User;

import java.util.List;

public interface UserdataHandler {
    public List<User> retrieveData();
    public void AddUser(User user);
}
