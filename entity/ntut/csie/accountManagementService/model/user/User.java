package ntut.csie.accountManagementService.model.user;

public class User {
	private String id;
	private String username;
	private String email;
	private String password;
	private String nickname;
	private String systemRole;
	
	public User() {}
	
	public User(String id, String username, String email, String password, String nickname, String systemRole) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.systemRole = systemRole;
	}
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSystemRole() {
		return systemRole;
	}

	public void setSystemRole(String systemRole) {
		this.systemRole = systemRole;
	}
	
	
}
