package SDP_assignment_1;

public class CinemaConfig {
    private static CinemaConfig instance;
    private String cinemaName;
    private int numberOfScreens;
    private String operatingHours;

    private CinemaConfig(){
        this.cinemaName = "Default cinema";
        this.numberOfScreens = 5;
        this.operatingHours = "10:00 AM - 11:00 PM";
    }
    public static CinemaConfig getInstance(){
        if (instance == null){
            instance = new CinemaConfig();
        }
        return instance;
    }
    public String getCinemaName(){
        return cinemaName;
    }
    public void setCinemaName(String cinemaName){
        this.cinemaName = cinemaName;
    }
    public int getNumberOfScreens() {
        return numberOfScreens;
    }

    public void setNumberOfScreens(int numberOfScreens) {
        this.numberOfScreens = numberOfScreens;
    }

    public String getOperatingHours() {
        return operatingHours;
    }

    public void setOperatingHours(String operatingHours) {
        this.operatingHours = operatingHours;
    }
}
