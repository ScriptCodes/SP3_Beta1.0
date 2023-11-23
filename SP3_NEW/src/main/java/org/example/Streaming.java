package org.example;

import java.util.ArrayList;
/**
 * @author Mads, Kevin, Daniel
 * Streaming class
 * This class has a setup method which contains our "main" funtions
 * simply just here to call it in the main class to have the main class as clean as possible
 */
public class Streaming {
    ArrayList<User> users = new ArrayList<>();
    Menu menu = new Menu();
    TextUI ui = new TextUI();
    Login login = new Login();
    FileIO io = new FileIO();
    /**
     * Following method is a setup method
     * runs the main method of our program
     */
    public void setup(){
      menu.loginMenu();
       // io.readSeriesData();
    //login.login(users);
        //menu.searchByGenreSeries();

    }



}
