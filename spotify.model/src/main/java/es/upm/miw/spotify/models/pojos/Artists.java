package es.upm.miw.spotify.models.pojos;

public class Artists {
	
	private Page<Artist> artists;

	public Page<Artist> getArtists() {
		return artists;
	}

	public void setArtists(Page<Artist> artists) {
		this.artists = artists;
	}
	
}
