package SDP_assignment_4;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlaylistManagement {
    class Song {
        private String title;
        private String artist;
        private String genre;

        public Song(String title, String artist, String genre) {
            this.title = title;
            this.artist = artist;
            this.genre = genre;
        }

        public String getTitle() {
            return title;
        }

        public String getArtist() {
            return artist;
        }

        public String getGenre() {
            return genre;
        }

        @Override
        public String toString() {
            return title + " by " + artist + " [" + genre + "]";
        }
    }

    class Playlist {
        private List<Song> songs;

        public Playlist() {
            this.songs = new ArrayList<>();
        }

        public void addSong(Song song) {
            songs.add(song);
        }

        public Iterator<Song> createSequentialIterator() {
            return new SequentialIterator(songs);
        }

        public Iterator<Song> createShuffleIterator() {
            return new ShuffleIterator(songs);
        }

        public Iterator<Song> createGenreFilterIterator(String genre) {
            return new GenreFilterIterator(songs, genre);
        }
    }
    class SequentialIterator implements Iterator<Song> {
        private List<Song> songs;
        private int position = 0;

        public SequentialIterator(List<Song> songs) {
            this.songs = songs;
        }

        @Override
        public boolean hasNext() {
            return position < songs.size();
        }

        @Override
        public Song next() {
            return songs.get(position++);
        }
    }
    class ShuffleIterator implements Iterator<Song> {
        private List<Song> shuffledSongs;
        private int position = 0;

        public ShuffleIterator(List<Song> songs) {
            this.shuffledSongs = new ArrayList<>(songs);
            Collections.shuffle(shuffledSongs);
        }

        @Override
        public boolean hasNext() {
            return position < shuffledSongs.size();
        }

        @Override
        public Song next() {
            return shuffledSongs.get(position++);
        }
    }
    class GenreFilterIterator implements Iterator<Song> {
        private List<Song> songs;
        private String genre;
        private int position = 0;

        public GenreFilterIterator(List<Song> songs, String genre) {
            this.songs = songs;
            this.genre = genre;
        }

        @Override
        public boolean hasNext() {
            while (position < songs.size()) {
                if (songs.get(position).getGenre().equalsIgnoreCase(genre)) {
                    return true;
                }
                position++;
            }
            return false;
        }

        @Override
        public Song next() {
            return songs.get(position++);
        }
    }
}
