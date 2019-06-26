package ntut.csie.accountManagementService.useCase.accountManagement.modifyPersonalInformation;

import ntut.csie.accountManagementService.useCase.Output;

public interface ModifyPersonalInformationOutput extends Output{
	
	public String getOutputMessage();
	
	public void setOutputMessage(String msg);
}
