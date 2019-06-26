package ntut.csie.accountManagementService.useCase.accountManagement.register;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ntut.csie.accountManagementService.model.user.User;
import ntut.csie.accountManagementService.model.user.UserBuilder;
import ntut.csie.accountManagementService.useCase.accountManagement.UserRepository;

public class RegisterUseCaseImpl implements RegisterUseCase, RegisterInput{
	private UserRepository userRepository;
	
	private String username;
	private String email;
	private String password;
	private String nickname;
	private String systemRole;
	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	
	public RegisterUseCaseImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public void execute(RegisterInput input, RegisterOutput output) {
		User user = userRepository.getUserByUsername(input.getUsername());
		if(user==null) {
			user = UserBuilder.newInstance()
					.username(input.getUsername())
					.email(input.getEmail())
					.password(bCryptPasswordEncoder.encode(input.getPassword()))
					.nickname(input.getNickname())
					.systemRole(input.getSystemRole())
					.build();
			userRepository.save(user);
			output.setOutputMessage("Thank you! Your registration was successful!");
		}
		else {
			output.setOutputMessage("Duplicate username!");
			//throw new RuntimeException("Duplicate userName");
			
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
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getNickname() {
		return nickname;
	}

	@Override
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String getSystemRole() {
		return systemRole;
	}

	@Override
	public void setSystemRole(String systemRole) {
		this.systemRole = systemRole;
	}

}
