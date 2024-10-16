package SDP_assignment_3;

public class AudioPlayer {
    interface Player{
        void play(String audioType, String fileName);
    }
    interface WAVPlayer{
        void playWAV(String fileName);
    }
    interface AACPlayer{
        void playAAC(String fileName);
    }
    class MP3Player implements Player{
        @Override
        public void play(String audioType, String fileName) {
            if (audioType.equalsIgnoreCase("mp3")) {
                System.out.println("Playing mp3 file: " + fileName);
            }
            else{
                System.out.println("Invalid media type for MP3 player. Only MP3 supported");
            }
        }
    }
    class AdvancedAudioPlayer implements WAVPlayer, AACPlayer{
        @Override
        public void playWAV(String fileName) {
            System.out.println("Playing WAV file: " + fileName);
        }
        @Override
        public void playAAC(String fileName) {
            System.out.println("Playing AAC file. Name: " + fileName);
        }
    }
    class AudioAdapter implements Player{
        AdvancedAudioPlayer advancedAudioPlayer;
        public AudioAdapter(String audioType){
            if (audioType.equalsIgnoreCase("wav")) {
                advancedAudioPlayer = new AdvancedAudioPlayer();
            }
            else if (audioType.equalsIgnoreCase("aac")) {
                advancedAudioPlayer = new AdvancedAudioPlayer();
            }
        }
        @Override
        public void play(String audioType, String fileName) {
            if (audioType.equalsIgnoreCase("wav")) {
                advancedAudioPlayer.playWAV(fileName);
            }
            else if(audioType.equalsIgnoreCase("aac")) {
                advancedAudioPlayer.playAAC(fileName);
            }
        }
    }
    class MusicPlayerApp implements Player{
        AudioAdapter audioAdapter;
        @Override
        public void play(String audioType, String fileName) {
            if (audioType.equalsIgnoreCase("mp3")) {
                new MP3Player().play(audioType, fileName);
            } else if (audioType.equalsIgnoreCase("wav") || audioType.equalsIgnoreCase("aac")) {
                audioAdapter = new AudioAdapter(audioType);
                audioAdapter.play(audioType, fileName);
            }
            else{
                System.out.println("Invalid audio type for Music player. Only MP3, WAV, AAC formats are supported");
            }
        }
    }
}
