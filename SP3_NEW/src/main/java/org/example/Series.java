package org.example;

import java.util.ArrayList;

public class Series {

    private String title;
    private int year;
    private String[] genre;
    private double rating;
    private int seasons;
    private int endYear;


    public Series(String title, int year, int endYear, String[] genres, double rating, int seasons) {
        this.title = title;
        this.year = year;
        this.endYear = endYear;
        this.genre = genres;
        this.rating = rating;
        this.seasons = seasons;
    }


    public String[] getGenre(){

        return null;
    }


    @Override
    public String toString() {
        String genreString = arrayToString(genre);
        return "Series: " +
                "Title: '" + title + '\'' +
                ", Year: '" + year +
                ", Genre: " + genreString +
                ", Rating: " + rating +
                ", Seasons: " + seasons;
    }

    // Helper method to convert array to string
    private String arrayToString(String[] array) {
        String result = "[";
        for (int i = 0; i < array.length; i++) {
            result += "'" + array[i] + "'";
            if (i < array.length - 1) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }
}