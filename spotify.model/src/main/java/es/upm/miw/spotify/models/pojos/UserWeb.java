package es.upm.miw.spotify.models.pojos;

import java.io.Serializable;
import java.util.List;

public class UserWeb implements Serializable {
	private static final long serialVersionUID = -5056147181144824295L;
	
	private Integer id;
	
	private String idUUID;
	
	private String userName;
	
	private long createTimeInMilis;
	
	private String email;
	
	private boolean enabled;

	private String password;

	private String name;

	private String surname;

	private String picture;

	private String phone;

	private String phoneRegion;

	private Boolean qos;

	private List<es.upm.miw.spotify.models.pojos.Role> userRoles;
	
	public UserWeb() {
		super();
	}

	public UserWeb(String username, String password) {
		this.userName = username;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String newEmail) {
		email = newEmail;
	}

	public String getName() {
		return name;
	}

	public void setName(final String newName) {
		name = newName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(final String newSurname) {
		surname = newSurname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String newPassword) {
		password = newPassword;
	}


	public String getPhone() {
		return phone;
	}

	public void setPhone(final String newPhone) {
		phone = newPhone;
	}

	public String getPhoneRegion() {
		return phoneRegion;
	}

	public void setPhoneRegion(final String newPhoneRegion) {
		phoneRegion = newPhoneRegion;
	}

	public Boolean getQos() {
		return qos;
	}

	public void setQos(final Boolean newQos) {
		qos = newQos;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdUUID() {
		return idUUID;
	}

	public void setIdUUID(String idUUID) {
		this.idUUID = idUUID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getCreateTimeInMilis() {
		return createTimeInMilis;
	}

	public void setCreateTimeInMilis(long createTimeInMilis) {
		this.createTimeInMilis = createTimeInMilis;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<es.upm.miw.spotify.models.pojos.Role> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<es.upm.miw.spotify.models.pojos.Role> userRoles) {
		this.userRoles = userRoles;
	}

	
	

}
