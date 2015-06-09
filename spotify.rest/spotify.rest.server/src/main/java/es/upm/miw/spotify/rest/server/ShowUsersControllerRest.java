package es.upm.miw.spotify.rest.server;

import java.net.URLEncoder;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import es.miw.spotify.models.daos.DaoFactory;
import es.spotify.models.entities.User;
import es.upm.miw.spotify.models.pojos.AlbumsPager;
import es.upm.miw.spotify.rest.core.uris.UrisSpotifyApi;
import es.upm.miw.spotify.rest.core.uris.UrisWebApp;

@RestController
public class ShowUsersControllerRest {
	 private final static Log LOG = LogFactory
				.getLog(ShowUsersControllerRest.class);
	 
    @Autowired
    @Qualifier("beanObjectMapper")
	private ObjectMapper objectMapper;
	 
	@RequestMapping(value =UrisWebApp.SHOW_USERS_ALL,method = RequestMethod.GET)
    public /*@ResponseBody*/ List<User> showUsersAll(){
    	List<User> userList = DaoFactory.getFactory().getUserDao().findAll();
    	try {
    		String json = objectMapper.writeValueAsString(userList);
    		LOG.info("response json:"+json);
    		} catch (Exception e) {
    			LOG.error("error response", e);
    		}
    	return userList;
    }

}