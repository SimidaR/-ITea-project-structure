package ro.iteahome.service;

import ro.iteahome.dao.UserDAO;
import ro.iteahome.entity.User;
import ro.iteahome.exception.InvalidCredentialsException;

public class UserService {
    private UserDAO userDAO = new UserDAO();
    public void login(String username, String password) throws InvalidCredentialsException {
        for (User user : userDAO.getUserList()){
            if(username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                return;
            }
        }
        throw new InvalidCredentialsException();
    }
}
