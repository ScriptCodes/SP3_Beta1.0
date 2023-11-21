package org.example;
import java.util.List;
import java.util.ArrayList;

public class User {
    FileIO io = new FileIO();
    TextUI ui = new TextUI();
    private String username;
    private String password;
    private boolean isAdmin = false;
    private ArrayList<User> newUsersList = new ArrayList<>();
    private ArrayList<String> myWatchList;

    public User(String username, String password, boolean isAdmin){

        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
       // myWatchList = new ArrayList<>();

    }
    public void createUser(String uInputUsername, String uInputPassword,boolean isAdmin){
        User newUser = new User(uInputUsername,uInputPassword,isAdmin);

        newUsersList.add(newUser);

        io.saveUserData(newUsersList);



//Create new file.txt for both Watch Later and My List
    }
    public void setUsername(String username){
        this.username = username;

    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setIsAdmin(boolean isAdmin){
        this.isAdmin = isAdmin;

        //region getters
    }
    public String getUsername(){

        return username;
    }
    public String getPassword(){

        return password;
    }
    public boolean getIsAdmin(){

        return isAdmin;
    }

    public boolean isAdmin() {
        return this.isAdmin;
    }

    //regionend
/*
    public void addToFavorites(String movieTitle){
        if(myWatchList == null){
            myWatchList = new ArrayList<>();
        }
        myWatchList.add(movieTitle);
        ui.displayMsg(movieTitle + " added to your watch list");
    }
public void displayMyWatchList(){
    if (myWatchList == null || myWatchList.isEmpty()) {
        System.out.println("No movies in your watch list");
    } else {
        System.out.println("Here are the movies in your watch list:");
        for (String movie : myWatchList) {
            System.out.println(movie);
        }
    }
}

*/
    @Override
    public String toString(){

        return username +","+password+","+ isAdmin;
    }
}