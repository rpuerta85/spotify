package es.spotify.models.entities;

import java.io.Serializable;

import javax.persistence.*;



@Entity
public class Favorite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String idUUID;

	private String idFavorite;

	@ManyToOne
	@JoinColumn(name="idFavoritoType")
	private FavoriteType favoritetype;
    
	
	public Favorite() {
	}
    
	
	public Favorite(String idFavorite, FavoriteType favoritetype, String idUUID) {
		super();
		this.idFavorite = idFavorite;
		this.favoritetype = favoritetype;
		this.idUUID = idUUID;
	}

   public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdFavorite() {
		return this.idFavorite;
	}

	public void setIdFavorite(String idFavorite) {
		this.idFavorite = idFavorite;
	}

	
	public FavoriteType getFavoritetype() {
		return this.favoritetype;
	}

	public void setFavoritetype(FavoriteType favoritetype) {
		this.favoritetype = favoritetype;
	}

	public String getIdUUID() {
		return idUUID;
	}

	public void setIdUUID(String idUUID) {
		this.idUUID = idUUID;
	}
    

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((favoritetype == null) ? 0 : favoritetype.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((idFavorite == null) ? 0 : idFavorite.hashCode());
		result = prime * result + ((idUUID == null) ? 0 : idUUID.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Favorite other = (Favorite) obj;
		if (favoritetype == null) {
			if (other.favoritetype != null)
				return false;
		} else if (!favoritetype.equals(other.favoritetype))
			return false;
		if (id != other.id)
			return false;
		if (idFavorite == null) {
			if (other.idFavorite != null)
				return false;
		} else if (!idFavorite.equals(other.idFavorite))
			return false;
		if (idUUID == null) {
			if (other.idUUID != null)
				return false;
		} else if (!idUUID.equals(other.idUUID))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Favorite [id=" + id + ", idUUID=" + idUUID + ", idFavorite="
				+ idFavorite + ", favoritetype=" + favoritetype + "]";
	}
	
	
   
}