package org.example;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class Menu {
ArrayList<User>users = new ArrayList<>();
ArrayList<User>newUsersList = new ArrayList<>();
ArrayList<Movie> movies = new ArrayList<>();
TextUI ui = new TextUI();
Login login = new Login();
FileIO io = new FileIO();
String uInputUsername;
String uInputPassword;
boolean isAdmin = false;
User newUsers = new User(uInputUsername,uInputPassword,isAdmin);
User user = new User(uInputUsername,uInputPassword,isAdmin);

//Loginin menu. User will first be met with the options to create or login
public void loginMenu(){
    ui.displayMsg("Welcome!");
    ui.displayMsg("1.Login"+"\n"+"2.Create new user");
    String loginOptions = ui.getInput("");
    switch (loginOptions){
        case "1":
            ui.displayMsg("Please type your Username and password:");
            //login.login(users);//Go to Login
             login.login(users);


            break;
        case "2":
            ui.displayMsg("Please write your desired username!\n");
            uInputUsername = ui.getInput("");
            ui.displayMsg("\nPlease write your desired password!\n");
            uInputPassword = ui.getInput("");
            newUsers.createUser(uInputUsername, uInputPassword, isAdmin);
            ui.displayMsg("\nYour account was sucessfuly created!");
            //Go to create user method in User
            displayUserOptions();
            break;
        default:
            ui.displayMsg("None of the options was chosen");
    }

}

public void displayUserOptions() {
    ui.displayMsg("What do you want to do?: ");
    ui.displayMsg("1.Watch movie" + "\n" + "2.Watch series" + "\n" + "3.Go to My List" + "\n" + "4.Go to Watch Later" + "\n" + "5.Display movies/series by genre" + "\n");


    String options = ui.getInput("");

    switch (options) {
        case "1":
            displayMovies();
            break;
        case "2":
            displaySeries();
            break;
        case "3":
            displayMyList();
            break;
        case "4":
            displayWatchLater();
            break;
        case "5":
            displayByGenre();
            break;
        default:
            ui.displayMsg("None of the options was selected");

    }
}
    public void displayAdminOptions() {

       /* File file = new File("src/main/java/org/example/100bedstefilm.txt");
        String aInput = ui.getInput("");*/
        ui.displayMsg("What do you want to do?: ");
        ui.displayMsg("1.Watch movie" + "\n" + "2.Watch series" + "\n" + "3.Go to My List" + "\n" + "4.Go to Watch Later" + "\n" + "5.Display movies/series by genre" + "\n"+"6.Admin panel"+"\n");


        String options = ui.getInput("");

        switch (options) {
            case "1":
                displayMovies();
                break;
            case "2":
                displaySeries();
                break;
            case "3":
                displayMyList();
                break;
            case "4":
                displayWatchLater();
                break;
            case "5":
                displayByGenre();
                break;
            case "6":
                adminPanel();
                break;
            default:
                ui.displayMsg("None of the options was selected");

        }

    }





public void displayMyList(){


}


public void displayWatchLater(){

}


public void displaySeries(){


}

public void displayMovies(){


}


public void displayByGenre(){


}

public void adminPanel(){

   // ui.displayMsg("1.Remove Media "+ "\n"+"2.Add Media");
    //String uAdmin = ui.getInput("");
    //switch ()

}


}
