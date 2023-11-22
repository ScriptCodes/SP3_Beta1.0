
package org.example;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    private User loggedInUser;
    private static final String Filepath = "src/main/java/org/example/database.txt";
    private String usernameInput;
    private String passwordInput;
    FileIO io = new FileIO();
    TextUI ui = new TextUI();
    ArrayList<User> users = io.readUserData();

    public void login(ArrayList<User> users1) {

        Scanner scan = new Scanner(System.in);
        ui.displayMsg("Enter username");
        usernameInput = scan.nextLine();

        ui.displayMsg("Enter password");
        passwordInput = scan.nextLine();

        for (User user : users) {
            if (usernameInput.equalsIgnoreCase(user.getUsername()) && passwordInput.equals(user.getPassword())) {
                ui.displayMsg("You have succesfully logged in");

                if (user.getIsAdmin()) {
                    ui.displayMsg("You have admin features");
                    loggedInUser = user;
                    return;
                }
                loggedInUser = user;
                return;
            }
           /* } else if (!usernameInput.equalsIgnoreCase((user.getUsername()) && !passwordInput.equals(user.getPassword()))){



            }*/

        }
         ui.displayMsg("Invalid username or password" +"\n" + "Please try again");

        login(users1);
        scan.close();
    }

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
}
