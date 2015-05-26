package prueba;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;


public class ItemSerializer extends JsonSerializer<Item> {
    public void serialize(Item value, JsonGenerator jgen, SerializerProvider provider) 
      throws IOException, JsonProcessingException {
        jgen.writeStartObject();
        jgen.writeStringField("id", String.valueOf(value.id));
        jgen.writeStringField("itemName", value.itemName);
        jgen.writeNumberField("owner", value.owner.id);
        jgen.writeEndObject();
    }



    
    // para usarlo
    /*
     * 
     * 
     * Item myItem = new Item(1, "theItem", new User(2, "theUser"));
ObjectMapper mapper = new ObjectMapper();
 
SimpleModule module = new SimpleModule();
module.addSerializer(Item.class, new ItemSerializer());
mapper.registerModule(module);
 
String serialized = mapper.writeValueAsString(myItem);
     * 
     * */
}