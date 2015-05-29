package es.miw.spotify.models.entities.utils;

import java.security.SecureRandom;

import org.safehaus.uuid.UUID;
import org.safehaus.uuid.UUIDGenerator;

public class GenerateUUIDUnique {
	 private String idUUID;
	 private static final SecureRandom secureRandom = new SecureRandom();
	 private static final UUIDGenerator generator = UUIDGenerator.getInstance();
	
	
	 public GenerateUUIDUnique() {
		super();
		setIdUUID();
	}


	private void setIdUUID() {
		this.idUUID=  GenerateUUIDUnique.generateUniqueId();
	}
	public String getIdUUID() {
		return idUUID;
	}


	public synchronized static String generateUniqueId() {
	      UUID uuid = generator.generateRandomBasedUUID(secureRandom);

	      return uuid.toString().replaceAll("-", "").toUpperCase();
	    }


	@Override
	public String toString() {
		return "GenerateUUIDUnique [idUUID=" + idUUID + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		GenerateUUIDUnique other = (GenerateUUIDUnique) obj;
		if (idUUID == null) {
			if (other.idUUID != null)
				return false;
		} else if (!idUUID.equals(other.idUUID))
			return false;
		return true;
	}
	    
}
