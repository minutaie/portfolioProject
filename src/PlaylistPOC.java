import components.map.Map;
import components.map.Map1L;
import components.sequence.Sequence;
import components.sequence.Sequence1L;

/**
 * Proof of concept of a Playlist Ordered sequence of title artist pairs
 */
public class Playlist {

    private final Sequence<Map.Pair<String, String>> songs;

    /**
     * Playlist constructor.
     */
    public Playlist() {
        this.songs = new Sequence1L<Map.Pair<String, String>>();
    }

    /**
     * Adds song to end.
     *
     * @param song
     *            - song to be added to end of playlist
     */
    public void addSong(Map.Pair<String, String> song) {
        this.songs.add(this.songs.length(), song);
    }

    /**
     * Removes first instance of a song by its title.
     *
     * @param title
     *            - the title of the song to be removed
     * @return - the title/artist pair of the removed song
     */
    public Map.Pair<String, String> removeSong(String title) {
        Map.Pair<String, String> removedSong = null;
        boolean found = false;
        int i = 0;
        while (!found && i < this.songs.length()) {
            if (this.songs.entry(i).key().equals(title)) {
                removedSong = this.songs.entry(i);
                this.songs.remove(i);
                found = true;
            }
            i++;
        }

        return removedSong;
    }

    /**
     * Returns the length of the playlist.
     *
     * @return - the length of the playlist
     */
    public final int length() {
        int length = this.songs.length();
        return length;
    }

    /**
     * Checks if a song is in the playlist.
     *
     * @param title
     *            - the song being checked if its in the playlist
     * @return - if the song is in the playlist or not
     */
    public boolean containsSong(String title) {
        boolean found = false;
        int i = 0;
        while (!found && i < this.songs.length()) {
            if (this.songs.entry(i).key().equals(title)) {
                found = true;
            }
            i++;
        }

        return found;
    }

    /**
     * Queues a song in the playlist to the front.
     *
     * @param title
     *            - title of the song to be queued to the font
     */
    public void queueToFront(String title) {
        if (this.containsSong(title)) {
            int i = 0;
            boolean found = false;
            while (!found && i < this.songs.length()) {
                if (this.songs.entry(i).key().equals(title)) {
                    found = true;
                    this.songs.add(0, this.removeSong(title));
                }
                i++;
            }
        }
    }

    /**
     * Vizualization of the playlist as a String.
     *
     *
     * @return - the String vizuilization of the playlist
     */
    @Override
    public String toString() {
        String playlistString = "[";
        for (int i = 0; i < this.songs.length(); i++) {
            playlistString += "(";
            playlistString += this.songs.entry(i).key() + " ";
            playlistString += this.songs.entry(i).value() + ")";
            if (i != this.songs.length() - 1) {
                playlistString += ", ";
            }
        }
        playlistString += "]";
        return playlistString;
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        Playlist p = new Playlist();

        Map<String, String> temp = new Map1L<>();

        temp.add("Boys Don't Cry", "The Cure");
        p.addSong(temp.removeAny());

        temp.add("Dreams", "Fleetwood Mac");
        p.addSong(temp.removeAny());

        temp.add("Heaven Knows I'm Miserable Now", "The Smiths");
        p.addSong(temp.removeAny());

        temp.add("Motion Sickness", "Phoebe Bridgers");
        p.addSong(temp.removeAny());

        System.out.println("Initial playlist:");
        System.out.println(p);
        System.out.println("Length: " + p.length());
        System.out.println();

        System.out.println("Contains 'Dreams'? " + p.containsSong("Dreams"));
        System.out.println();

        p.queueToFront("Heaven Knows I'm Miserable Now");
        System.out.println("After queueToFront:");
        System.out.println(p);
        System.out.println();

        Map.Pair<String, String> removed = p.removeSong("Dreams");
        System.out.println(
                "Removed: (" + removed.key() + " " + removed.value() + ")");
        System.out.println("After removal:");
        System.out.println(p);
        System.out.println("Length: " + p.length());
    }

}
