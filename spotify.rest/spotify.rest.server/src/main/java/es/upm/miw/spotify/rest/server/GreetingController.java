package es.upm.miw.spotify.rest.server;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;


@RestController
public class GreetingController {
	@Value("${max.total.connections.default}")
	private String maxTotalConnectionsDefault;
	
	 @Autowired
	 private RestTemplate  restTemplate;
	 @Autowired
	 private MappingJackson2HttpMessageConverter converter;
	
	 
	 private final static Log LOG = LogFactory
			.getLog(GreetingController.class);
	
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) throws JsonProcessingException {
    	System.out.println(">>3"+maxTotalConnectionsDefault);
    	System.out.println(">>4"+restTemplate);
    	System.out.println(">>5"+converter);
    	
    	return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}