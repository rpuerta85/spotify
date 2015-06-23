package es.upm.miw.spotify.models.pojos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class UserPojo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String idUUID;
	private String userName;
	private long createTime2;
	private String email;
	private boolean enabled;
	private String password;
	private List<FavoritePojo> favorites;
	private List<Role> userRoles;
	private boolean isAdmin;
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<FavoritePojo> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<FavoritePojo> favorites) {
		this.favorites = favorites;
	}

	public List<Role> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<Role> userRoles) {
		this.userRoles = userRoles;
	}

	public String getUserName() {
		return userName;
	}


	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getCreateTime2() {
		return createTime2;
	}

	public void setCreateTime2(long createTime2) {
		this.createTime2 = createTime2;
	}
	



}