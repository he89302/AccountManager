package ntut.csie.accountManagementService.controller.accountManagement;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

import ntut.csie.accountManagementService.ApplicationContext;
import ntut.csie.accountManagementService.useCase.accountManagement.UserModel;
import ntut.csie.accountManagementService.useCase.accountManagement.getUserByUserId.GetUserByUserIdInput;
import ntut.csie.accountManagementService.useCase.accountManagement.getUserByUserId.GetUserByUserIdOutput;
import ntut.csie.accountManagementService.useCase.accountManagement.getUserByUserId.GetUserByUserIdUseCase;

@Path("/user")
public class GetUserByUserIdRestfulAPI implements GetUserByUserIdOutput{
	private ApplicationContext applicationContext = ApplicationContext.getInstance();
	private GetUserByUserIdUseCase getUserByUserIdUseCase = applicationContext.newGetUserByUserIdUseCase();
	
	private UserModel user;
	
	@POST
	@Path("/getUserByUserId")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GetUserByUserIdOutput getUserByUserId(String getUserByUserIdInfo) {
		String userId = "";
		
		try {
			JSONObject userJSON = new JSONObject(getUserByUserIdInfo);
			userId = userJSON.getString("userId");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		GetUserByUserIdInput input = (GetUserByUserIdInput) getUserByUserIdUseCase;
		input.setUserId(userId);
		
		
		GetUserByUserIdOutput output = this;
		
		getUserByUserIdUseCase.execute(input, output);
		
		return output;
	}
	

	@Override
	public UserModel getUser() {
		return user;
	}


	@Override
	public void setUser(UserModel user) {
		this.user = user;
	}

}
