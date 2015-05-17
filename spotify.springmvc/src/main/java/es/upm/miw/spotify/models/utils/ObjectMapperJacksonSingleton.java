package es.upm.miw.spotify.models.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;



public class ObjectMapperJacksonSingleton {

	private static ObjectMapperJacksonSingleton singleton = null;
	private ObjectMapper objectMapper;

	private ObjectMapperJacksonSingleton() {
		super();
		objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature. WRITE_ENUMS_USING_TO_STRING);
		objectMapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
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
