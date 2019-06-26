package ntut.csie.accountManagementService.controller.accountManagement;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

import ntut.csie.accountManagementService.ApplicationContext;
import ntut.csie.accountManagementService.useCase.accountManagement.register.RegisterInput;
import ntut.csie.accountManagementService.useCase.accountManagement.register.RegisterOutput;
import ntut.csie.accountManagementService.useCase.accountManagement.register.RegisterUseCase;

@Path("/user")
public class RegisterRestfulAPI implements RegisterOutput{
	private ApplicationContext applicationContext = ApplicationContext.getInstance();
	private RegisterUseCase registerUseCase = applicationContext.newRegisterUseCase();
	
	private String outputMessage;
	
	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RegisterOutput register(String userInfo) {
		String username = "";
		String email = "";
		String password = "";
		String systemRole = "";
		String nickname = "";
		
		try {
			JSONObject userJSON = new JSONObject(userInfo);
			username = userJSON.getString("username");
			email = userJSON.getString("email");
			password = userJSON.getString("password");
			systemRole = userJSON.getString("systemRole");
			nickname = userJSON.getString("nickname");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		RegisterInput input = (RegisterInput) registerUseCase;
		input.setUsername(username);
		input.setEmail(email);
		input.setPassword(password);
		input.setSystemRole(systemRole);
		input.setNickname(nickname);
		
		RegisterOutput output = this;
		
		registerUseCase.execute(input, output);
		
		return output;
	}
	
	@Override
	public String getOutputMessage() {
		return outputMessage;
	}
	
	@Override
	public void setOutputMessage(String outputMessage) {
		this.outputMessage = outputMessage;
	}
}
