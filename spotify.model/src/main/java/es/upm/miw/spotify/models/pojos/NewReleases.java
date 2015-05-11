package es.upm.miw.spotify.models.pojos;

public class NewReleases {
  private Page<SimpleAlbum> albums;

  public Page<SimpleAlbum> getAlbums() {
    return albums;
  }

  public void setAlbums(Page<SimpleAlbum> albums) {
    this.albums = albums;
  }
}
