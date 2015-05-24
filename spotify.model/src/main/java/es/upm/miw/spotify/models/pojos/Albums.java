package es.upm.miw.spotify.models.pojos;

public class Albums {
	
	private Page<Album> albums;

	public Page<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(Page<Album> albums) {
		this.albums = albums;
	}
	
}
