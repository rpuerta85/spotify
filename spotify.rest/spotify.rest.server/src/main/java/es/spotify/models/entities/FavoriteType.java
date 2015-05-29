package es.spotify.models.entities;

import java.io.Serializable;

import javax.persistence.*;

import es.miw.spotify.models.entities.utils.GenerateUUIDUnique;


@Entity
public class FavoriteType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String idUUID;

	
	private String description;

	
	public FavoriteType() {
	}
    
	
	public FavoriteType(String description) {
		super();
	    this.description = description;
		this.idUUID =   GenerateUUIDUnique.generateUniqueId();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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


	@Override
	public String toString() {
		return "FavoriteType [id=" + id + ", idUUID=" + idUUID
				+ ", description=" + description + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
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
		FavoriteType other = (FavoriteType) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (idUUID == null) {
			if (other.idUUID != null)
				return false;
		} else if (!idUUID.equals(other.idUUID))
			return false;
		return true;
	}

   
}