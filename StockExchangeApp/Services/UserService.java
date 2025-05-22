package StockExchangeApp.Services;

import StockExchangeApp.Models.User;
import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, User> users = new HashMap<>();

    public void registerUser(String username) {
        users.put(username, new User(username, 10000)); 
    }

    public User getUser(String username) {
        return users.get(username);
    }
}
