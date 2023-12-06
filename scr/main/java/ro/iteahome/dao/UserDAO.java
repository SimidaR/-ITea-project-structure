package ro.iteahome.dao;

import ro.iteahome.entity.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private List<User> userList = new ArrayList<>();

    public UserDAO() {
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream("user.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            String userStr;
            while ((userStr = reader.readLine()) != null) {
                String[] userDetails = userStr.split(";");
                User user = new User(userDetails[0], userDetails[1]);
                userList.add(user);
            }
            reader.close();
        } catch (IOException e) {
            throw new IllegalStateException("Database error", e);
        }
    }
    public List<User> getUserList() {
        return userList;
    }
}
