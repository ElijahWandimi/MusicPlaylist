package data;

import java.util.LinkedList;

public abstract class AddMethods {
    public abstract boolean addToPlaylist(int id, LinkedList<Song> list);
    public abstract boolean addToPlaylist(String title, LinkedList<Song> list);
}
