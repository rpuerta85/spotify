package es.upm.miw.spotify.rest.server;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import es.miw.spotify.models.daos.jpa.FavoriteDaoJpa;
import es.miw.spotify.models.daos.jpa.FavoriteTypeDaoJpa;
import es.miw.spotify.models.daos.jpa.RoleDaoJpa;
import es.miw.spotify.models.daos.jpa.UserDaoJpa;
import es.spotify.models.entities.Favorite;
import es.spotify.models.entities.FavoriteType;
import es.spotify.models.entities.Role;
import es.spotify.models.entities.User;
import es.upm.miw.spotify.models.pojos.UserPojo;
import es.upm.miw.spotify.rest.core.uris.UrisWebApp;

@RestController
public class DeleteUserControllerRest {
	 private final static Log LOG = LogFactory
				.getLog(DeleteUserControllerRest.class);
	 
	 @Value("${rest.spotify.uri}")
	 private String spotifyRestUri;

	 @Autowired
	 private RestTemplate  restTemplate;
	
	 @Autowired
	 private UserDaoJpa  userDaoJpa;
	 
	 @Autowired
	 private RoleDaoJpa  roleDaoJpa;
	 
	@RequestMapping(value=UrisWebApp.DELETE_USER_URI_REST, method = RequestMethod.POST)
    @ResponseBody
    public void newUser(@RequestBody UserPojo userPojo)  {
    	LOG.info("begin deleteUser");
    	LOG.info("deleteUser received: userUUId"+ userPojo.getIdUUID());
     	User  existUser = userDaoJpa.readUUID(userPojo.getIdUUID());
    	
    	if(existUser!=null){
    		 existUser.setEnabled(false);
    	       userDaoJpa.update(existUser);
    	}
       	LOG.info("end deleteUser");

    }
}
