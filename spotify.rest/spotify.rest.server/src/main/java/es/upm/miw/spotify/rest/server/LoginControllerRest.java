package es.upm.miw.spotify.rest.server;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.miw.spotify.models.daos.jpa.UserDaoJpa;
import es.spotify.models.entities.Role;
import es.spotify.models.entities.User;
import es.upm.miw.spotify.models.pojos.UserWeb;
import es.upm.miw.spotify.rest.core.uris.UrisWebApp;

@RestController
public class LoginControllerRest {
	 private final static Log LOG = LogFactory
				.getLog(LoginControllerRest.class);
	 
    @Autowired
    @Qualifier("beanObjectMapper")
	private ObjectMapper objectMapper;
	 
    @Autowired
	 private UserDaoJpa  userDaoJpa;
    
	 @RequestMapping(value =UrisWebApp.LOGIN_USER,method = RequestMethod.POST)
    public UserWeb loginRest(@RequestParam(value="userName") String userName,
    		@RequestParam(value="password") String password){
    	//System.out.println(userName);
    	//System.out.println(password);
    	List<User> userList = userDaoJpa.getUserByUserNameAndPassword(userName, password);
    	
    	UserWeb userWeb = null;
    	if(userList.size()!=0){
	    	try {
				userWeb = objectMapper.readValue(objectMapper.writeValueAsString(userList.get(0)),UserWeb.class);
				userWeb.setCreateTimeInMilis(parseLocalDateTimeToTimeStamp(userList.get(0).getCreateTime()));
				userWeb.setUserRoles(parseListEntityRolesToListgRoles(userList.get(0).getUserRoles()));
			} catch (IOException e) {
				LOG.error("Error in parsing USER DAO to User Web");
				e.printStackTrace();
			}
    	}
    
		return userWeb;
    
    }

    private long parseLocalDateTimeToTimeStamp(LocalDateTime 
    		localDateTime){
    	GregorianCalendar gregorianCalendar = new GregorianCalendar();
    	gregorianCalendar.set(localDateTime.getYear(), localDateTime.getMonthValue()-1, localDateTime.getDayOfMonth());
    	return gregorianCalendar.getTimeInMillis();
    }
    private List<es.upm.miw.spotify.models.pojos.Role> parseListEntityRolesToListgRoles(List<Role> userRoles){
    	List<es.upm.miw.spotify.models.pojos.Role> userRolesString = new ArrayList<es.upm.miw.spotify.models.pojos.Role>();
    	for(Role role : userRoles){
    		userRolesString.add(new es.upm.miw.spotify.models.pojos.Role("ROLE_"+role.getRole(), role.getIdUUID()));
    	}
    	return userRolesString;
    }
   

}