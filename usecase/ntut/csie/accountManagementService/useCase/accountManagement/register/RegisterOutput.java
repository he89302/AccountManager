package ntut.csie.accountManagementService.useCase.accountManagement.register;

import ntut.csie.accountManagementService.useCase.Output;

public interface RegisterOutput extends Output{
	public String getOutputMessage();
	
	public void setOutputMessage(String outputMessage);
}
