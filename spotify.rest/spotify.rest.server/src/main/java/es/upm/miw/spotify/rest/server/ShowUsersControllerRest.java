package es.upm.miw.spotify.rest.server;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import es.miw.spotify.models.daos.jpa.UserDaoJpa;
import es.spotify.models.entities.User;
import es.upm.miw.spotify.models.pojos.UserPojo;
import es.upm.miw.spotify.rest.core.uris.UrisWebApp;

@RestController
public class ShowUsersControllerRest {
	 private final static Log LOG = LogFactory
				.getLog(ShowUsersControllerRest.class);
	 
    @Autowired
    @Qualifier("beanObjectMapper")
	private ObjectMapper objectMapper;
	 
    @Autowired
	 private UserDaoJpa  userDaoJpa;
    
	@RequestMapping(value =UrisWebApp.SHOW_USERS_ALL,method = RequestMethod.GET)
    public List<UserPojo> showUsersAll(){
    	List<User> userList = userDaoJpa.findAll();
    	UserPojo userPojoList[] = null;
    	Gson gson = new Gson();
    	String json="{}";
    	try {
    		LOG.info("num users :"+userList.size());
    		List<UserPojo> userPojoList2 = new ArrayList<UserPojo>();
    		GregorianCalendar gregorianCalendar = new GregorianCalendar();
    		
    		
    		json = objectMapper.writeValueAsString(userList);
    		userPojoList=gson.fromJson(json, UserPojo[].class);
    		for(int i = 0;i<userList.size();i++){
    		//for(int i = 0;i<userList.size() && i<userPojoList2.size();i++){
//    			gregorianCalendar.set (userList.get(i).getCreateTime(). getYear(), 
//    					userList.get(i).getCreateTime().getMonthValue(),
//    					userList.get(i).getCreateTime().getDayOfMonth());
    			
    			gregorianCalendar.setTimeInMillis(userList.get(i).getCreateTime().getTimeInMillis());
    			
    			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").
    					format(gregorianCalendar.getTime()));

    			//userPojoList2.get(i).setCreateTime2(gregorianCalendar.getTimeInMillis());
    			userPojoList[i].setCreateTime2(gregorianCalendar.getTimeInMillis());
    			//System.out.println(userPojoList2.get(i).getCreateTime2());
    		}
    		LOG.info("response json:"+json);
    		} catch (Exception e) {
    			LOG.error("error response", e);
    		}
    	System.out.println("esto devuelve el rest"+Arrays.asList(userPojoList));
    	return Arrays.asList(userPojoList) ;
    }

}