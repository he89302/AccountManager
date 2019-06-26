package ntut.csie.accountManagementService.controller.accountManagement;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

import ntut.csie.accountManagementService.ApplicationContext;
import ntut.csie.accountManagementService.useCase.accountManagement.login.LoginInput;
import ntut.csie.accountManagementService.useCase.accountManagement.login.LoginOutput;
import ntut.csie.accountManagementService.useCase.accountManagement.login.LoginUseCase;

@Path("/user")
public class LoginRestfulAPI implements LoginOutput{
	private ApplicationContext applicationContext = ApplicationContext.getInstance();
	private LoginUseCase loginUseCase = applicationContext.newLoginUseCase();

	private String outputMessage;
	private String token;
	private String userId;
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public LoginOutput login(String loginInfo) {
		String username = "";
		String password = "";
		
		
		try {
			JSONObject userJSON = new JSONObject(loginInfo);
			username = userJSON.getString("username");
			password = userJSON.getString("password");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		LoginInput input = (LoginInput) loginUseCase;
		input.setUsername(username);
		input.setPassword(password);
		
		
		LoginOutput output = this;
		
		loginUseCase.execute(input, output);
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

	@Override
	public String getToken() {
		return token;
	}

	@Override
	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String getUserId() {
		return userId;
	}

	@Override
	public void setUserId(String userId) {
		this.userId = userId;
	}

	
}
