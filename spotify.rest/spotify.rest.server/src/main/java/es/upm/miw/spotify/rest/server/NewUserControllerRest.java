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
public class NewUserControllerRest {
	 private final static Log LOG = LogFactory
				.getLog(NewUserControllerRest.class);
	 
	 @Value("${rest.spotify.uri}")
	 private String spotifyRestUri;

	 @Autowired
	 private RestTemplate  restTemplate;
	
	 @Autowired
	 private UserDaoJpa  userDaoJpa;
	 
	 @Autowired
	 private RoleDaoJpa  roleDaoJpa;
	 
	 @Autowired
	 private FavoriteTypeDaoJpa  favoriteTypeDaoJpa;
	 
	 @Autowired
	 private FavoriteDaoJpa  favoriteDaoJpa;
   
    

    @RequestMapping(value=UrisWebApp.NEW_USER_URI_REST, method = RequestMethod.POST)
    @ResponseBody
    public void newUser(
			            @RequestBody UserPojo userPojo)  {
    	LOG.info("begin newUser");
    	LOG.info("newUser received: userName"+ userPojo.getUserName() + " pw " + userPojo.getPassword() 
    			+"isAdmin "+ userPojo.isAdmin() +
    			               " isEnabled: " +userPojo.isEnabled() + " email " +userPojo.getEmail() + "createTime " +userPojo.getCreateTime2());
     	List<User>  existUser = userDaoJpa.getUserByUserName(userPojo.getUserName());
  	 	LocalDateTime dateLocalDateTime = LocalDateTime.now();
    	Role role=null;

    	GregorianCalendar date = new GregorianCalendar();
    	date.setTimeInMillis(userPojo.getCreateTime2());
    	System.out.println(date);

    	if(existUser.size()>0){
    		// actualizar..
    	}
    	else{
    		
    		User userToAdd;
    		userToAdd = new User(userPojo.getUserName(), 
                                   date ,
    				             userPojo.getEmail(),
    				             userPojo.isEnabled(), 
    				             userPojo.getPassword());
    		
    		if(userPojo.isAdmin()){
    		 role= roleDaoJpa.read(1);	
    		}
    		else
    		{
    			role= roleDaoJpa.read(2);	
    		}
    		userToAdd.getUserRoles().add(role);
    		userDaoJpa.create(userToAdd);  		
    		
    	}
       	LOG.info("end newUser");

    }
}
