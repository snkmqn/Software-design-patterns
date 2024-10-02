package SDP_assignment_1;

public class TicketBooking {
    private String movieTitle;
    private String seatNumber;
    private String snackCombo;

    private TicketBooking(){}

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getSnackCombo() {
        return snackCombo;
    }

    public String toString(){
        return "TicketBooking {" +
                "movieTitle='" + movieTitle + '\'' +
                ", seatNumber='" + seatNumber + '\'' +
                ", snackCombo='" + snackCombo + '\'' +
                '}';
    }
    public static class TicketBookingBuilder {
        private String movieTitle;
        private String seatNumber;
        private String snackCombo;

        public TicketBookingBuilder setMovieTitle(String movieTitle) {
            this.movieTitle = movieTitle;
            return this;
        }

        public TicketBookingBuilder setSeatNumber(String seatNumber) {
            this.seatNumber = seatNumber;
            return this;
        }

        public TicketBookingBuilder setSnackCombo(String snackCombo) {
            this.snackCombo = snackCombo;
            return this;
        }
        public TicketBooking build(){
            TicketBooking ticketbooking = new TicketBooking();
            ticketbooking.movieTitle = this.movieTitle;
            ticketbooking.seatNumber = this.seatNumber;
            ticketbooking.snackCombo = this.snackCombo;
            return ticketbooking;
        }
    }
}
