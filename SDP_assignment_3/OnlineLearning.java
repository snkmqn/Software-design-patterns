package SDP_assignment_3;
import java.util.ArrayList;
import java.util.List;

public class OnlineLearning {
    public interface VideoLecture{
        String getInfo();
        void play();
    }
    public class RealVideoLecture implements VideoLecture{
        private String title;

        public RealVideoLecture(String title){
            this.title = title;
            loadVideo();
        }
        private void loadVideo(){
            System.out.println("Loading video: " + title + "...");
            try{
                Thread.sleep(3000);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Video loaded: " + title);
        }
        @Override
        public String getInfo() {
            return "Video: " + title;
        }

        @Override
        public void play() {
            System.out.println("Playing video: " + title);
        }
    }
    public class ProxyVideoLecture implements VideoLecture{
        private String title;
        private RealVideoLecture realVideoLecture;

        public ProxyVideoLecture(String title){
            this.title = title;
        }
        @Override
        public String getInfo() {
            return "Proxy Video: " + title;
        }
        @Override
        public void play() {
            if (realVideoLecture == null){
                realVideoLecture = new RealVideoLecture(title);
            }
            realVideoLecture.play();
        }
    }
    public static class OnlineCourse{
        private List<VideoLecture> lectures = new ArrayList<>();
        public void addLecture(VideoLecture lecture){
            lectures.add(lecture);
        }
        public void showLecturesInfo(){
            for (VideoLecture lecture : lectures){
                System.out.println(lecture.getInfo());
            }
        }
        public void playLecture(int index){
            if (index < lectures.size()){
                lectures.get(index).play();
            }
            else{
                System.out.println("No more lectures to play");
            }
        }
    }
}
