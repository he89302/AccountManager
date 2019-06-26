package ntut.csie.accountManagementService.useCase.accountManagement.login;

import ntut.csie.accountManagementService.useCase.accountManagement.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class LoginUseCaseImpl implements LoginUseCase, LoginInput{
	private UserRepository userRepository;
	
	private String username;
	private String password;
//	private Boolean systemRole; #現在還沒有 admin 的腳色;
	
	public LoginUseCaseImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public void execute(LoginInput input, LoginOutput output) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		if(userRepository.AuthenticateUser(input.getUsername(), input.getPassword())) {
			output.setOutputMessage("success");
			output.setToken(bCryptPasswordEncoder.encode(input.getUsername()));
			output.setUserId(userRepository.getUserByUsername(input.getUsername()).getId());
		} else {
			output.setOutputMessage("fail");
		}
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	
	

}
