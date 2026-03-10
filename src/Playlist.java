/**
 * Enhanced Playlist interface with additional methods built on top of the
 * kernel methods.
 */
public interface Playlist extends PlaylistKernel {

    /**
     * Checks if a song with the given title exists in the playlist.
     *
     * @param title
     *            song title
     * @return true if the song exists
     * @requires title /= null
     */
    boolean containsSong(String title);

    /**
     * Moves the song with the given title to the front of the playlist.
     *
     * @param title
     *            title of the song
     * @updates this
     * @requires title /= null and there exists a song in this with key = title
     * @ensures that song is now the first entry in this
     */
    void queueToFront(String title);
}