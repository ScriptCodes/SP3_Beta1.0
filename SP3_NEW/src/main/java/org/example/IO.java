package org.example;

import java.util.ArrayList;

public interface IO {


    ArrayList<User> readUserData();
    void saveUserData(ArrayList<User> newUsersList);
    ArrayList<Movie> readMovieData();
    ArrayList<Series> readSeriesData();
    int parseIntSafe(String s);
}
