package data;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album  extends AddMethods{
    private String title, artist;
    private ArrayList<Song> songs;

    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }
    public Album() {}

    private Song isSongExisting(String title) {
        for (Song checkedSong : songs) {
            if (checkedSong.getTitle().equals(title)) return checkedSong;
        }
        return null;
    }

    public boolean addSong(String title, double duration) {
        if (isSongExisting(title) == null) {
            songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    @Override
    public boolean addToPlaylist(int trackNumber, LinkedList<Song> PlayList) {
        int index = trackNumber -1;
        if (index > 0 && index <= this.songs.size()) {
            return PlayList.add(this.songs.get(index));
        }
        return false;
    }
    @Override
    public boolean addToPlaylist(String title, LinkedList<Song> PlayList) {
        for (Song checkedSong: this.songs) {
            if (checkedSong.getTitle().equals(title)) {
                return PlayList.add(checkedSong);
            }
        }
        return false;
    }

}
