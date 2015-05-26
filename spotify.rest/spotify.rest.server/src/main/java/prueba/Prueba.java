package prueba;

import java.text.SimpleDateFormat;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;


public class Prueba{

public static void main(String args[]) throws JsonProcessingException{
	String json = "{hola:100}";
	K k = new K();
	k.setPp(12);
	//ObjectMapper converter = new ObjectMapper();
	
	MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
	ObjectMapper objectMapper = new ObjectMapper();
	SimpleModule module = new SimpleModule();
	ItemSerializer ser = new ItemSerializer();
	module.addSerializer(Item.class, ser);
	objectMapper.registerModule(module);
	converter.setObjectMapper(objectMapper);
	Item myItem = new Item(1, "theItem", new User(2, "theUser"));

	String json2 = converter.getObjectMapper().writeValueAsString(myItem);
	System.out.println(json2);
}
}