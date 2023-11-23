
package org.example;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Mads, Kevin, Daniel
 * The following class contains a login method that reads the username and password stored in a data file
 *
 */
public class Login {
    private User loggedInUser;
    private static final String Filepath = "src/main/java/org/example/database.txt";
    private String usernameInput;
    private String passwordInput;
    FileIO io = new FileIO();
    TextUI ui = new TextUI();
    ArrayList<User> users = io.readUserData();
    /**
     *The following method logs in the user
     * @param users1 the parameter could be any user
     */
    public void login(ArrayList<User> users1) {
        Scanner scan = new Scanner(System.in);
        ui.displayMsg("Enter username");
        usernameInput = scan.nextLine();
        ui.displayMsg("Enter password");
        passwordInput = scan.nextLine();

        for (User user : users) {
            if (usernameInput.equalsIgnoreCase(user.getUsername()) && passwordInput.equals(user.getPassword())) {
                // ...
                loggedInUser = user;  // Ensure loggedInUser is set here
                user.setLoggedIn(true);
                return;
            }
        }

        for (User user : users) {
            if (usernameInput.equalsIgnoreCase(user.getUsername()) && passwordInput.equals(user.getPassword())) {
                ui.displayMsg("You have successfully logged in");
                if (user.getIsAdmin()) {
                    ui.displayMsg("You have admin features");
                    loggedInUser = user;
                    user.setLoggedIn(true); // Set the loggedIn status in User class
                    return;
                }
                loggedInUser = user;
                user.setLoggedIn(true); // Set the loggedIn status in User class
                return;
            }
        }

        ui.displayMsg("Invalid username or password" + "\n" + "Please try again");
        login(users1);
        scan.close();
    }
    /**
     * The following methods are getters which gets the current user logged in
     * makes the program able to distinguish between admin users and non admin users
     * @return it returns the inputs written from the login method I.E. username and password
     */
    //Region getters
    public User getLoggedInUser() {
        return loggedInUser;
    }

    public String getUsernameInput(){
        this.usernameInput = usernameInput;
        return usernameInput;
    }
    public String getPasswordInput(){
        this.passwordInput = passwordInput;
        return passwordInput;
    }



    //Region end
}
