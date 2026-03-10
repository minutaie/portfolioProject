import components.map.Map;
import components.standard.Standard;

/**
 * Kernel interface for a Playlist component.
 *
 * @mathmodel type PlaylistKernel is modeled by a sequence of (title, artist)
 *            pairs.
 *
 * @initially <pre>
 * this = <>
 * </pre>
 */
public interface PlaylistKernel extends Standard<PlaylistPOC> {

    /**
     * Adds a song to the end of the playlist.
     *
     * @param song
     *            the song to add
     * @updates this
     * @requires song /= null
     * @ensures this = #this * <song>
     */
    void addSong(Map.Pair<String, String> song);

    /**
     * Removes the first song with the given title.
     *
     * @param title
     *            title of the song to remove
     * @return the removed song
     * @updates this
     * @requires title /= null and there exists i where entry(this,i).key =
     *           title
     * @ensures the returned pair has key = title and that song is no longer in
     *          this
     */
    Map.Pair<String, String> removeSong(String title);

    /**
     * Returns the number of songs in the playlist.
     *
     * @return number of songs
     * @ensures length = |this|
     */
    int length();
}