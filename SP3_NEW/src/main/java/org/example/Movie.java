package org.example;

public class Movie {

    private String title;
    private int year;
    private String genre;
    private double rating;


    public Movie(String title,int year,String genres,double rating){
        this.title = title;
        this.year = year;
        this.genre = genres;
        this.rating = rating;

    }

    String getGenre(){
        return genre;
    }

    @Override
    public String toString() {
        return "Movie: " +
                "Title:'" + title + '\'' +
                ", Year:'" + year +
                ", Genere:'" + genre + '\'' +
                ", Rating:" + rating;

    }
}
