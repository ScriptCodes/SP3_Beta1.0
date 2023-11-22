package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileReader;

/**
 * @author Mads, Kevin, Daniel
 * The following class reads all data from the provided data files
 */

public class FileIO {
    Movie movie;
    File file;
    Series serie;
    ArrayList<Movie> movies = new ArrayList<>();
    ArrayList<Series> series = new ArrayList<>();

    /**
     * The following methods reads from data files
     * @return list of users created in the database
     * @throws FileNotFoundException in case the file is not read properly
     */

    public ArrayList<User> readUserData() {

        ArrayList<User> users = new ArrayList<>();

        file = new File("src/main/java/org/example/database.txt");

        try {
            Scanner scan = new Scanner(file);
            scan.nextLine();
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] userData = line.split(",");

                String username = userData[0].trim();
                String password = userData[1].trim();
                boolean isAdmin = Boolean.parseBoolean(userData[2].trim());

                User user = new User(username, password, isAdmin);
                users.add(user);
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }
        return users;
    }

    /**
     * The following method allows to save user data created
     * @param newUsersList
     * @throws IOException in case 
     */
    public void saveUserData(ArrayList<User> newUsersList) {
        try {
            Path filePath = Path.of("src/main/java/org/example/database.txt");

            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            }

            List<String> existingUsers = Files.readAllLines(filePath);

            for (User user : newUsersList) {
                existingUsers.add(user.toString());
            }

            Files.write(filePath, existingUsers);
        } catch (IOException e) {
            System.out.println("Error saving user data: " + e.getMessage());
        }
    }

    public ArrayList<Movie> readMovieData() {


        File movieFile = new File("src/main/java/org/example/100bedstefilm.txt");



        try (BufferedReader br = new BufferedReader(new FileReader(movieFile))) {
            String line;
            while ((line = br.readLine()) != null) {


                String[] parts = line.split(";");
                String title = parts[0].trim();
                int year = Integer.parseInt(parts[1].trim());
                String genres = parts[2].trim();
                double rating = Double.parseDouble(parts[3].replace(",", ".").trim());


                movie = new Movie(title, year, genres, rating);
                movies.add(movie);


            }

        } catch (IOException e) {
            System.out.println("Error reading/adding movies from text file" + e.getMessage());

        }
            return movies;
        /*for (Movie movie : movies) {
            System.out.println(movie);*/
    }


    public ArrayList<Series> readSeriesData() {


        File seriesFile = new File("src/main/java/org/example/100bedsteserier.txt");



        try (BufferedReader br = new BufferedReader(new FileReader(seriesFile))) {
            String line;
            while ((line = br.readLine()) != null) {


                String[] parts = line.split(";");

                if (parts.length >= 5) {
                    String title = parts[0].trim();


                    String[] years = parts[1].split("-");
                    int startYear, endYear;


                    if (years.length == 2) {
                        startYear = parseIntSafe(years[0].trim());
                        endYear = parseIntSafe(years[1].trim());
                    } else if (years.length == 1 && !years[0].isEmpty()) {


                        startYear = parseIntSafe(years[0].trim());
                        endYear = startYear;
                    } else {
                        System.out.println("Error reading years for series: " + title);
                        System.out.println("Problematic line: " + line);
                        continue;
                    }

                    String[] genres = parts[2].split(", ");
                    double rating = Double.parseDouble(parts[3].replace(",", ".").trim());

                    String[] seasonParts = parts[4].split(",");
                    int totalSeasons = 0;

                    for (String seasonPart : seasonParts) {
                        String[] seasonInfo = seasonPart.split("-");

                        if (seasonInfo.length != 2) {
                            System.out.println("Error reading season info for series: " + title);
                            continue;
                        }

                        int startSeason = Integer.parseInt(seasonInfo[0].trim());
                        int endSeason = Integer.parseInt(seasonInfo[0].trim());
                        totalSeasons += endSeason - startSeason + 1;
                    }
                    Series serie = new Series(title, startYear, endYear, genres, rating, totalSeasons);
                    series.add(serie);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading/adding series from text file: " + e.getMessage());
        }
        /*
        for (Series serie : series) {
            System.out.println(serie);
        }*/
        return series;
    }

    private int parseIntSafe(String s) {
        return s.isEmpty() ? 0 : Integer.parseInt(s);
    }
}