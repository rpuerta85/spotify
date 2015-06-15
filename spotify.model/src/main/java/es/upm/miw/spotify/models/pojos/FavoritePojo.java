package es.upm.miw.spotify.models.pojos;

import java.io.Serializable;

public class FavoritePojo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String idUUID;
	private String idFavorite;

	private FavoriteTypePojo favoritetype;
    
	
	public FavoritePojo() {
	}


	public String getIdFavorite() {
		return this.idFavorite;
	}

	public void setIdFavorite(String idFavorite) {
		this.idFavorite = idFavorite;
	}

	
	public FavoriteTypePojo getFavoritetype() {
		return this.favoritetype;
	}

	public void setFavoritetype(FavoriteTypePojo favoritetype) {
		this.favoritetype = favoritetype;
	}

	public String getIdUUID() {
		return idUUID;
	}

	public void setIdUUID(String idUUID) {
		this.idUUID = idUUID;
	}
    

	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
    


	
	
 
}