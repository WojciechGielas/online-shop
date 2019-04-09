package pl.sda.servlet.shopOnline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UserDb {
    private static UserDb db;

    private List<User> users;

    public UserDb() {
        this.users = new ArrayList<>();
        users.add(new User("123@gmail.com", "pass", "admin", Arrays.asList("admin")));
        users.add(new User("456@gmail.com", "pass", "user", Arrays.asList("user")));

    }

    public static UserDb getInstance() {
        if (db == null) {
            db = new UserDb();
        }
        return db;
    }

    public Optional<User> checkLogin(final String userName, final String password) {
        return users.stream().filter(user -> user.getUserName().equalsIgnoreCase(userName) && user.getPassword().equalsIgnoreCase(password))
                .findFirst();
    }

    public Optional<User> checkUser(final String userName, final String email) {
        return users.stream().filter(user -> user.getUserName().equalsIgnoreCase(userName) || user.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    public User addNewUser(final String userName, final String email, final String password, final List<String> roles) {
        User user = new User(email, password, userName, roles);
        users.add(user);
        return user;

    }

}

