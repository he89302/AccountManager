package ntut.csie.accountManagementService.useCase.accountManagement.modifyPersonalInformation;

import ntut.csie.accountManagementService.useCase.Input;

public interface ModifyPersonalInformationInput extends Input{
	
	public void setUserId(String userId);
	
	public String getUserId();
	
	public void setOriginalPassword(String originalPassword);
	
	public String getOriginalPassword();
	
	public void setNewPassword(String newPassword);
	
	public String getNewPassword();
	
	public String getEmail();

	public void setEmail(String email);
	
	public String getNickname();

	public void setNickname(String nickname);
}
