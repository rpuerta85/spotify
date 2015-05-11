package es.upm.miw.spotify.models.utils;

import org.codehaus.jackson.map.ObjectMapper;

public class ObjectMapperJacksonSingleton {

	private static ObjectMapperJacksonSingleton singleton = null;
	private ObjectMapper objectMapper;

	private ObjectMapperJacksonSingleton() {
		super();
		objectMapper = new ObjectMapper();
	}

	public static ObjectMapperJacksonSingleton getInstance() {
		if (singleton == null) {
			singleton = new ObjectMapperJacksonSingleton();
		}
		return singleton;

	}

	public ObjectMapper getObjectMapper() {
		return objectMapper;
	}

}
