package es.upm.miw.spotify.models.pojos;

/**
 * <a href="https://developer.spotify.com/web-api/object-model/#playlist-track-object">Playlist track object model</a>
 */
public class PlaylistTrack {
    public String added_at;
    public UserSimple added_by;
    public Track track;
}
