package ntut.csie.accountManagementService.useCase.accountManagement.getUserByUserId;

import ntut.csie.accountManagementService.useCase.Output;
import ntut.csie.accountManagementService.useCase.accountManagement.UserModel;

public interface GetUserByUserIdOutput extends Output{
	
	public UserModel getUser();
	
	public void setUser(UserModel user);
}
