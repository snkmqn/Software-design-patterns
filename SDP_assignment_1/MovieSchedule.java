package SDP_assignment_1;

public class MovieSchedule {
    public interface Schedule extends Cloneable{
        Schedule clone();
    }
    public static class StandardSchedule implements Schedule {
        private String title;
        private String time;

        public StandardSchedule(String title, String time) {
            this.title = title;
            this.time = time;
        }

        @Override
        public Schedule clone() {
            try{
                return (Schedule) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException("Failed to clone StandardSchedule", e);
            }
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "Movie: " + title + ", Time: " + time;
        }
    }
}

