package es.miw.spotify.models.models.entities;

import java.security.SecureRandom;

import org.safehaus.uuid.UUID;
import org.safehaus.uuid.UUIDGenerator;

public class GenerateUUIDUnique {
	 private static final SecureRandom secureRandom = new SecureRandom();
	 private static final UUIDGenerator generator = UUIDGenerator.getInstance();
	
	
	 public synchronized static String generateUniqueId() {
	      UUID uuid = generator.generateRandomBasedUUID(secureRandom);

	      return uuid.toString().replaceAll("-", "").toUpperCase();
	    }
	    
}
