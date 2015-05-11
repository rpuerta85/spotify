package es.upm.miw.spotify.models.forms;

public class FindArtistForm {
	
	private String artist;

	public FindArtistForm(String artist) {
		super();
		this.artist = artist;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	
	
}
