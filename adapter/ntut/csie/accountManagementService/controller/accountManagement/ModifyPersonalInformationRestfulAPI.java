package ntut.csie.accountManagementService.controller.accountManagement;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

import ntut.csie.accountManagementService.ApplicationContext;
import ntut.csie.accountManagementService.useCase.accountManagement.modifyPersonalInformation.ModifyPersonalInformationInput;
import ntut.csie.accountManagementService.useCase.accountManagement.modifyPersonalInformation.ModifyPersonalInformationOutput;
import ntut.csie.accountManagementService.useCase.accountManagement.modifyPersonalInformation.ModifyPersonalInformationUseCase;

@Path("/user")
public class ModifyPersonalInformationRestfulAPI implements ModifyPersonalInformationOutput{
	private ApplicationContext applicationContext = ApplicationContext.getInstance();
	private ModifyPersonalInformationUseCase modifyPersonalInformationUseCase = applicationContext.newChangePersonalInformationUseCase();
	private String outputMessage;
	
	@POST
	@Path("/modifyPersonalInformation")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ModifyPersonalInformationOutput modifyPersonalInformationOutput(String userInfo) {
		
		String userId = "";
		String email = "";
		String originalPassword = "";
		String newPassword = "";
		String nickname = "";
		
		try {
			JSONObject userJSON = new JSONObject(userInfo);
			userId = userJSON.getString("userId");
			email = userJSON.getString("email");
			originalPassword = userJSON.getString("originalPassword");
			newPassword = userJSON.getString("newPassword");
			nickname = userJSON.getString("nickname");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		ModifyPersonalInformationInput input = (ModifyPersonalInformationInput) modifyPersonalInformationUseCase;
		input.setUserId(userId);
		input.setEmail(email);
		input.setOriginalPassword(originalPassword);
		input.setNewPassword(newPassword);
		input.setNickname(nickname);
		
		ModifyPersonalInformationOutput output = this;
		
		modifyPersonalInformationUseCase.execute(input, output);
		
		return output;
	}

	@Override
	public String getOutputMessage() {
		return outputMessage;
	}

	@Override
	public void setOutputMessage(String msg) {
		this.outputMessage = msg;
	}

}
