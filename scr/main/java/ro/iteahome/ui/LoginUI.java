package ro.iteahome.ui;

import ro.iteahome.controller.UserController;
import ro.iteahome.exception.InvalidCredentialsException;

import java.security.InvalidParameterException;
import java.util.Scanner;

public class LoginUI {
    private UserController userController = new UserController();
    public void login() {
        boolean loginSucceded = false;
        int count = 0;
        while (!loginSucceded && count < 3) {
            try {
                System.out.println("Please enter your credentials");
                System.out.println("Username: ");
                Scanner keyboadInput = new Scanner(System.in);
                String username = keyboadInput.next();
                System.out.println("Password: ");
                String password = keyboadInput.next();
                userController.login(username, password);
                loginSucceded = true;
                System.out.println("Login successfully");
            } catch (InvalidCredentialsException e) {
                System.out.println("The credentials are not valid");
                loginSucceded = false;
                count++;
            } catch (InvalidParameterException e) {
                System.out.println("The credentials are not in a valid format");
                loginSucceded = false;
                count++;
            }
        }
    }
}
