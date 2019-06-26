package ntut.csie.accountManagementService.useCase.accountManagement;

import ntut.csie.accountManagementService.model.user.User;

public class ConvertUserToDTO {
	public static UserModel transform(User user) {
		UserModel dto = new UserModel();
		dto.setId(user.getId());
		dto.setUserName(user.getUsername());
		dto.setEmail(user.getEmail());
		dto.setPassword(user.getPassword());
		dto.setNickname(user.getNickname());
		dto.setSystemRole(user.getSystemRole());
		return dto;
	}
}
