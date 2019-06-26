package ntut.csie.accountManagementService.useCase.accountManagement.register;

import ntut.csie.accountManagementService.useCase.Input;

public interface RegisterInput extends Input{
	public String getUsername();

	public void setUsername(String username);

	public String getEmail();

	public void setEmail(String email);

	public String getPassword();

	public void setPassword(String password);

	public String getNickname();

	public void setNickname(String nickname);

	public String getSystemRole();

	public void setSystemRole(String systemRole);
}
