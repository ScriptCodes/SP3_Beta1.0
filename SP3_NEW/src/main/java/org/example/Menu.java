package org.example;
import java.util.ArrayList;
public class Menu {
    ArrayList<User> users = new ArrayList<>();
    ArrayList<User> newUsersList = new ArrayList<>();
    ArrayList<Movie> movies = new ArrayList<>();
    TextUI ui = new TextUI();
    Login login = new Login();
    FileIO io = new FileIO();
    String uInputUsername;
    String uInputPassword;
    boolean isAdmin = false;
    User newUsers = new User(uInputUsername, uInputPassword, isAdmin);
    User user = new User(uInputUsername, uInputPassword, isAdmin);
    private ArrayList<Movie> movieList;
    private int currentIndex;

    Movie selectedMovie;
    private boolean movieSelected = false;
    public Menu() {
        currentIndex = 0;

    }

    public void loginMenu() {
        ui.displayMsg("Welcome!");
        ui.displayMsg("1.Login" + "\n" + "2.Create new user");
        String loginOptions = ui.getInput("");
        switch (loginOptions) {
            case "1":
                ui.displayMsg("Please type your Username and password:");
                login.login(users);
                if (login.getLoggedInUser() != null) {
                    if (login.getLoggedInUser().getIsAdmin()) {
                        displayAdminOptions();
                    } else {
                        displayUserOptions();
                    }
                }
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
        ui.displayMsg("1.Watch movie" + "\n" + "2.Watch series" + "\n" + "3.Go to My Favorite Movies" + "\n" + "4.Display movies/series by genre");

        String options = ui.getInput("");

        switch (options) {
            case "1":
                displayMovies();
                break;
            case "2":
                displaySeries();
                break;
            case "3":
                displayMyFavorites();
                break;
            case "4":
                searchByGenreMovie();
                break;
            default:
                ui.displayMsg("None of the options was selected");

        }
    }

    public void displayAdminOptions() {

       /* File file = new File("src/main/java/org/example/100bedstefilm.txt");
        String aInput = ui.getInput("");*/
        ui.displayMsg("What do you want to do?: ");
        ui.displayMsg("1.Watch movie" + "\n" + "2.Watch series" + "\n" + "3.Go to My Favorite Movies" + "\n" + "4.Display movies/series by genre" + "\n" + "5.Admin panel");


        String options = ui.getInput("");

        switch (options) {
            case "1":
                displayMovies();
                break;
            case "2":
                displaySeries();
                break;
            case "3":
                displayMyFavorites();
                break;
            case "4":
                searchByGenreMovie();
                break;
            case "5":
                adminPanel();
                break;
            default:
                ui.displayMsg("None of the options was selected");

        }

    }

    public void displayMyFavorites() {
        ui.displayMsg("----------------- My Favorites -----------------");
    }

    public void displaySeries() {

        ui.displayMsg("----------------- All Series -----------------");
        ArrayList<Series> seriesList = io.readSeriesData();
        for (Series series : seriesList) {
            System.out.println(series.toString());

        }
    }

    public void displayMovies() {
        movieList = io.readMovieData();

        ui.displayMsg("----------------- All Movies -----------------");
        int pageSize = 10;

        for (int i = currentIndex; i < Math.min(currentIndex + pageSize, movieList.size()); i++) {
            System.out.println((i - currentIndex + 1) + ". " + movieList.get(i).toString());
        }

        displayNavigationOptionsMovie();
    }

    public ArrayList<Movie> searchByGenreMovie() {

        ArrayList<Movie> matchingMovie = io.readMovieData();
        ui.displayMsg("Please enter the genre you're looking for");
        String input = ui.getInput("");
        for (Movie movie : matchingMovie) {
            String[] movieGenres = movie.getGenre().split(", ");
            for (String genre : movieGenres) {
                if (input.equalsIgnoreCase(genre.trim())) {
                    System.out.println(movie);
                    break;
                }
            }
        }
        return matchingMovie;
    }
/*
    public ArrayList<Series> searchByGenreSeries() {

        ArrayList<Series> matchingSeries = io.readSeriesData();

        ui.displayMsg("Please enter the genre you're looking for");
        String input = ui.getInput("");
        for (Series series : matchingSeries) {
            String[] movieGenres = series.getGenre().split(", ");
            for (String genre : movieGenres) {
                if (input.equalsIgnoreCase(genre.trim())) {
                    System.out.println(series);
                    break;
                }
            }
        }
        return matchingSeries;
    }
*/
    public void adminPanel(){

        ui.displayMsg("1.Remove Media "+"\n"+"2.Add Media");
        String inputAdmin = ui.getInput("");
        switch (inputAdmin){

            case "1":
                //Metodekald som fjerner et media
                break;
            case "2":
                //Metodekald som adder media
                break;
            default:
                ui.displayMsg("None of the options was selected");

        }
    }

    private void displayNavigationOptionsMovie() {
        ui.displayMsg("N. Next 10 movies");
        ui.displayMsg("P. Previous 10 movies");
        ui.displayMsg("S. Select a movie");
        ui.displayMsg("E. Exit");

        String choice = ui.getInput("Enter your choice: ");

        switch (choice.toUpperCase()) {
            case "N":
                currentIndex += 10;
                break;
            case "P":
                currentIndex = Math.max(0, currentIndex - 10);
                break;
            case "S":
                selectMovie();
                // Set movieSelected to true when a movie is selected
                movieSelected = true;
                return;
            case "E":
                if (login.getLoggedInUser() != null) {
                    if (login.getLoggedInUser().getIsAdmin()) {
                        displayAdminOptions();
                    } else {
                        displayUserOptions();
                    }
                }
                break;
            default:
                ui.displayMsg("Invalid choice. Please enter a valid option.");
                return;
        }

        // Only call displayMovies() if a movie is not selected
        if (!movieSelected) {
            displayMovies();
        }
    }
    private void selectMovie() {
        int pageSize = 10;

        while (true) {
            int movieIndex = ui.getIntInput("Enter the number of the movie you want to select:");

            if (movieIndex >= 1 && movieIndex <= pageSize && currentIndex + movieIndex - 1 < movieList.size()) {
                selectedMovie = movieList.get(currentIndex + movieIndex - 1);
                ui.displayMsg("Selected Movie: " + selectedMovie.toString());
                // Optionally, you can perform additional actions with the selected movie
                currentlyPlaying();
                return; // Exit the method if a valid movie is selected
            } else {
                ui.displayMsg("Invalid movie number. Please enter a valid number.");
                break;
            }
        }
    }


    private void currentlyPlaying(){
        System.out.println("-------------------------------------");
        System.out.println("You are now watching:\n" + selectedMovie);

    }

}
