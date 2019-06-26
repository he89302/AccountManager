package ntut.csie.accountManagementService.useCase.accountManagement.modifyPersonalInformation;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ntut.csie.accountManagementService.model.user.User;
import ntut.csie.accountManagementService.useCase.accountManagement.UserRepository;

public class ModifyPersonalInformationUseCaseImpl implements ModifyPersonalInformationInput, ModifyPersonalInformationUseCase{
	
	private UserRepository userRepository;
	private String userId;
	private String originalPassword;
	private String newPassword;
	private String email;
	private String nickname;
	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	
	
	public ModifyPersonalInformationUseCaseImpl(UserRepository repository) {
		this.userRepository = repository;
	}

	@Override
	public void execute(ModifyPersonalInformationInput input, ModifyPersonalInformationOutput output) {
		User user = userRepository.getUserById(input.getUserId());
		if(userRepository.AuthenticateUser(user.getUsername(), input.getOriginalPassword())) {
			user.setPassword(bCryptPasswordEncoder.encode(input.getNewPassword()));
			user.setEmail(input.getEmail());
			user.setNickname(input.getNickname());
			userRepository.save(user);
			
			output.setOutputMessage("Modify Complete.");
		} else {
			output.setOutputMessage("Password error.");
		}
	}

	@Override
	public void setOriginalPassword(String originalPassword) {
		this.originalPassword = originalPassword;
	}

	@Override
	public String getOriginalPassword() {
		return originalPassword;
	}

	@Override
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@Override
	public String getNewPassword() {
		return newPassword;
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
	public String getNickname() {
		return nickname;
	}

	@Override
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String getUserId() {
		return userId;
	}

}
