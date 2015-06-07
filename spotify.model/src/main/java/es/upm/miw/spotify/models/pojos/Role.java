package es.upm.miw.spotify.models.pojos;

import java.io.Serializable;

public class Role implements Serializable {
	private static final long serialVersionUID = 1L;
	private String idUUID;
	private String role;
	
	public Role() {
	}

	
	public Role(String role,String idUUID) {
		super();
		this.role = role;
		this.idUUID =   idUUID;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	public String getIdUUID() {
		return idUUID;
	}

	public void setIdUUID(String idUUID) {
		this.idUUID = idUUID;
	}

   
}