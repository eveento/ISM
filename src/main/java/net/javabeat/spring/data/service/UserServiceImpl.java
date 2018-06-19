package net.javabeat.spring.data.service;

import net.javabeat.spring.data.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserOwnRepository userOwnRepository;

	public User getUserById(long id) {
		return userOwnRepository.getUserById(id);
	}

	@Override
	public List<User> getAllUsers() {
		return userOwnRepository.getAllUsers();
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public void deleteUser(long id) {
		userRepository.deleteById(id);
	}
	
	public void updateEmail(long id, String email) {
		userOwnRepository.updateEmail(id,email);
	}

	@Override
	public User checkLogin(String login, String password) {
		return userOwnRepository.checkLogin(login, password);
	}

}
