package ntut.csie.accountManagementService;

import ntut.csie.accountManagementService.gateways.repository.accountManagement.MySqlUserRepositoryImpl;
import ntut.csie.accountManagementService.useCase.accountManagement.UserRepository;
import ntut.csie.accountManagementService.useCase.accountManagement.getUserByUserId.GetUserByUserIdUseCase;
import ntut.csie.accountManagementService.useCase.accountManagement.getUserByUserId.GetUserByUserIdUseCaseImpl;
import ntut.csie.accountManagementService.useCase.accountManagement.login.LoginUseCase;
import ntut.csie.accountManagementService.useCase.accountManagement.login.LoginUseCaseImpl;
import ntut.csie.accountManagementService.useCase.accountManagement.modifyPersonalInformation.ModifyPersonalInformationUseCase;
import ntut.csie.accountManagementService.useCase.accountManagement.modifyPersonalInformation.ModifyPersonalInformationUseCaseImpl;
import ntut.csie.accountManagementService.useCase.accountManagement.register.RegisterUseCase;
import ntut.csie.accountManagementService.useCase.accountManagement.register.RegisterUseCaseImpl;

public class ApplicationContext {
	private static ApplicationContext instance = null;
	
	private UserRepository userRepository;
	
	private RegisterUseCase registerUseCase;

	private LoginUseCase loginUseCase;
	
	private GetUserByUserIdUseCase getUserByUserIdUseCase;

	private ModifyPersonalInformationUseCase changePersonalInformationUseCase;
	
	private ApplicationContext() {}
	
	public static synchronized ApplicationContext getInstance() {
		if(instance == null){
			return new ApplicationContext();
		}
		return instance;
	}
	
	public UserRepository newUserRepository() {
		userRepository = new MySqlUserRepositoryImpl();
		return userRepository;
	}
	
	public RegisterUseCase newRegisterUseCase() {
		registerUseCase = new RegisterUseCaseImpl(newUserRepository());
		return registerUseCase;
	}

	public LoginUseCase newLoginUseCase() {
		loginUseCase = new LoginUseCaseImpl(newUserRepository());
		return loginUseCase;
	}
	
	public GetUserByUserIdUseCase newGetUserByUserIdUseCase() {
		getUserByUserIdUseCase = new GetUserByUserIdUseCaseImpl(newUserRepository());
		return getUserByUserIdUseCase;
	}

	public ModifyPersonalInformationUseCase newChangePersonalInformationUseCase() {
		changePersonalInformationUseCase = new ModifyPersonalInformationUseCaseImpl(newUserRepository());
		return changePersonalInformationUseCase;
	}
}
