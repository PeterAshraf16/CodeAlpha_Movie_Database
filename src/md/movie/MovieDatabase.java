package md.movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieDatabase {
    private List<movie> movies;

    // Constructor
    public MovieDatabase() {
        movies = new ArrayList<>();
    }

    // Method to add a movie
    public void addMovie(movie movie) {
        movies.add(movie);
    }

    // Method to search for movies
    public void searchMovies(String searchTerm) {
        for (movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(searchTerm) || movie.getDirector().equalsIgnoreCase(searchTerm) || movie.getGenre().equalsIgnoreCase(searchTerm)) {
                System.out.println("\n2"+movie.getTitle() + " (" + movie.getReleaseYear() + ") - Directed by " + movie.getDirector() + ", Genre: " + movie.getGenre());
            }
        }
    }

    // Method to display details of a movie
    public void displayMovieDetails(String title) {
        for (movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Title: " + movie.getTitle());
                System.out.println("Director: " + movie.getDirector());
                System.out.println("Release Year: " + movie.getReleaseYear());
                System.out.println("Genre: " + movie.getGenre());
                return;
            }
        }
        System.out.println("Movie not found.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieDatabase database = new MovieDatabase();

        // Menu
        int choice;
        do {
            System.out.println("\n"+"Welcome to the Movie Database System!");
            System.out.println("Menu:");
            System.out.println("1. Add Movie");
            System.out.println("2. Search Movies");
            System.out.println("3. Display Movie Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter movie title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter director: ");
                    String director = scanner.nextLine();
                    System.out.print("Enter release year: ");
                    int releaseYear = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter genre: ");
                    String genre = scanner.nextLine();
                    database.addMovie(new movie(title, director, releaseYear, genre));
                    break;
                case 2:
                    System.out.print("Enter search term(Movie name ,Director , Or Genre) :");
                    String searchTerm = scanner.nextLine();
                    database.searchMovies(searchTerm);
                    break;
                case 3:
                    System.out.print("Enter movie title: ");
                    String movieTitle = scanner.nextLine();
                    database.displayMovieDetails(movieTitle);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
