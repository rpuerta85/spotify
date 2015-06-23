package es.upm.miw.spotify.models.forms;

public class UserForm {
	
	private String userName;
	private String password;
	private boolean isAdmin;
	private boolean isEnabled;
	private String email;
	private long createTime;//in miliseconds
	
	private String msgErrorUserName;
	private String msgErrorPassword;
	private String msgErrorIsAdmin;
	private String msgErrorIsEnabled;
	private String msgErrorEmail;
	private String msgErrorCreateTime;
	
	public UserForm(String userName, String password, boolean isAdmin,
			boolean isEnabled, String email, long createTime) {
		super();
		this.userName = userName;
		this.password = password;
		this.isAdmin = isAdmin;
		this.isEnabled = isEnabled;
		this.email = email;
		this.createTime = createTime;
		this.msgErrorUserName="";
		this.msgErrorPassword="";
		this.msgErrorIsAdmin="";
		this.msgErrorIsEnabled="";
		this.msgErrorEmail="";
		this.msgErrorCreateTime="";
	}
	public UserForm() {
		super();
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public boolean isEnabled() {
		return isEnabled;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	public String getMsgErrorUserName() {
		return msgErrorUserName;
	}
	public void setMsgErrorUserName(String msgErrorUserName) {
		this.msgErrorUserName = msgErrorUserName;
	}
	public String getMsgErrorPassword() {
		return msgErrorPassword;
	}
	public void setMsgErrorPassword(String msgErrorPassword) {
		this.msgErrorPassword = msgErrorPassword;
	}
	public String getMsgErrorIsAdmin() {
		return msgErrorIsAdmin;
	}
	public void setMsgErrorIsAdmin(String msgErrorIsAdmin) {
		this.msgErrorIsAdmin = msgErrorIsAdmin;
	}
	public String getMsgErrorIsEnabled() {
		return msgErrorIsEnabled;
	}
	public void setMsgErrorIsEnabled(String msgErrorIsEnabled) {
		this.msgErrorIsEnabled = msgErrorIsEnabled;
	}
	public String getMsgErrorEmail() {
		return msgErrorEmail;
	}
	public void setMsgErrorEmail(String msgErrorEmail) {
		this.msgErrorEmail = msgErrorEmail;
	}
	public String getMsgErrorCreateTime() {
		return msgErrorCreateTime;
	}
	public void setMsgErrorCreateTime(String msgErrorCreateTime) {
		this.msgErrorCreateTime = msgErrorCreateTime;
	}
	
	
	
}
