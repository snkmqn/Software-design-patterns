package SDP_assignment_1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        setupCinema();
        createMovie();
        userInterface();
        bookTicket();
        setTimetable();
    }
    public static void setupCinema(){
        //Singleton realization
        CinemaConfig cinemaconfig = CinemaConfig.getInstance();
        cinemaconfig.setCinemaName("Oppenheimer");
        cinemaconfig.setNumberOfScreens(10);
        cinemaconfig.setOperatingHours("09:00 AM - 12:00 PM");

        System.out.println(cinemaconfig.getCinemaName());
        System.out.println(cinemaconfig.getNumberOfScreens());
        System.out.println(cinemaconfig.getOperatingHours());
    }
    public static void createMovie() {
        //Factory method realization
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose the type of movie you want to create:");
        System.out.println("1. Regular Movie");
        System.out.println("2. IMAX Movie");
        System.out.println("3. 3D Movie");

        String choice = scanner.nextLine();
        System.out.print("Enter the movie title: ");
        String title = scanner.nextLine();

        MovieCreation.MovieFactory factory = null;
        switch (choice) {
            case "1":
                factory = new MovieCreation.RegularMovieFactory();
                break;
            case "2":
                factory = new MovieCreation.IMAXMovieFactory();
                break;
            case "3":
                factory = new MovieCreation.ThreeDMovieFactory();
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        MovieCreation.Movie movie = factory.createMovie(title);
        System.out.println(movie.getInfo());
    }
    public static void userInterface(){
        // Abstract factory method realization
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose UI Theme: ");
        System.out.println("1. Dark Theme");
        System.out.println("2. Light Theme");
        String choice = scanner.nextLine();

        UIG.UIFactory uiFactory;
        switch (choice) {
            case "1":
                uiFactory = new UIG.DarkThemeFactory();
                break;
            case "2":
                uiFactory = new UIG.LightThemeFactory();
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Light Theme.");
                uiFactory = new UIG.LightThemeFactory();
                break;
        }

        UIG.Button button = uiFactory.createButton();
        UIG.TextField textField = uiFactory.createTextField();

        button.paint();
        textField.render();
    }
    public static void bookTicket(){
        // Builder realization
        TicketBooking booking = new TicketBooking.TicketBookingBuilder().
                setMovieTitle("Inception").setSeatNumber("14").
                setSnackCombo("Popcorn and soda").build();
        System.out.println(booking.toString());
    }
    public static void setTimetable(){
        // Prototype realization
        MovieSchedule.StandardSchedule templateSchedule = new MovieSchedule.StandardSchedule("Inception", "14:00 AM - 12:00 PM");
        System.out.println("Template schedule: " + templateSchedule);

        MovieSchedule.StandardSchedule morningSchedule = (MovieSchedule.StandardSchedule) templateSchedule.clone();
        morningSchedule.setTime("10:00 AM - 12:00 AM");
        System.out.println("Morning schedule: " + morningSchedule);

        System.out.println("Original schedule (unchanged): " + templateSchedule);
    }
}
