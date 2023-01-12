import data.Album;
import data.Song;

import java.util.*;

public class Main {
    private  static final ArrayList<Album> albums = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Album album = new Album("Album1", "AC/DC");
        LinkedList<Song> playlist_1 = new LinkedList<>();

        album.addSong("TNT", 4.5);
        album.addSong("Highway to hell", 5.5);
        album.addSong("ThunderStruck", 3.5);
        albums.add(album);

        album = new Album("Album2", "Eminem");
        album.addSong("rap God", 4.6);
        album.addSong("Guts over fear", 5.0);
        album.addSong("Not afraid", 3.0);
        album.addSong("Lose yourself", 3.5);
        albums.add(album);

        albums.get(0).addToPlaylist("TNT", playlist_1);
        albums.get(0).addToPlaylist("Highway to hell", playlist_1);
        albums.get(1).addToPlaylist("Guts over fear", playlist_1);
        albums.get(1).addToPlaylist("Rap God", playlist_1);

        play(playlist_1);

    }

    private static void play(LinkedList<Song> playlist) {
        ListIterator<Song> listIterator = playlist.listIterator();
        if (playlist.size() == 0) {
            System.out.println("Empty playlist");
        } else {
            System.out.println("Now playing: " + listIterator.next().toString());
            displayMenu();
        }

        boolean quit = false;
        boolean forward = true;

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0 -> {
                    System.out.println("Exiting...");
                    quit = true;
                    System.exit(0);
                }
                case 1 -> {
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("Playlist exhausted");
                        forward = false;
                    }
                }
                case 2 -> {
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("No previous songs");
                    }
                }
                case 3 -> {
                    if (listIterator.hasPrevious()) {
                        System.out.println("Replaying " + listIterator.previous().toString());
                        forward = false;
                    } else {
                        System.out.println("This is the first song");
                    }
//                    if (listIterator.hasNext()) {
//                        System.out.println("Replaying " + listIterator.next().toString());
//                        forward = true;
//                    } else {
//                        System.out.println("End of list");
//                    }
                }
                case 4 -> displayList(playlist);
                case 5 -> displayMenu();
                case 6 -> {
                    if (playlist.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next().toString());
                        }else {
                            if (listIterator.hasPrevious()) {
                                System.out.println("Now playing " + listIterator.previous().toString());
                            }
                        }
                    }
                }
            }
        }
    }


    private static void displayMenu() {
        System.out.println("*".repeat(20) + "\nOptions: \n Press");
        System.out.println("""
                0 - to quit
                1 - to play nest song
                2 - to play previous song
                3 - to replay current song
                4 - display all songs
                5 - display all available songs
                6 - delete current song
                """);
    }


    private static void displayList(LinkedList<Song> playlist) {
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("-".repeat(20));
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("-".repeat(20));
    }
}