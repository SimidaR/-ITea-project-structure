package ro.iteahome.controller;

import ro.iteahome.exception.InvalidCredentialsException;
import ro.iteahome.service.UserService;
import java.security.InvalidParameterException;

public class UserController {
    private UserService userService =new UserService();
    public  void login(String username, String password) throws InvalidCredentialsException {
        if (username.length() < 6 || password.length() < 6) {
            throw new InvalidParameterException("Invalid credentials");
        }
        userService.login(username, password);
    }

}
