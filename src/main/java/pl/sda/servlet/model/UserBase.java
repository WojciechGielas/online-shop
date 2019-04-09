package pl.sda.servlet.model;

import java.util.LinkedList;
import java.util.List;

public class UserBase {
    private static UserBase instance;

    private List<User> users;

    void addUser (User user){
        users.add(user);
    }
    List<User> getUsers(){
        return users;
    }
    User getUser(int index){
        return users.get(index);
    }


    private UserBase(){
        users = new LinkedList<>();
    }

    public static UserBase getInstance() {
        if (instance == null) {
            instance = new UserBase();
        }
        return instance;
    }


}
