package ntut.csie.accountManagementService.useCase.accountManagement.getUserByUserId;

import ntut.csie.accountManagementService.useCase.Input;

public interface GetUserByUserIdInput extends Input{
	public String getUserId();
	
	public void setUserId(String userId);
}
