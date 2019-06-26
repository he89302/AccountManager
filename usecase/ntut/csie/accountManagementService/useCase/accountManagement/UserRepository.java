package ntut.csie.accountManagementService.useCase.accountManagement;

import ntut.csie.accountManagementService.model.user.User;

public interface UserRepository {
	public void save(User user);
	
	public User getUserById(String id);
	
	public User getUserByUsername(String username);
	
	public Boolean AuthenticateUser(String username, String password);
}
