package ntut.csie.accountManagementService.useCase.accountManagement.login;

import ntut.csie.accountManagementService.useCase.Output;

public interface LoginOutput extends Output{
	
	public String getOutputMessage();
	
	public void setOutputMessage(String outputMessage);
	
	public String getToken();
	
	public void setToken(String token);
	
	public String getUserId();
	
	public void setUserId(String userId);
	
}
