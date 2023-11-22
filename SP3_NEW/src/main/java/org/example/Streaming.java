package org.example;

import java.util.ArrayList;

public class Streaming {
    ArrayList<User> users = new ArrayList<>();
    Menu menu = new Menu();
    TextUI ui = new TextUI();
    Login login = new Login();
    FileIO io = new FileIO();
    public void setup(){
      menu.loginMenu();
       // io.readSeriesData();
    //login.login(users);
    }



}
