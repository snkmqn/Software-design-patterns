package SDP_assignment_1;


public class MovieCreation {

    interface Movie {
        String getInfo();
    }

    static class RegularMovie implements Movie {
        private String title;

        public RegularMovie(String title) {
            this.title = title;
        }

        @Override
        public String getInfo() {
            return "Regular Movie: " + title;
        }
    }

    static class IMAXMovie implements Movie {
        private String title;

        public IMAXMovie(String title) {
            this.title = title;
        }

        @Override
        public String getInfo() {
            return "IMAX Movie: " + title;
        }
    }

    static class ThreeDMovie implements Movie {
        private String title;

        public ThreeDMovie(String title) {
            this.title = title;
        }

        @Override
        public String getInfo() {
            return "3D Movie: " + title;
        }
    }

    abstract static class MovieFactory {
        public abstract Movie createMovie(String title);
    }

    static class RegularMovieFactory extends MovieFactory {
        @Override
        public Movie createMovie(String title) {
            return new RegularMovie(title);
        }
    }

    static class IMAXMovieFactory extends MovieFactory {
        @Override
        public Movie createMovie(String title) {
            return new IMAXMovie(title);
        }
    }

    static class ThreeDMovieFactory extends MovieFactory {
        @Override
        public Movie createMovie(String title) {
            return new ThreeDMovie(title);
        }
    }
}
