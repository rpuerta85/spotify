package es.upm.miw.spotify.models.pojos;

import java.io.Serializable;

public class FavoriteTypePojo implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String idUUID;

	
	private String description;

	
	public FavoriteTypePojo() {
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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